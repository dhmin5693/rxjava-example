package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;

public class ErrorSample {
    public static void main(String[] args) {
        Flowable.error(new Exception("Throwable"))
                .subscribe(new DebugSubscriber<>("error1"));

        Flowable.error(() -> new Exception("Callable<Throwable>"))
                .subscribe(new DebugSubscriber<>("error2"));

        Flowable.just(1, 2, 3, 4, 5)
                .flatMap(i -> {
                    if (i == 3) {
                        return Flowable.error(new Exception("i == 3"));
                    }

                    return Flowable.just(i);
                })
                .subscribe(new DebugSubscriber<>("error3"));
    }
}
