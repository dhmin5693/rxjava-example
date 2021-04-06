package chap3.sub3_3;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class RetrySample {

    public static void main(String[] args) throws Exception {

        var flowable = Flowable.<Integer>create(emitter -> {
            log.info("start flowable");

            for (int i = 1; i <= 3; i++) {
                if (i == 2) {
                    throw new Exception("i == 2 예외 발생");
                }
                emitter.onNext(i);
            }

            emitter.onComplete();
            log.info("end flowable");
        }, BackpressureStrategy.BUFFER)
                               .doOnSubscribe(s -> log.info("Flowable::doOnSubscription"))
                               .retry(2);

        flowable.subscribe(new IntegerSubscribe());
    }

    private static class IntegerSubscribe implements Subscriber<Integer> {

        @Override
        public void onSubscribe(Subscription s) {
            log.info("IntegerSubscribe::onSubscribe");
            s.request(Long.MAX_VALUE);
        }

        @Override
        public void onNext(Integer data) {
            log.debug("data: " + data);
        }

        @Override
        public void onError(Throwable t) {
            log.error("error: " + t);
        }

        @Override
        public void onComplete() {
            log.info("IntegerSubscribe::onComplete");
        }
    }
}
