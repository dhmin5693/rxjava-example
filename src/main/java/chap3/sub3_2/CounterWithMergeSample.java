package chap3.sub3_2;

import common.Counter;
import common.NonAtomicCounter;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class CounterWithMergeSample {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new NonAtomicCounter();

        var source1 = createIncreaseCounterFlowable();
        var source2 = createIncreaseCounterFlowable();

        Flowable.merge(source1, source2)
                .subscribe(
                    data -> counter.increment(),
                    Throwable::printStackTrace,
                    () -> System.out.println("counter: " + counter.get())
                );

        Thread.sleep(1000L);
    }

    private static Flowable<Integer> createIncreaseCounterFlowable() {
        return Flowable.range(1, 10000)
                       .subscribeOn(Schedulers.computation())
                       .observeOn(Schedulers.computation());
    }
}
