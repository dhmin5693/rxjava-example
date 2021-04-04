package chap3.sub3_2;

import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;

public class SyncFasterSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .doOnNext(System.out::println)
                .subscribe(data -> Thread.sleep(500L));

        Thread.sleep(10000L);
    }
}
