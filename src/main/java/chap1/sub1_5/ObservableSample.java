package chap1.sub1_5;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ObservableSample {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> observable = Observable.create(emitter -> {

            for (String s : List.of("Hi", "Hello", "안녕")) {
                if (emitter.isDisposed()) {
                    return;
                }

                emitter.onNext(s);
            }

            emitter.onComplete();
        });

        observable.observeOn(Schedulers.computation())
                  .subscribe(new Observer<>() {
                      @Override
                      public void onSubscribe(@NonNull Disposable d) {
                          System.out.println(getThreadName() + ": 구독 시작!");
                      }

                      @Override
                      public void onNext(@NonNull String s) {
                          System.out.println(getThreadName() + ": " + s);
                      }

                      @Override
                      public void onError(@NonNull Throwable e) {
                          e.printStackTrace();
                      }

                      @Override
                      public void onComplete() {
                          System.out.println(getThreadName() + ": 완료");
                      }

                      private String getThreadName() {
                          return Thread.currentThread().getName();
                      }
                  });

        Thread.sleep(1000L);
    }
}
