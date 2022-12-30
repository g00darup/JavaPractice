package main.java.com.testplayground.concurrency;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class AmbiguousLambdaSample {
    public static void useCallable(Callable<Integer> expression) {}
    public static void useSupplier(Supplier<Integer> expression) {}

    public static void use(Supplier<Integer> expression) {}
    public static void use(Callable<Integer> expression) {}
    public static void main(String[] args) {
        useCallable(() -> {throw new IOException();});  // COMPILES
        //useSupplier(() -> {throw new IOException();});  // DOES NOT COMPILE
        //use((Callable<Integer>) ()-> {throw new IOException();});          // DOES NOT COMPILE
    }
}