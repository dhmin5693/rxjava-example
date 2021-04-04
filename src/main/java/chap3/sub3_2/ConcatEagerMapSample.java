package chap3.sub3_2;

import io.reactivex.Flowable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ConcatEagerMapSample {

    public static void main(String[] args) throws InterruptedException {
        var flowable = Flowable.just("A", "B", "C")
                               .concatMapEager(data -> Flowable.just(data)
                                                               .delay(1000L,
                                                                      TimeUnit.MILLISECONDS));

        flowable.subscribe(data ->
                               System.out.println(
                                   Thread.currentThread().getName() + ": " + data + ", time = " +
                                       LocalTime.now()
                                                .format(DateTimeFormatter.ofPattern("ss.SSS")))
        );

        Thread.sleep(2000L);
    }
}
