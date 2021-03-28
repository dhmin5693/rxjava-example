package chap1_2;

// pub, sub 모두 포함
public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {

}
