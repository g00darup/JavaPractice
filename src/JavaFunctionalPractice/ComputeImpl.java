package JavaFunctionalPractice;

import java.util.Arrays;
import java.util.List;

public class ComputeImpl implements Computable {

    @Override
    public int compute() {
        return 1;
    }

    @Override
    public int compute2() {
        return 0;
    }

    public static void main(String[] args) {
        ComputeImpl ci = new ComputeImpl();
        //System.out.println(ci.doubleNumber(2));

        String names[] = {"Sally", "George", "Paul"};
        List<String> list = Arrays.asList(names);

        list.stream().
                map(name->name.length()).
                forEach(System.out::println);
    }
}