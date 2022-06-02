package GrokkingCodingInterview.Algorithm.sorting;

import GrokkingCodingInterview.Algorithm.Helper;

public class SelectionSort {
    Helper helper;
    static int [] selcSort(int[] arr){
        int minInd;
        int count=0;
        while(count<arr.length){
            minInd = Helper.findMin(arr,count,arr.length-1);
            int temp = arr[count];
            arr[count] = arr[minInd];
            arr[minInd] = temp;
            count++;
        }
        return arr;
    }

    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        arr = selcSort(arr);
        for (int i:arr)
            System.out.println(i);

    }

}
