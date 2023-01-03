package main.java.com.testplayground.lambda;

import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class Functional {
    public static void main(String[] args) {
//        Function<String, Integer> f1 =  Stringlength;
//        Function<String, Integer> f2 = x -> x.length();
//
//        System.out.println(f1.apply("cluck"));  // 5
//        System.out.println(f2.apply("cluck"));  // 5
//
//        BiFunction<String, String, String> b1 =  Stringconcat;
//        BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
//
//        System.out.println(b1.apply("baby ", "chick")); // baby chick
//        System.out.println(b2.apply("baby ", "chick")); // baby chick
//
//        UnaryOperator<String> u1 =  StringtoUpperCase;
//        UnaryOperator<String> u2 = x -> x.toUpperCase();
//
//        System.out.println(u1.apply("chirp"));
//        System.out.println(u2.apply("chirp"));
//
//        BinaryOperator<String> b3 =  Stringconcat;
//        BinaryOperator<String> b4 = (string, toAdd) -> string.concat(toAdd);
//
//        System.out.println(b3.apply("baby ", "chick")); // baby chick
//        System.out.println(b4.apply("baby ", "chick")); // baby chick

//       Function<List<String>> ex1 = x -> x.get(0); // DOES NOT COMPILE
//
//        UnaryOperator<Long> ex2 = (Long l) -> 3.14; // DOES NOT COMIPLE
        //UnaryOperator<Long> ex2 = (Long l) -> 3L;

        //Predicate ex4 = StringisEmpty;
//        Predicate<X> ex4 = Ymove;  // DOES NOT COMPILE
//       // X x = new X();
//        Y y = new Y();
//        //ex4.test(x);
//        ex4.test(y);
        Optional<Double> opt = average(90, 100);
   if (opt.isPresent())
      System.out.println(opt.get()); // 95.0

        System.out.println(opt.orElse(Double.NaN));
          System.out.println(opt.orElseGet(() -> Math.random()));
          System.out.println(opt.orElseThrow(() -> new IllegalStateException()));
    }

    public static Double avg(List<Integer> list){

        return  list.stream().mapToDouble(i ->  i).sum()/list.size();

    }
    
       public static Optional<Double> average(int ... scores) {
      if (scores.length == 0) return Optional.empty();
      int sum = 0;
      for (int score : scores) sum += score;
      return Optional.of((double) sum / scores.length);
   }
}

class X {
    static boolean move(X obj){
        System.out.println("X move");
        return true;
    }
}
class Y extends X {
    static boolean move(Y obj){
        System.out.println("Y move");
        return true;
    }
}
class Z extends Y { }
