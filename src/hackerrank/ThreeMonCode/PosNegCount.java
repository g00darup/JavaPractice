package hackerrank.ThreeMonCode;

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

class Res9 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int nCount =0;
        int zCount =0;
        int pCount =0;

        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>0)
                pCount++;
            else if(arr.get(i)<0)
                nCount++;
            else
                zCount++;
        }

        System.out.printf("%.6f\n",(double)pCount/arr.size());
        System.out.printf("%.6f\n",(double)nCount/arr.size());
        System.out.printf("%.6f\n",(double)zCount/arr.size());

    }

}

public class PosNegCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().
                        replaceAll("\\s+$", "").
                        split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Res9.plusMinus(arr);

        bufferedReader.close();
    }
}
