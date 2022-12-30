package main.java.com.testplayground.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class More {

    public static void main(String[] args) {
//        Supplier<LocalDate> s1 = LocalDate::now;
//        Supplier<LocalDate> s2 = () -> LocalDate.now();
//
//        LocalDate d1 = s1.get();
//        LocalDate d2 = s2.get();
//
//        System.out.println(d1);
//        System.out.println(d2);

//        Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
//        ArrayList<String> a1 = s1.get();
//        System.out.println(a1);

//        Consumer<String> c1 =  System.out::println;
//        Consumer<String> c2 = x -> System.out.println(x);
//
//        c1.accept("Annie");
//        c2.accept("Annie");
//
//        Map<String, Integer> map = new HashMap<>();
//        BiConsumer<String, Integer> b1 =  map::put;
//        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
//
//        b1.accept("chicken", 7);
//        b2.accept("chick", 1);
//
//        System.out.println(map);

        Predicate<String> p1 =  String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();

        System.out.println(p1.test(""));
        System.out.println(p2.test(""));


        BiPredicate<String, String> b1 =  String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);

        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("chicken", "chick"));
    }
}
