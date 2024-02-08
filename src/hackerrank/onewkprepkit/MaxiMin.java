package hackerrank.onewkprepkit;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MaxiMin {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int minSum=0;
        int maxSum =0;



        int min=0;
        int max=0;
        min = min(arr).get();
        max =  max(arr).get();

        minSum = minSum + min;
        maxSum = maxSum + max;

        arr.remove(min);
        arr.remove(max);

        int finalMin = min;
        int finalMax = max;
        List<Integer> copy1 = arr.stream().filter(e->(e!= finalMin || e!=finalMax)).collect(toList());

        min = min(copy1).get();
        max =  max(copy1).get();

        minSum = minSum + min;
        maxSum = maxSum + max;

        copy1.remove(min);
        copy1.remove(max);
        int finalMin2 = min;
        int finalMax2 = max;
        List<Integer> copy2 = copy1.stream().filter(e->(e!= finalMin2 || e!=finalMax2)).collect(toList());

        min = min(copy2).get();
        max =  max(copy2).get();

        minSum = minSum + min;
        maxSum = maxSum + max;

        copy2.remove(min);
        copy2.remove(max);

        List<Integer> copy3 = copy2.stream().filter(e->(e!= finalMin2 || e!=finalMax2)).collect(toList());

        min = min(copy3).get();
        max =  max(copy3).get();

        minSum = minSum + min;
        maxSum = maxSum + max;

        System.out.println(minSum+" "+maxSum);
    }

    static Optional<Integer> min(List<Integer> ints){
        return ints.stream().min(Comparator.comparing(Integer::valueOf));
    }
    static Optional<Integer> max(List<Integer> ints){
        return ints.stream().min(Comparator.comparing(Integer::valueOf));
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
        Integer arr[] = {1,2,3,4,5};
        MaxiMin.miniMaxSum(Arrays.stream(arr).toList());

//        bufferedReader.close();
    }
}


