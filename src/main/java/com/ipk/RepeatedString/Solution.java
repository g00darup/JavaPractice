package main.java.com.ipk.RepeatedString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        long len = s.length();
        int steps = (int) (n/len);
        long [] out = new long[(int) n];
        long [] init = new long[(int)len];
        long count = 0;
        Arrays.fill(out, 0);
        Arrays.fill(init,0);


        for(int c=0;c<len;c++){
            if(s.charAt(c) =='a'){
                init[c] = 1;
            }
        }

        for(int c=0;c<steps;c++){
            for(int i=0;i<init.length;i++){
                if(init[i]==1)
                    out[(int) (i+c*len)] = 1;
            }
        }

        for(int l=0;l<out.length;l++){
            if(out[l]==1)
                count++;
        }


    return count;
    }

}

public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        long n = Long.parseLong(bufferedReader.readLine().trim());
//
//        long result = Result.repeatedString(s, n);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }

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
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        long expected_1 = 7;
        long steps = 10;
        String path ="aba";
        long output_1 = Result.repeatedString(path,steps);
        check(expected_1, output_1);
        // Add your own test cases here
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
