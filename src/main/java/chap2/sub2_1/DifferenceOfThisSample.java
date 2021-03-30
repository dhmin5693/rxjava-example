package chap2.sub2_1;

import io.reactivex.functions.Action;

public class DifferenceOfThisSample {

    public static void main(String[] args) throws Exception {
        var target = new DifferenceOfThisSample();
        System.out.println("target: " + target);
        target.execute();
    }

    public void execute() throws Exception {

        var anonymous = new Action() {
            @Override
            public void run() {
                System.out.println("anonymous: " + this);
            }
        };

        Action lambda = () -> System.out.println("lambda:" + this);

        anonymous.run();
        lambda.run();
    }
}
