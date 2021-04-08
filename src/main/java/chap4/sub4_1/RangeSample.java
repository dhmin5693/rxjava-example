package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;

public class RangeSample {
    public static void main(String[] args) {
        Flowable.range(10, 3)
                .subscribe(new DebugSubscriber<>());
    }
}
