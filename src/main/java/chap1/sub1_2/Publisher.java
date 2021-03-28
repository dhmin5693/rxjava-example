package chap1.sub1_2;

// 데이터 생산자
public interface Publisher<T> {

    // 데이터 소비자 등록
    void subscribe(Subscriber<? super T> subscriber);
}
