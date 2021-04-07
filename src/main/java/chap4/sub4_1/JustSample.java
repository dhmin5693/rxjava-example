package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;

public class JustSample {
    public static void main(String[] args) {
        var flowable = Flowable.just("A", "B", "C", "D", "E");
        flowable.subscribe(new DebugSubscriber<>());
    }
}
