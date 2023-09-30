package com.java8inaction.misc;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeProblems {


    public static void main(String[] args) {
        List lst = Arrays.asList(95,85,93,91,92,96,13,14,111,123,123,91);
        //System.out.println(evenList(lst));
        System.out.println(startsWithOneList(lst));
    }

    /* Given a list of integers, find out all the even numbers that exist in the list using Stream functions?*/
    public static List<Integer> evenList(List<Integer> input)  {
        return  input.
                stream().
                filter(i->i%2==0).
                collect(Collectors.toList());
    }

    /*Given a list of integers, find out all the numbers starting with 1 using Stream functions?*/
    public static List<Integer> startsWithOneList(List<Integer> input)  {
        return  input.stream().
                filter(i->i.toString().
                startsWith("1")).
                collect(Collectors.toList());
    }

    /*find duplicate elements in a given integers list in java using Stream functions?*/
    public static List<Integer> findDups(List<Integer> input)  {
        Stream s = input.stream();
        List<Integer> distinct = (List<Integer>) s.distinct().collect(Collectors.toList());
//        Consumer con =
//        List<Integer> dups = s.forEach(con);
        return  null;

    }


}
