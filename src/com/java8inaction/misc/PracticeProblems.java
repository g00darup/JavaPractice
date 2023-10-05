package com.java8inaction.misc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeProblems {


    public static void main(String[] args) {
        List lst = Arrays.asList(95,85,93,91,92,96,13,14,111,123,123,91);
        //System.out.println(evenList(lst));
        //Optional opt = findFirst(lst);
        //opt.ifPresent(System.out::println);
        System.out.println(findDups(lst));
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
        Map<Integer,Long> intMap = input.stream().
                collect(Collectors.
                groupingBy(Function.identity(),
                HashMap::new,Collectors.counting()));

        List<Integer> dups = intMap.
                entrySet().
                stream().
                filter((entry) -> entry.getValue() >= 2).
                map(Map.Entry::getKey).
                collect(Collectors.toList());

        //        for (Map.Entry<Integer, Long> entry : intMap.entrySet()) {
        //            Integer k = entry.getKey();
        //            Long v = entry.getValue();
        //            if (v >= 2) {
        //                dups.add(k);
        //            }
        //        }
        //intMap.entrySet().stream().forEach((entry)-> (entry.getKey()!=null) ? (entry.) : );

        return  dups;

    }
    //find first element of list
    public static Optional<Integer> findFirst(List<Integer> input){
        return input.stream().findFirst();
    }
    //max on list
    public static Integer mac(List<Integer> input){
        return input.stream().max(Integer::compare).get();
    }

    public static List<Integer> sorted(List<Integer> input){
        return input.stream().sorted(Comparator.naturalOrder()).toList();
    }

}
