package chap3.sub3_3;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class RetrySample {

    public static void main(String[] args) throws Exception {

        var flowable = Flowable.<Integer>create(emitter -> {
            System.out.println("start flowable");

            for (int i = 1; i <= 3; i++) {
                if (i == 2) {
                    throw new Exception("i == 2 예외 발생");
                }
                emitter.onNext(i);
            }

            emitter.onComplete();
            System.out.println("end flowable");
        }, BackpressureStrategy.BUFFER)
                               .doOnSubscribe(s -> System.out.println("Flowable::doOnSubscription"))
                               .retry(2);

        flowable.subscribe(new IntegerSubscribe());
    }

    private static class IntegerSubscribe implements Subscriber<Integer> {

        @Override
        public void onSubscribe(Subscription s) {
            System.out.println("IntegerSubscribe::onSubscribe");
            s.request(Long.MAX_VALUE);
        }

        @Override
        public void onNext(Integer data) {
            System.out.println("data: " + data);
        }

        @Override
        public void onError(Throwable t) {
            System.out.println("error: " + t);
        }

        @Override
        public void onComplete() {
            System.out.println("IntegerSubscribe::onComplete");
        }
    }
}
