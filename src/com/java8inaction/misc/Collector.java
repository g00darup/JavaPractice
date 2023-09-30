package com.java8inaction.misc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collector {
    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(95,85,93,91,92,96,13,14,111,123,123,91);
        Map<Integer,List<Integer>> map = lst.stream().collect(Collectors.groupingBy(i->i));
        Set s = lst.stream().collect(Collectors.toSet());
        Long length = lst.stream().collect(Collectors.counting());
        //System.out.println(length);
        Map<Boolean,List<Integer>> collect1 = lst.
                stream().
                collect(Collectors.partitioningBy(x->((Integer)x).intValue()%2==0));

        //collect1.forEach((k,v)-> System.out.println(v));
        List<String> names = Arrays.asList("alfa","beta","gamma","delta","beta");

        Map<String,Integer> map2 = names.stream().
                collect(Collectors.toMap(Function.identity(),String::length,(i1,i2)->i1));

        Map<String,Long> map3 = names.stream().
                collect(Collectors.groupingBy(Function.identity(),
                        HashMap::new,
                        Collectors.counting()));

        //map3.forEach((k,v)-> System.out.println(k+"--"+v));

        Function<Integer,Integer> func = Function.identity();
        Map<Integer,Long> map4 = lst.stream().
                        collect(Collectors.groupingBy(Function.identity(),
                        HashMap::new,
                        Collectors.counting()));

        map4.forEach((k,v)-> System.out.println(k+"--"+v));
    }


}
