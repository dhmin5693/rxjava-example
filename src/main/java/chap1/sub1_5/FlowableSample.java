package chap1.sub1_5;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscription;

public class FlowableSample {

    public static void main(String[] args) throws InterruptedException {

        Flowable<String> flowable = Flowable.create(emitter -> {

            String[] data = {"Hello, World!", "This is RxJava"};

            for (String s : data) {
                if (emitter.isCancelled()) {
                    return;
                }

                emitter.onNext(s);
            }

            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);

        flowable.observeOn(Schedulers.computation())
                .subscribe(new SubscribeImpl());

        Thread.sleep(1000L);
    }

    private static class SubscribeImpl implements FlowableSubscriber<String> {

        private Subscription subscription;

        @Override
        public void onSubscribe(@NonNull Subscription s) {
            subscription = s;
            subscription.request(1L);
        }

        @Override
        public void onNext(String s) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": " + s);
            subscription.request(1L);
        }

        @Override
        public void onError(Throwable t) {
            t.printStackTrace();
        }

        @Override
        public void onComplete() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": complete");
        }
    }
}
