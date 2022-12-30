package main.java.com.regex;

import java.util.Comparator;

public class LambdaExpression {
    public static void main(String[] args) {
        String p1 ="new";
        String p2 ="view";
        Comparator<String> comp1= (String a1,String a2)-> a1.compareTo(a2);

//        Runnable o = () -> {
//            System.out.println("Tricky");
//        };
    }
}
