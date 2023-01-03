package main.java.edu.java.stream;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
        //implements BiPredicate<String, String> {
    public static void main(String[] args) {
//        BiPredicate<String,String> biPredicate = new BiPredicateDemo();
//        System.out.println(biPredicate.test("ram","ram"));
//        System.out.println(biPredicate.test("bala","lala"));

        BiPredicate<String,String> biPredicate = (String s, String s2) -> s.equals(s2);
        System.out.println(biPredicate.test("ram","ram"));
        System.out.println(biPredicate.test("bala","lala"));

        BiPredicate<Integer,Integer> bi2= (a,b) -> a>b;
        BiPredicate<Integer,Integer> bi3= (a,b) -> a==b;

        boolean res1 = bi2.test(10,20);
        System.out.println(res1);

        boolean res2 = bi3.test(0,20);
        System.out.println(res2);

     }

//    @Override
//    public boolean test(String s, String s2) {
//        return s.equals(s2);
//    }
}
