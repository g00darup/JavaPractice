package GrokkingCodingInterview.datastructure.Array;

import java.util.Arrays;

public class ProductArray {
    public static int[] findProduct(int arr[])
    {
        int [] result = new int[arr.length];

        int prod=1;

        for(int i:arr){
            prod=prod*i;
        }

        for(int i=0;i<arr.length;i++){
            result[i] = prod/arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        new ProductArray().run();
    }

    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        boolean result =  Arrays.equals(expected,output);
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
        int[] array_a_1 = {1,2,3,4};
        int[] expected_1 = {24,12,8,6};
        int[] output_1 = findProduct(array_a_1);
        check(expected_1, output_1);
        // Add your own test cases here
    }
}
