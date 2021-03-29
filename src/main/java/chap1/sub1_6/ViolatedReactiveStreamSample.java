package chap1.sub1_6;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class ViolatedReactiveStreamSample {

    public static void main(String[] args) {

        Flowable.range(1, 3)
                .subscribe(new Subscriber<>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("onSubscribe: start");
                        s.request(Long.MAX_VALUE);
                        System.out.println("onSubscribe: end");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }
}
