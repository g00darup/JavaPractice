package com.java8inaction.misc;

import main.java.com.testplayground.interfaces.Func;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Jump2advanced{
    void jump(String val);
}

public class LambdaExample {
    public static void main(String[] args) {
        Thread th = new Thread( );
        th.start();

        Runnable r1 = () -> System.out.println("running thread 1");
        Thread th2 = new Thread(r1);
        th2.start();

        Function<Integer,Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));

        Function<Integer,Double> function1 = Math::sqrt;
        System.out.println(function1.apply(9));

       BiFunction<Integer,Integer, Integer> fun3 = LambdaExample::add;

       LambdaExample le = new LambdaExample();

       Jump2advanced jump2advanced = (data)-> le.display(data);

        Jump2advanced jump2advanced2 = le::display;
        jump2advanced2.jump("Ja ta");

        String[] str = {"a","e","o","u"};
        Arrays.sort(str, String::compareTo);

        List<String> dmmyStr = new ArrayList<>();
        dmmyStr.add("nan");
        dmmyStr.add("&");
        dmmyStr.add("->");

        Function<List<String>, Set<String>> setFunction = (smLis) -> new HashSet<>(smLis);
        System.out.println(setFunction.apply(dmmyStr));

        Function<List<String>, Set<String>> setFunctionRef = HashSet::new;
        System.out.println(setFunctionRef.apply(dmmyStr));

    }

    public static int add(int a, int b){
        return a+b;
    }

    public void display(String s){
        s = s.toLowerCase();
        System.out.println(s);
    }
}
