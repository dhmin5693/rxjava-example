package chap1.sub1_6;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class RequestMethodSample {

    public static void main(String[] args) {

        var flowable = Flowable.just(1, 2, 3);
        var disposable = flowable.subscribe(System.out::println);

        flowable.subscribe(new Subscriber<>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("onSubscribe Start");
                        s.request(Long.MAX_VALUE);
                        System.out.println("onSubscribe End");
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
