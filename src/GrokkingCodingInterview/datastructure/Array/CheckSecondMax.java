package GrokkingCodingInterview.datastructure.Array;

public class CheckSecondMax {
    public int findSecondMaximum(int[] arr){
        int max = arr[0];
        int secMax = arr[1];
        // Write your code here
        int count = 1;
        while (count<arr.length){
            if(arr[count]>max){
                max=arr[count];
            }
            count++;
        }

        count=2;
        while (count<arr.length){
            if(arr[count]>secMax && arr[count]<max){
                secMax=arr[count];
            }
            count++;
        }


        return secMax;
    }

    public static int findSecondMaximum2(int[] arr) {

        int max = Integer.MIN_VALUE;;
        int secondmax = Integer.MIN_VALUE;

        // Keep track of Maximum value, whenever the value at an array index is greater
        // than current Maximum value then make that max value 2nd max value and
        // make that index value maximum value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondmax = max;
                max = arr[i];
            }
            else if (arr[i] > secondmax && arr[i] != max) {
                secondmax = arr[i];
            }
        }//end of for-loop

        return secondmax;
    } //end of findSecondMaximum
}
