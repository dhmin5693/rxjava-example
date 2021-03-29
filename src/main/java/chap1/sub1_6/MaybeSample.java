package chap1.sub1_6;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class MaybeSample {

    public static void main(String[] args) {

        Maybe<DayOfWeek> maybe = Maybe.create(
            emitter -> emitter.onSuccess(LocalDate.now().getDayOfWeek()));
        maybe.subscribe(observer());

        maybe = Maybe.create(MaybeEmitter::onComplete);
        maybe.subscribe(observer());
    }

    private static MaybeObserver<DayOfWeek> observer() {
        return new MaybeObserver<>() {
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

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
    }
}
