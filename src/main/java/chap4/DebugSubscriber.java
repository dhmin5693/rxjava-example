package chap4;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebugSubscriber<T> extends DisposableSubscriber<T> {

    private String label;

    public DebugSubscriber() {
        super();
    }

    public DebugSubscriber(String label) {
        super();
        this.label = label;
    }

    private String getMiddleMessage() {
        return label != null ? label + ": " : "";
    }

    @Override
    public void onNext(T data) {
        log.debug("{}{}", getMiddleMessage(), data);
    }

    @Override
    public void onError(Throwable t) {
        log.error("{}{}", getMiddleMessage(), t);
    }

    @Override
    public void onComplete() {
        log.info("{}{}", getMiddleMessage(), "complete");
    }

    public static void main(String[] args) {
        Flowable.just(1, 2, 3, 4, 5)
                .subscribe(new DebugSubscriber<>("tester"));
    }
}
