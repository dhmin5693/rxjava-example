package chap4.sub4_1;

import chap4.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class FromSample {
    public static void main(String[] args) {

        var arrayData = new String[] {"A", "B", "C", "D", "E"};
        var listData = Arrays.stream(arrayData).collect(toList());

        var fromArrayFlowable = Flowable.fromArray(arrayData);
        var fromIterableFlowable = Flowable.fromIterable(listData);

        fromArrayFlowable.subscribe(new DebugSubscriber<>("array"));
        fromIterableFlowable.subscribe(new DebugSubscriber<>("iterable"));
    }
}
