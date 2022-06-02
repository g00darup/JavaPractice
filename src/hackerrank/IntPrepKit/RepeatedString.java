package hackerrank.IntPrepKit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        char ch[] = s.toCharArray();
        int aCount=0;
        long totalCount=0;
        long[] posOccur;
        int steps = s.length();


        for(int count=0;count<ch.length;count++){
            if(ch[count]=='a'){
                aCount++;
            }
        }

        if(aCount==0)
            return 0;

        posOccur = new long[aCount];
        int i=0;
        int count=0;
        for(count=0;count<ch.length;count++){
            if(ch[count]=='a'){
                posOccur[i] = count;
                i++;
            }

        }
        i=0;
        int factor=0;
        long k=1;

        while(k<=n){
            for(i=0;i<posOccur.length;i++) {
                if (posOccur[i] + factor * steps < n) {
                    totalCount++;
                }
            }
            i=0;
            factor++;
            k=k+steps;
        }


        return totalCount;

        }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scanner.nextLine();
//
//        long n = scanner.nextLong();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        long result = repeatedString(s, n);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();

        new RepeatedString().run();
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
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
        long expected_1 = 4;
        long output_1 = repeatedString("abcac", 10);
        check(expected_1, output_1);


        long expected_2 = 7;
        long output_2 = repeatedString("aba", 10);
        check(expected_2, output_2);

        long expected_3 = 0;
        long output_3 = repeatedString("ccd", 10);
        check(expected_3, output_3);

        long expected_4 = 1000000000;
        long output_4 = repeatedString("a", 1000000000);
        check(expected_4, output_4);
        // Add your own test cases here

        long expected_5 = 10;
        long output_5 = repeatedString("aaa", 10);
        check(expected_5, output_5);

    }
    void printInteger(long n) {
        System.out.print("[" + n + "]");
    }
}
