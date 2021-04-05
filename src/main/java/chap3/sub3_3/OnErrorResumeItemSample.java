package chap3.sub3_3;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

public class OnErrorResumeItemSample {
    public static void main(String[] args) {

        Flowable.just(1, 3, 5, 0, 2, 4)
                .map(data -> 100 / data)
                .onErrorReturnItem(0)
                .subscribe(new DisposableSubscriber<>() {

                    @Override
                    public void onNext(Integer data) {
                        System.out.println("data: " + data);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }
}
