package chap3.sub3_1;

import java.util.List;

public class IteratorSample {

    public static void main(String[] args) {

        var list = List.of("a", "b", "c");
        var iterator = list.iterator();

        while (iterator.hasNext()) {
            var value = iterator.next();
            System.out.println(value);
        }
    }
}
