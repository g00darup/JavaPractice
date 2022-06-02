package GrokkingCodingInterview.datastructure.Array;

import java.util.Arrays;
import java.util.Iterator;

public class CheckSum
{
    public int[] findSum(int[] arr, int n)
    {
        int[] result = new int[2];
        int len = arr.length;
        int [] expectedKey = new int[len];

        for (int i = 0; i < len; i++) {
                expectedKey[i] = n-arr[i];
        }

        Arrays.sort(expectedKey);

        for(int i = 0; i<len;i++){
            if(search(expectedKey,arr[i])){
                result[0] = arr[i];
                result[1] = n - arr[i];
                break;
            }
        }
        // write your code here
        return result;   // return the elements in the array whose sum is equal to the value passed as parameter
    }

    boolean search(int[] arr,int k){
        return binarySearch(arr,0,arr.length-1,k);
    }

    boolean binarySearch(int[] arr, int left, int right, int k){
        if(right>=left) {
            int mid = (left + right) / 2;

            if (arr[mid] == k)
                return true;
            else if (arr[mid] > k) {
                return binarySearch(arr, left, mid - 1, k);
            } else if (arr[mid] < k) {
                return binarySearch(arr, mid + 1, right, k);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new CheckSum().run();
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
        int[] array_a_1 = {1, 21, 3, 14, 5, 60, 7, 6};
        int val = 27;
        int[] expected_1 = {21,6};
        int[] expected_2 = {6,21};
        int[] output_1 = findSum(array_a_1,val);
        check(expected_1, output_1);
        check(expected_2, output_1);
        // Add your own test cases here
    }
}