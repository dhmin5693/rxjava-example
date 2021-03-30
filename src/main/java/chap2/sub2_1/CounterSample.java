package chap2.sub2_1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class CounterSample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var counter = new Counter();

        Runnable task = () ->
            Stream.iterate(0, i -> i < 10000, i -> i + 1)
                  .forEach(i -> counter.increment());

        // 비동기 처리 작업 생성 준비
        var executorService = Executors.newCachedThreadPool();

        // start new thread
        Future<Boolean> future1 = executorService.submit(task, true);
        Future<Boolean> future2 = executorService.submit(task, true);

        if (future1.get() && future2.get()) {
            System.out.println(counter.get());
        } else {
            System.out.println("fail");
        }

        executorService.shutdown();
    }

    private static class Counter {

        private volatile int count;

        void increment() {
            count++;
        }

        int get() {
            return count;
        }
    }
}
