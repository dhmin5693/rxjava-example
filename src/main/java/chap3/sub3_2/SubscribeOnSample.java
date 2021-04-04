package chap3.sub3_2;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class SubscribeOnSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.computation()) // 이 정책만 반영
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.single())
                .subscribe(data -> {
                    var thread = Thread.currentThread().getName();
                    System.out.println(thread + ": " + data);
                });

        Thread.sleep(1000L);
    }
}
