package chap3.sub3_1;

import io.reactivex.Flowable;
import java.util.List;

public class FlowableSample {

    public static void main(String[] args) {

        var list = List.of("a", "b", "c");
        var flowable = Flowable.fromIterable(list);

        flowable.subscribe(System.out::println);
    }
}
