package main.java.edu.java.stream;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunctionAdd =  (t , u)-> (t + u);

        BiFunction<Integer, Integer, Integer> biFunctionSubtract =  (t , u)-> (t - u);

        BiFunction<Integer, Integer, Integer> biFunctionMul =  (t , u)-> (t * u);

        BiFunction<Integer, Integer, Integer> biFunctionDiv =  (t , u)-> (t / u);

        System.out.println(biFunctionAdd.apply(10,20));
        System.out.println(biFunctionSubtract.apply(100,200));
        System.out.println(biFunctionMul.apply(3,4));
        System.out.println(biFunctionDiv.apply(12,2));
    }
}
