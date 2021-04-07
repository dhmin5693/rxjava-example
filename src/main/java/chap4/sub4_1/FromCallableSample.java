package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;

public class FromCallableSample {
    public static void main(String[] args) {
        Flowable.fromCallable(System::currentTimeMillis)
                .repeat(5)
                .subscribe(new DebugSubscriber<>("call"));
    }
}
