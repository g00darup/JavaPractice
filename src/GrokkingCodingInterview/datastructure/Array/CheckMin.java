package GrokkingCodingInterview.datastructure.Array;

import java.util.Arrays;

public class CheckMin {
    public static int findMinimum(int[] arr) {
        int min = arr[0];
        // Write your code here
        int count = 1;
        while (count<arr.length){
            if(arr[count]<min){
                min=arr[count];
            }
            count++;
        }
        return min;
    }
    public static void main(String[] args) {
        new CheckMin().run();
    }

    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result =  (expected==output);
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
        int[] array_a_1 = {9, 2, 3, 6};
        int expected_1 = 2;
        int output_1 = findMinimum(array_a_1);
        check(expected_1, output_1);
        // Add your own test cases here
    }

}
