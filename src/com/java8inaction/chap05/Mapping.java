package com.java8inaction.chap05;

import com.java8inaction.chap04.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static com.java8inaction.chap04.Dish.menu;

public class Mapping {

    public static void main(String... args) {

        // map
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);



        // flatMap
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap((Integer i) -> numbers2.stream()
                                .map((Integer j) -> new int[]{i, j})
                        )
                        .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                        .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

        List<String> str = Arrays.asList("Hello", "World");
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);

        List<int[]> pairs2 =  numbers1.stream().flatMap(i->numbers2.stream().map(j -> new int[]{i,j})).collect(toList());

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0, 1},
                        t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        ArrayList<String> animals = new ArrayList<String>();
        animals.add("bat");
        animals.add("owl");
        animals.add("bat");
        animals.add("bat");


        long count = animals.stream().filter(animal -> "bat".equals(animal)).count();

        System.out.println(count);

        final Set<String> aniSets = animals.stream().collect(Collectors.toSet());

//        final Set<Integer> freqSets = animals.stream().map(()-> a.equals())
        Map<String, Long> counts =
                animals.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println(counts);

    }
}