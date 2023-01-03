package main.java.com.testplayground.lambda;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTry {
    public static void main(String[] args) {
        Stream<String> empty2 = Stream.empty();    // count = 0
        Stream<Integer> singleElement = Stream.of(1);    // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3);    // count = 2

        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        //Optional<String> min = s.min((s1, s2) -> (s1.length()—s2.length()));
        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        minEmpty.ifPresent(System.out::println); // ape

        Stream<Integer> stream = Stream.of(3, 5, 6);
        //T reduce(T identity, BinaryOperator<T> accumulator)
        //Optional<T> reduce(BinaryOperator<T> accumulator)
        System.out.println(stream.reduce(1, (a, b) -> a*b));

        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        empty.reduce(op).ifPresent(System.out::print); // no output
        oneElement.reduce(op).ifPresent(System.out::print); // 3
        threeElements.reduce(op).ifPresent(System.out::print); // 90
        StringBuilder word = Stream.of("w", "o", "l", "f")
                            .collect(StringBuilder::new,
                             StringBuilder::append, StringBuilder::append);

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream2.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]


        Stream<String> stream3 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set2 = stream3.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set2); // [f, l, o, w]


        Stream<String> stream4= Stream.of("w", "o", "l", "f");
        Set<String> set4 = stream4.collect(Collectors.toSet());
        System.out.println(set); // [f, w, l, o]

        Stream<String> s5 = Stream.of("monkey", "gorilla", "bonobo");
        s5.filter(x -> x.startsWith("m")).forEach(System.out::print);    // monkey

        Stream<String> s6 = Stream.of("duck", "duck", "duck", "goose");
        s6.distinct().forEach(System.out::print); // duckgoose

        Stream.of("monkey", "gorilla", "bonobo").
                map(String::length).forEach(System.out::print);    // 676
    }
}
