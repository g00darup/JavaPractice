package com.java8inaction.misc;

import java.util.function.Function;

public class FunctionalImp {
    public static void main(String[] args) {
        //eg 1
        Function<String, Integer> function = (String t) ->  t.length();
        System.out.println(function.apply("Count me in"));
        // eg2
        Function<Integer, String> function2 = (num) -> (num%2==0 ? "Number is even" :  "Number is odd");
        System.out.println(function2.apply(333));
        // eg 3
        Function<Integer,Integer> function3 = (num) -> num*2;

        Integer integer = function.andThen(function3).apply("Gut");
        System.out.println(integer);


    };
}
