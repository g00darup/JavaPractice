package main.java.edu.java.lambda.MethodReference;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
@FunctionalInterface
interface  Printable{
    void print(String msg);
}

public class MethodReferenceDemo {

    public void display(String msg){
        msg = msg.toUpperCase();
        System.out.println(msg);
    }

    public static int add(int a, int b) {
        return a+b;
    }
    public static void main(String[] args) {
        //methd ref to a stat method
        Function<Integer,Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));

        //using method reference
        Function<Integer,Double> functionMethRef = Math::sqrt;
        System.out.println(functionMethRef.apply(4));

        //lambra expr
        BiFunction<Integer,Integer,Integer> biFuncLambda = (a,b) -> MethodReferenceDemo.add(a,b);
        System.out.println(biFuncLambda.apply(10,20));
        //using method reference
        BiFunction<Integer,Integer,Integer> biFunc = MethodReferenceDemo::add;
        System.out.println(biFunc.apply(10,20));

        //2. Method reference to an instance method of an object
        MethodReferenceDemo demo = new MethodReferenceDemo();
        //lambda expr
        Printable printable = (msg) -> demo.display(msg);
        printable.print("hello world");
        //using meth ref
        Printable print = demo::display;
        print.print("Hello wold");

        Function<String,String> stringFunction = (String input) -> input.toLowerCase();
        System.out.println(stringFunction.apply("Java hava"));

        Function<String,String> stringFunction2 = String::toLowerCase;
        System.out.println(stringFunction.apply("Java hava"));

        String[] strArr = {"A","E","I","O","U","a","e","i","o","u"};
        //using lambda
        Arrays.sort(strArr,(s1,s2)->s1.compareToIgnoreCase(s2));
        //Using method reference
        Arrays.sort(strArr,String::compareToIgnoreCase);

        //4. ref to a constructor
        List<String> fruits = new ArrayList<>();
        fruits.add("Naana");
        fruits.add("apple");
        fruits.add("mango");
        fruits.add("watermelon");

        Function<List<String>, Set<String>> setFunction = (fruitList) -> new HashSet<>(fruitList);
        System.out.println(setFunction.apply(fruits).getClass());

        Function<List<String>, Set<String>> setFunction2 =  HashSet::new;
        System.out.println(setFunction2.apply(fruits));
    }
}
