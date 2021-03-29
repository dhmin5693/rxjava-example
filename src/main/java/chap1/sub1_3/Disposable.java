package chap1.sub1_3;

// Observable과 Observer가 데이터를 교환할 때 사용
interface Disposable {

    // 구독 해지
    void dispose();

    // 구독 해지 시 true
    boolean isDisposed();
}
