package JavaFunctionalPractice.chap2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ClosureExample {
    int instanceLength;

    public Function<String,String> getStringOperation() {
        final String seperator = ":";
        return target -> {
            int localLength = target.length();
            instanceLength = target.length();
            return target.toLowerCase()
                    + seperator + instanceLength + seperator + localLength;
        };
    }

    public static void main(String[] args) {
        ClosureExample ce = new ClosureExample();
        final Function<String,String> function =
                ce.getStringOperation();

//        function = String::toLowerCase;
//        Consumer<String> consumer =
//                s -> System.out.println(function.apply(s));
        System.out.println(function.apply("Closure"));

        //Currying
        BiFunction<String, String, String> biFunctionConcat =
                (a, b) -> a + b;
        System.out.println(biFunctionConcat.apply("Cat", "Dog"));

        Function<String, Function<String, String>> curryConcat;
        curryConcat = (a) -> (b) -> biFunctionConcat.apply(a, b);

        Function<String,String> intermediateFunction;
        intermediateFunction = curryConcat.apply("Cat");

        System.out.println(intermediateFunction);
        System.out.println(curryConcat.apply("Cat"));

        System.out.println(intermediateFunction.apply("Dog"));

        System.out.println(curryConcat.apply("Cat").apply("Dog"));
        System.out.println(curryConcat.apply(
                "Flying ").apply("Monkeys"));
    }
}
