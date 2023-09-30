package com.java8inaction.misc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerImpl {
    public static void main(String[] args) {
        Consumer<String> s = (t) ->  System.out.println(t);
        s.accept("brr");
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7);

        Consumer<Integer> consumer = (t) -> System.out.println(t*t);
        integers.forEach(consumer);
    }
}
