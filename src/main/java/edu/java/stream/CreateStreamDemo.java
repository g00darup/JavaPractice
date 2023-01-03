package main.java.edu.java.stream;

import java.util.*;
import java.util.stream.Stream;

public class CreateStreamDemo {
    public static void main(String[] args) {
        // create a streamm
        Stream<String> stream = Stream.of("a","b","c");
        stream.forEach(System.out::println);
        Collection<String> collection = Arrays.asList("Java", "J2ee", "Spring", "Hibernate");
        Stream<String> stream2 = collection.stream();

        stream2.forEach(System.out::println);

        List<String> list = Arrays.asList("Java", "J2ee", "Spring", "Hibernate");
        Stream<String> listStr = collection.stream();
        listStr.forEach(System.out::println);

        Set<String> set = new HashSet<>(list);
        Stream<String>  stream4 = set.stream();
        stream4.forEach(System.out::println);

        String[] strArr = {"a", "b", "c"};
        Stream<String> stream5 = Arrays.stream(strArr);
        stream5.forEach(System.out::println);
    }
}
