package JavaFunctionalPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Vanila {
    public static String processString(Function<String,String> operation, String target) {
        return operation.apply(target);
    }

    public static void main(String[] args) {
        String names[] = {"Sally", "George", "Paul"};
        List<String> list = Arrays.asList(names);
        mukalla(list);

        List<String> numberString = Arrays.asList("12", "34", "82");
        List<Integer> numbers = new ArrayList<>();
        List<Integer> doubleNumbers = new ArrayList<>();

        numbers.clear();
        numberString
                .stream()
                .forEach(s -> numbers.add(Integer.parseInt(s)));

        Function<List<String>, List<Integer>> singleFunction = s -> {
            s.stream()
                    .forEach(t -> numbers.add(Integer.parseInt(t)));
            return numbers;
        };

        Function<List<String>, List<Integer>> doubleFunction = s -> {
            s.stream()
                    .forEach(t -> doubleNumbers.add(
                            Integer.parseInt(t) * 2));
            return doubleNumbers;
        };

        numbers.clear();
        System.out.println(singleFunction.apply(numberString));
        System.out.println(doubleFunction.apply(numberString));

        Arrays.asList(numberString).stream()
                .map(doubleFunction)
                .forEach(s -> System.out.println(s));




    }

    private static void mukalla(List<String> list) {
        list.forEach(s-> System.out.println(
            processString(String::toLowerCase,s)
        ));
    }
}
