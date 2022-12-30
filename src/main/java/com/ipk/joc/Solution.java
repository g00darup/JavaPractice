package main.java.com.ipk.joc;

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

class Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        int len=0,count=0,steps=0;
        if(c!=null)
            len=c.size();

        while(count+2<len){
            if(c.get(count)==0){
                   if(c.get(count+2)==0){
                       count = count+2;
                       steps++;
                   }else if(c.get(count+1)==0){
                       count = count+1;
                       steps++;
                   }
               }
            }

        if(count+1<len){
            if(c.get(count+1)==0){
                steps++;
            }

        }


        return steps;
    }

}

public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.jumpingOnClouds(c);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
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
        int expected_1 = 4;
        Integer [] path ={0,0,1,0,0,1,0};
        List<Integer> c = Arrays.asList(path);
        int output_1 = Result.jumpingOnClouds(c);
        check(expected_1, output_1);
        // Add your own test cases here

        expected_1 = 3;
        Integer [] path2 ={0,0,0,1,0,0};
        c = Arrays.asList(path2);
        output_1 = Result.jumpingOnClouds(c);
        check(expected_1, output_1);
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
