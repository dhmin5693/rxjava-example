package chap3.sub3_2;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import java.util.concurrent.TimeUnit;

public class ObserveOnSample {

    public static void main(String[] args) throws InterruptedException {

        var flowable = Flowable.interval(500L, TimeUnit.MILLISECONDS)
                               .onBackpressureDrop(); // back pressure 상태에서 데이터를 버린다.

        int bufferSize = 1;
        flowable.observeOn(Schedulers.computation(), false, bufferSize)
                .subscribe(new ResourceSubscriber<>() {
                    @Override
                    public void onNext(Long data) {
                        try {
                            Thread.sleep(1000L);
                            System.out.println(Thread.currentThread().getName() + ": " + data);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Thread.sleep(10000L);
    }
}
