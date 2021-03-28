package chap01;

public interface Subscriber<T> {
    void onSubscribe(Subscription subscription);

    void onNext(T item);

    void onError(Throwable error);

    void onComplete();
}
