package hackerrank.onewkprepkit;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        List<BigInteger> sum = new ArrayList<>();
        BigInteger tot = BigInteger.ZERO;

        for(int i=0;i<arr.size();i++){
            BigInteger val = BigInteger.valueOf(arr.get(i).intValue());
            System.out.println(val);
            tot = tot.add(val);
        }

        for(int j=0;j<arr.size();j++){
            sum.add(j,(tot.subtract(BigInteger.valueOf(arr.get(j).intValue()))));
        }

        Optional<BigInteger> max = sum.stream().max(Comparator.naturalOrder());
        Optional<BigInteger> min = sum.stream().min(Comparator.naturalOrder());

        System.out.println(max.get() +" "+min.get());
    }

}

public class MM {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
