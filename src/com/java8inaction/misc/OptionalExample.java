package com.java8inaction.misc;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> day = Optional.of("SUNNY");
        Optional<String> empty = Optional.empty();

        day.ifPresent((s)-> System.out.println(s));
        empty.ifPresent(t-> System.out.println("no data"));

        String out = "avc";
        Optional<String> optSt = Optional.of(out);
        optSt.filter(res->res.contains("abc")).
                map(String::toLowerCase).
                ifPresent(System.out::println);

    }
}
