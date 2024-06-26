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

class Res {
    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        if(a!=null && a.size()==1)
            return a.get(0);

        List<Integer> sorted = new ArrayList<>();
        sorted = a.stream().sorted().toList();

        for (int i=0;i<sorted.size()-1;i=i+2){
            if(i+1<sorted.size() && sorted.get(i)!=sorted.get(i+1)){
                return sorted.get(i);
            }
        }
        return sorted.get(sorted.size()-1);
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        List<Integer> primaryDiagonal = getPrimaryDiagonal(arr);
        List<Integer> secondaryDiagonal = getSecondaryDiagonal(arr);

        return Math.abs(primaryDiagonal.stream()
                .mapToInt(Integer::intValue)
                .sum()-secondaryDiagonal.stream()
                .mapToInt(Integer::intValue)
                .sum());
    }

    public static List<Integer> getPrimaryDiagonal(List<List<Integer>> matrix) {
        List<Integer> primaryDiagonal = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            primaryDiagonal.add(matrix.get(i).get(i));
        }
        return primaryDiagonal;
    }

    public static List<Integer> getSecondaryDiagonal(List<List<Integer>> matrix) {
        List<Integer> secondaryDiagonal = new ArrayList<>();
        int n = matrix.size();
        for (int i = 0; i < n; i++) {
            secondaryDiagonal.add(matrix.get(i).get(n - 1 - i));
        }
        return secondaryDiagonal;
    }
}

public class LoneInteger {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> a = Stream.of(bufferedReader.readLine().
//                         replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
        List a = List.of(1, 1, 2);
        int result = Res.lonelyinteger(a);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
        System.out.println(result);
    }
}
