package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;

import java.time.LocalTime;

public class DeferSample {
    public static void main(String[] args) {

        var flowable = Flowable.defer(() ->
                                          Flowable.just(LocalTime.now()));

        for (int i = 1; i <= 2; i++) {
            flowable.subscribe(new DebugSubscriber<>("Defer " + i));
        }
    }
}
