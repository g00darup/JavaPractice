package main.java.com.ipk.Arr.LeftRotate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        for(int i=0;i<d;i++){
            int temp=a.get(0);
            a.remove(0);
            a.add(a.size(),temp);
        }
        return a;
    }

}

public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int d = Integer.parseInt(firstMultipleInput[1]);
//
//        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = Result.rotLeft(a, d);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }

    int test_case_number = 1;
    void check(List<Integer> expected, List<Integer> output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        List<Integer> expected_1 = Arrays.asList(5,1,2,3,4);;
        List<Integer> path = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer>  output_1 = Result.rotLeft(path,4);
        check(expected_1, output_1);
    //        Add your own test cases here
    //        Integer [] path2 ={0,0,0,1,0,0};
    //        c = Arrays.asList(path2);
    //        output_1 = Result.rotLeft(c);
    //        check(expected_1, output_1);
    }

    public static void main(String[] args) {
        new Solution().run();
    }


}
