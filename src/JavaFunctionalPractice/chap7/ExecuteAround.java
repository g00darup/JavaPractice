package JavaFunctionalPractice.chap7;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class ExecuteAround {
    public int executeImperativeSquareSolution(int value) {
        long start = System.currentTimeMillis();
        int result = 0;
        try {
            // Perform computation
            result = value * value;
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.print("Duration: " + duration + " - ");
        return result;
    }

    public int executeDuration(
            Function<Integer, Integer> computation, int value) {
        long start = System.currentTimeMillis();
        int result = 0;
        try {
            result = computation.apply(value);
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.print("Duration: " + duration + " - ");
        return result;
    }
    private static int withLog(int value) {
        System.out.print("Operation logged for " + value + " - ");
        return value;
    }
    private static int executeWithLog(
            Function<Integer, Integer> consumer, int value) {
        System.out.print("Operation logged for " + value + " - ");
        return consumer.apply(value);
    }
    public static void main(String[] args) {
        ExecuteAround ea = new ExecuteAround();

        System.out.println(ea.executeImperativeSquareSolution(5));
       //System.out.println(ea.executeImperativeCubeSolution(5));
        System.out.println(ea.executeDuration(x -> x * x, 5));
        System.out.println(ea.executeDuration(x -> x * x * x, 5));


        Function<Integer, Integer> computeSquare = x -> x * x;
        Function<Integer, Integer> computeCube = x -> x * x * x;
        System.out.println(ea.executeDuration(computeSquare, 5));
        System.out.println(ea.executeDuration(computeCube, 5));


        System.out.println(executeWithLog(x -> x * x, 5));
        System.out.println(executeWithLog(computeSquare, 5));


        System.out.println(withLog(ea.executeDuration(x -> x * x, 5)));
        System.out.println(ea.executeDuration(x -> x * x, withLog(5)));

        Function<Integer, Integer> computeDuration =
                x -> ea.executeDuration(computeSquare, x);
        Integer arr[] = {1, 2, 3, 4, 5};
        Stream<Integer> myStream = Arrays.stream(arr);
        myStream
                .map(computeDuration)
                .forEach(x -> System.out.println(x));
    }
}
