package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class IntervalSample {
    public static void main(String[] args) throws InterruptedException {

        var flowable = Flowable.interval(1000L, TimeUnit.MILLISECONDS);
        log.info("--- START ---");

        flowable.subscribe(new DebugSubscriber<>("interval"));
        Thread.sleep(5000L);
        log.info("--- END ---");
    }
}
