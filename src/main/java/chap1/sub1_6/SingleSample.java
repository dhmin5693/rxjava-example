package chap1.sub1_6;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class SingleSample {

    public static void main(String[] args) {

        Single<DayOfWeek> single = Single.create(
            emitter -> emitter.onSuccess(
                LocalDate.now().getDayOfWeek()));

        single.subscribe(new SingleObserver<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(@NonNull DayOfWeek dayOfWeek) {
                System.out.println(dayOfWeek);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }
        });
    }
}
