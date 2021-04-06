package chap3.sub3_3;

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

    private String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    private String getMiddleMessage() {
        return label != null ? ": " + label : "";
    }

    @Override
    public void onNext(T data) {
        System.out.println(getCurrentThreadName() + getMiddleMessage() + ": " + data);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println(getCurrentThreadName() + getMiddleMessage() + ": " + t);
    }

    @Override
    public void onComplete() {
    }
}
