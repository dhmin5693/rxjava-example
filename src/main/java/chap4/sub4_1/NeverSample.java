package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;

public class NeverSample {
    public static void main(String[] args) {
        Flowable.range(0, 5)
                .flatMap(i -> {

                    if ((i & 1) == 1) {
                        return Flowable.just(i);
                    }

                    return Flowable.never();
                })
                .subscribe(new DebugSubscriber<>("never"));
    }
}
