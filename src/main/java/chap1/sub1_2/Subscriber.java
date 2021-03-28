package chap1.sub1_2;

// 데이터 소비자
public interface Subscriber<T> {

    // 구독 시작 시 처리
    void onSubscribe(Subscription subscription);

    // 데이터 통지 시 처리
    void onNext(T item);

    // 에러 통지 시 처리
    void onError(Throwable error);

    // 완료 통지 시 처리
    void onComplete();
}
