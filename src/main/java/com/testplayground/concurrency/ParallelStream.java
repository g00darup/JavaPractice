package main.java.com.testplayground.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
        Stream<Integer> parallelStream = stream.parallel();
        Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5,6).parallelStream();
//        Arrays.asList(1,2,3,4,5,6)
//                .stream()
//                .forEach(s -> System.out.print(s+" "));
//
//        Arrays.asList(1,2,3,4,5,6)
//                .parallelStream()
//                .forEach(s -> System.out.print(s+" "));

//        Arrays.asList("jackal","kangaroo","lemur")
//                .parallelStream()
//                .map(s -> s.toUpperCase())
//                .forEach(System.out::println);

        //    List<Integer> data = Collections.synchronizedList(new ArrayList());
//    Arrays.asList(1,2,3,4,5,6).parallelStream()
//   .map(i -> {data.add(i); return i;}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
//            .forEachOrdered(i -> System.out.print(i+" "));
//
//System.out.println();
//for(Integer e: data) {
//        System.out.print(e+" ");
//    }

        Arrays.asList(1,2,3,4,5,6).stream().unordered();
        Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get();

        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .stream()
                .reduce("",(c,s1) -> c + s1,
                        (s2,s3) -> s2 + s3));
    }



}
