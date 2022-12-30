package main.java.com.testplayground.lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {
        BiPredicate<String, String> b1 =  String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);

        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("chicken", "chick"));

        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = egg.and(brown);
        Predicate<String> otherEggs = egg.and(brown.negate());

    }
}
