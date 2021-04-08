package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.List;

public class FromCallableSample {
    public static void main(String[] args) {
        Flowable.fromCallable(() -> List.of(1, 2, 3, 4, 5))
                .subscribe(new DebugSubscriber<>("callable"));
    }
}
