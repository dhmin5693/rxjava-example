package chap4;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebugObserver<T> implements Observer<T> {

    private String label;

    public DebugObserver() {
        super();
    }

    public DebugObserver(String label) {
        super();
        this.label = label;
    }

    private String getLabel() {
        return label != null ? label + ": " : "";
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        log.info("{}{}, {}", getLabel(), "subscribe", d);
    }

    @Override
    public void onNext(@NonNull T data) {
        log.debug("{}{}", getLabel(), data);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        log.error("{}{}", getLabel(), e);
    }

    @Override
    public void onComplete() {
        log.info("{}{}", getLabel(), "complete");
    }

    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                  .subscribe(new DebugObserver<>("tester"));
    }
}
