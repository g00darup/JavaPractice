package main.java.com.ipk.WuCh;

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
    //    protected String up = "/";
    //     protected String dwn = "\\";
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int lastLevel=0;
        int seaLevel=0;
        int valleys = 0;
        StringBuffer sb = new StringBuffer("-");
        String lastStep = "-";
        String curStep = "";
        for(int i=0;i<steps;i++){
            sb.append("-");
            curStep = path.substring(i,i+1);
            lastLevel = seaLevel;
            if(curStep.equals("D"))
                seaLevel = seaLevel-1;

            if(curStep.equals("U"))
                seaLevel = seaLevel+1;

            if(i>1 && seaLevel==0 && seaLevel>lastLevel)
                valleys = valleys+1;
        }
        // sb.append("-");
        // System.out.println(sb.toString());
        return valleys;
    }



}

public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int steps = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String path = bufferedReader.readLine();
//
//        int result = Result.countingValleys(steps, path);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//        bufferedReader.close();
//        bufferedWriter.close();
//
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
        int expected_1 = 1;
        int steps = 8;
        String path ="UDDDUDUU";
        int output_1 = Result.countingValleys(steps, path);
        check(expected_1, output_1);
        // Add your own test cases here
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
