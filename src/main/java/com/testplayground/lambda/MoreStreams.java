package main.java.com.testplayground.lambda;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MoreStreams {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');
        Stream<List<?>> stream = Stream.of(numbers, letters);
        stream.map(List::size).forEach(System.out::print); // 11

        StringBuilder builder = new StringBuilder();
        Stream<List<?>> good = Stream.of(numbers, letters);
        good.peek(l -> builder.append(l)).map(List::size).forEach(System.out::print); // 11
        System.out.println(builder); // [1][a]

        Stream<List<?>> bad = Stream.of(numbers, letters);
        bad.peek(l -> l.remove(0)).map(List::size).forEach(System.out::print);  // 00

//        Stream.generate(() -> "Olaf Lazisson")
//                .filter(n -> n.length() == 4)
//                .limit(2)
//                .sorted()
//                .forEach(System.out::println);
        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .limit(2)
                .sorted()
                .forEach(System.out::println);

//        IntStream count = IntStream.iterate(1, n -> n+1);
//        //.limit(5);
//        count.forEach(System.out::println);

        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream stream1 = objStream.mapToInt(s -> s.length());
                //collect(Collectors.toSet());

        System.out.println(Period.ofMonths(3));
        System.out.println(Period.of(0, 20, 47));


    }
}
