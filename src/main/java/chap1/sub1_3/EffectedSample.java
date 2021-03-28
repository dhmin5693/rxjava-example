package chap1.sub1_3;

import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class EffectedSample {

    public static void main(String[] args) throws InterruptedException {

        var type = CalcType.ADD;

        var flowable =
            Flowable.interval(300L, TimeUnit.MILLISECONDS)
                    .take(7)
                    .scan((sum, data) -> type.method.apply(sum, data));

        flowable.subscribe(data -> System.out.println("data: " + data));

        Thread.sleep(1000L);

        /*
         * 책 예제는 실행 중 계산 유형을 변경해버렸는데
         * functional interface 스펙 상 type은 반드시 effective final이어야 한다.ㅛ
         */
        // type = CalcType.MULTIPLY;
        Thread.sleep(2000L);
    }

    private enum CalcType {
        ADD(Long::sum),
        MULTIPLY((a, b) -> a * b);

        private BiFunction<Long, Long, Long> method;

        CalcType(BiFunction<Long, Long, Long> method) {
            this.method = method;
        }
    }
}
