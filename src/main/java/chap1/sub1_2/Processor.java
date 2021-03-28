package chap1.sub1_2;

// pub, sub 모두 포함
interface Processor<T, R> extends Subscriber<T>, Publisher<R> {

}
