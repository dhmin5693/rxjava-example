package chap1.sub1_6;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CompositeDisposableSample {

    public static void main(String[] args) throws InterruptedException {
        var compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(Flowable.range(1, 3)
                                        .doOnCancel(() -> System.out.println("task 1 canceled"))
                                        .observeOn(Schedulers.computation())
                                        .subscribe(data -> {
                                            Thread.sleep(100L);
                                            System.out.println("task 1: " + data);
                                        }));

        compositeDisposable.add(Flowable.range(1, 3)
                                        .doOnCancel(() -> System.out.println("task 2 canceled"))
                                        .observeOn(Schedulers.computation())
                                        .subscribe(data -> {
                                            Thread.sleep(100L);
                                            System.out.println("task 2: " + data);
                                        }));

        Thread.sleep(200L);
        compositeDisposable.dispose();
    }
}
