package chap1_2;

// 생산자와 소비자 연결
public interface Subscription {

    // 통지받을 데이터 개수 요청
    void request(long num);

    // 구독 해지
    void cancel();
}
