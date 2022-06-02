package JavaFunctionalPractice.chap2;

import java.util.IllegalFormatException;

public class LambdaExamples {
    public static void main(String[] args) {
        IntegerConcatenation ic = (m, n) -> {
            if(m==0) {
                throw new IllegalArgumentException();
            } else {
                return m + ":" + n;
            }
        };
        System.out.println(ic.concatenate(12, 45));
    }
}

@FunctionalInterface
interface IntegerConcatenation {
    public String concatenate(Integer n1, Integer n2)
            throws IllegalFormatException;
}