package chap3.sub3_2;

import common.NonAtomicCounter;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class CounterSample {

    public static void main(String[] args) throws InterruptedException {
        var counter = new NonAtomicCounter();

        increaseCounter(counter);
        increaseCounter(counter);

        Thread.sleep(1000L);
    }

    private static void increaseCounter(NonAtomicCounter counter) {
        Flowable.range(1, 10000)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe(
                    data -> counter.increment(),
                    Throwable::printStackTrace,
                    () -> System.out.println("counter: " + counter.get())
                );
    }
}
