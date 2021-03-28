package chap1.sub1_3;

import io.reactivex.Flowable;

public class MethodChainningSample {

    public static void main(String[] args) {

        var flowable =
            Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                    .filter(data -> data % 2 == 0)
                    .map(data -> data * 100);

        flowable.subscribe(System.out::println);

        var fromCallable =
            Flowable.fromCallable(System::currentTimeMillis);

        fromCallable.subscribe(System.out::println);
    }
}
