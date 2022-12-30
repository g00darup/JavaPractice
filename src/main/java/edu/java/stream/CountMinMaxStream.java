package main.java.edu.java.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class CountMinMaxStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        System.out.println(stream.count());

        Integer integer = Stream.of(1,2,3,4,5,6,7,8,9).min
                (Comparator.comparing(Integer::intValue)).get();
        System.out.println("Min ->"+ integer);

        Integer max = Stream.of(1,2,3,4,5,6,7,8,9).max(Comparator.comparing(Integer::intValue)).get();
        System.out.println("Max ->"+max);

    }
}
