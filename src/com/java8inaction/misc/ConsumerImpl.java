package com.java8inaction.misc;

import java.util.function.Consumer;

public class ConsumerImpl {
    public static void main(String[] args) {
        Consumer<String> s = (t) ->  System.out.println(t);
        s.accept("brr");
    }
}
