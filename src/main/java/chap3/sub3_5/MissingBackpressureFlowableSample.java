package chap3.sub3_5;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MissingBackpressureFlowableSample {
    public static void main(String[] args) throws InterruptedException {

        var flowable = Flowable.interval(10L, TimeUnit.MICROSECONDS)
                               .doOnNext(next -> System.out.println("emit: " + next));

        flowable.observeOn(Schedulers.computation())
                .subscribe(new Subscriber<>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long data) {
                        try {
                            System.out.println("waiting...");
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("received: " + data);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                });

        Thread.sleep(5000L);
    }
}
