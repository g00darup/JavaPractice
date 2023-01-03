package main.java.edu.java.stream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

//public class BiConsumerDemo implements BiConsumer<Integer, Integer> {
public class BiConsumerDemo{
    public static void main(String[] args) {
        BiConsumer<Integer,Integer> biConsumer = (Integer a,Integer b)-> System.out.println(a+b);
        biConsumer.accept(10,20);

        BiConsumer<Integer,Integer> subtraction = (Integer a,Integer b)-> System.out.println(a+b);
        subtraction.accept(10,20);


        BiConsumer<Integer,Integer> mul = (Integer a,Integer b)-> System.out.println(a*b);
        mul.accept(10,20);


        BiConsumer<Integer,Integer> div = (Integer a,Integer b)-> System.out.println(a/b);
        div.accept(10,20);

        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(1,"Java");
        map.put(2,"C++");
        map.put(3,"Rust");
        map.put(4,"JavaScript");
        map.put(5,"GO");

        map.forEach((k,v)->{
            System.out.println(k+"---"+v);
        });
    }

//    @Override
//    public void accept(Integer a, Integer b) {
//        System.out.println(a+b);
//    }
}
