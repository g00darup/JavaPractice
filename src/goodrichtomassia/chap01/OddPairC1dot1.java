package goodrichtomassia.chap01;

import recruiting.arrays.Rev2MakeEqual;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddPairC1dot1 {
    List<Integer> OddPair(Integer[] arr) {
        List<Integer> odds = Arrays.stream(arr).filter(e -> e % 2 != 0).collect(Collectors.toList());
        return odds;
    }

    int test_case_number = 1;

    void check(List<Integer> expected, List<Integer> output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        Integer[] array_a_1 = {1, 2, 3, 4};
        List<Integer> expected_1 = List.of(1, 3);
        List<Integer> output_1 = OddPair(array_a_1);
        check(expected_1, output_1);

        Integer[] array_a_2 = {2, 3, 4, 6, 8, 7};
        List<Integer> expected_2 = List.of(3, 7);
        List<Integer> output_2 = OddPair(array_a_2);
        check(expected_2, output_2);
        // Add your own test cases here

    }

    public static void main(String[] args) {
        new OddPairC1dot1().run();
    }
}


