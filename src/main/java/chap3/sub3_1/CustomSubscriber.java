package chap3.sub3_1;

import java.util.ArrayList;
import java.util.List;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

class CustomSubscriber<T> implements Subscriber<T> {

    private List<T> list = new ArrayList<>();

    @Override
    public void onNext(T t) {

        // Unsafe in multi thread
        if (list.size() < 5) {
            list.add(t);
        }
    }

    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("onSubscribe");
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
