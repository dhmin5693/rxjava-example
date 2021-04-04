package chap3.sub3_2;

import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;

public class FlatMapSample {

    public static void main(String[] args) throws InterruptedException {
        var flowable = Flowable.just("A", "B", "C")
                               .flatMap(data -> Flowable.just(data)
                                                        .delay(1000L, TimeUnit.MILLISECONDS));

        flowable.subscribe(data -> System.out.println(Thread.currentThread().getName() + ": " + data));

        Thread.sleep(2000L);
    }
}
