package chap01;

public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
