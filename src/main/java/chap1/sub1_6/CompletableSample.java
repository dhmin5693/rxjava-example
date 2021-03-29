package chap1.sub1_6;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CompletableSample {

    public static void main(String[] args) throws InterruptedException {

        Completable completable = Completable.create(CompletableEmitter::onComplete);

        completable.subscribeOn(Schedulers.computation())
                   .subscribe(new CompletableObserver() {
                       @Override
                       public void onSubscribe(@NonNull Disposable d) {
                           System.out.println("onSubscribe");
                       }

                       @Override
                       public void onComplete() {
                           System.out.println("onComplete");
                       }

                       @Override
                       public void onError(@NonNull Throwable e) {
                           e.printStackTrace();
                       }
                   });

        Thread.sleep(1000L);
    }
}
