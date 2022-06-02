package JavaFunctionalPractice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FirstLJFP {
    public static void main(String[] args) {
        Integer arr[] = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(arr);

        //list.forEach(n-> System.out.println(n));

        Function<Integer,Integer> absThenNegate =
                ((Function<Integer,Integer>)Math::negateExact)
                        .compose(Math::abs);

        System.out.println(absThenNegate.apply(-25));
        System.out.println(absThenNegate.apply(24));

        Function<Integer,Integer>negateThenAbs =
                ((Function<Integer,Integer>)Math::negateExact)
                        .andThen(Math::abs);

        System.out.println(negateThenAbs.apply(-25));
        System.out.println(absThenNegate.apply(24));

    }
}
