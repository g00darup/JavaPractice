package GrokkingCodingInterview.datastructure.Array;

import java.util.Arrays;

public class FindMaxSol {
    public static int findMaxSumSubArray(int[] arr) {
        if(arr.length<1){
            return 0;
        }

        int max = arr[0];
        int currMax=arr[0];

        int lengthArr = arr.length;

        for(int i=1; i<lengthArr; i++){
            if(currMax<0){
                currMax = arr[i];
            }else {
                currMax += arr[i];
            }

            if(max < currMax){
                max = currMax;
            }


        }
        return max;
    }


    public static void main( String args[] ) {
        int[] arr1 = {-4,2,-5,1,2,3,6,-5,1};
        int[] arr2 = {1, 7, -2, -5, 10, -1};
        System.out.println("Array: "+ Arrays.toString(arr1));
        System.out.println("Sum: " + findMaxSumSubArray(arr1));
    }
}
