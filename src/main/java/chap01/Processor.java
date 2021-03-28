package chap01;

// pub, sub 모두 포함
public abstract interface Processor<T, R> extends Subscriber<T>, Publisher<R> {

}
