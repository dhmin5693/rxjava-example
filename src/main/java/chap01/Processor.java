package chap01;

public abstract interface Processor<T, R> extends Subscriber<T>, Publisher<R> {

}
