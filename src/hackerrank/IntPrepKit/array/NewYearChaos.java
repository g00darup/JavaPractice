package hackerrank.IntPrepKit.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    static int d;

    public static int minimumBribes(List<Integer> q) {
        // Write your code here
        //Map<Integer,Integer> q_map = q.stream().collect(toMap(q::indexOf,q::get));
        Map<Integer,Integer> q_map = new HashMap<>();

        for(int i=0;i<q.size();i++){
            q_map.put(q.get(i),i);
        }

        List<Integer> sorted = q.stream().sorted().collect(toList());
        //Map sorted_map = sorted.stream().collect(toMap(sorted::get,sorted::indexOf));

        d=0;

        for(int i=0;i<sorted.size();i++) {
            int di = i-q_map.get(sorted.get(i));
                if(di>0)
                    d+=di;
        }

        return d;
    }

}

public class NewYearChaos {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().
                        replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //new NewYearChaos().run();
    }

    int test_case_number = 1;

    void check(long expected, long output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        int expected_1 = 1;
        int output_1 = Result.minimumBribes(List.of(1,2,3,5,4,6,7,8));
        check(expected_1, output_1);


        int expected_2 = 3;
        int output_2 = Result.minimumBribes(List.of(4,1,2,3));
        check(expected_2, output_2);

        int expected_3 = 3;
        int output_3 = Result.minimumBribes(List.of(2,1,5,3,4));
        check(expected_3, output_3);


        int expected_4 = 4;
        int output_4 = Result.minimumBribes(List.of(2,1,6,3,4,5));
        check(expected_4, output_4);

    }
    void printInteger(long n) {
        System.out.print("[" + n + "]");
    }
}
