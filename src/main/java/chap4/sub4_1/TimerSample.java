package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TimerSample {
    public static void main(String[] args) throws InterruptedException {
        log.info("--- START ---");

        var flowable = Flowable.timer(1000L, TimeUnit.MILLISECONDS);
        flowable.subscribe(new DebugSubscriber<>("timer"));
        Thread.sleep(1500L);

        log.info("---  END  ---");
    }
}
