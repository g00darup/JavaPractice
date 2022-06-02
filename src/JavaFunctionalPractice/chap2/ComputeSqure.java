package JavaFunctionalPractice.chap2;

import java.util.function.Function;

public class ComputeSqure {

    static Function<Integer, Integer> squareFunction = x -> {
        System.out.println("In function");
        return x * x;
    };

    public static void main(String[] args) {
        Function<Integer, Integer> memoizationFunction =
                Memoizer.memoize(squareFunction);
        System.out.println(memoizationFunction.apply(2));
        System.out.println(memoizationFunction.apply(2));
        System.out.println(memoizationFunction.apply(2));

        Function<Double, Double> memoizationFunction2 =
                Memoizer.memoize(x -> x * x);
        System.out.println(memoizationFunction2.apply(4.0));
    }
}
