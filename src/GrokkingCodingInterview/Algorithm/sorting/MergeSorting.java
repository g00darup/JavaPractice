package GrokkingCodingInterview.Algorithm.sorting;

import GrokkingCodingInterview.Algorithm.Helper;

import java.util.Arrays;

public class MergeSorting {

    public static void mergeSort(int[] arr, int left, int right) {

        if(left<0 || right<0)
            return;

        if(right > left){
            int mid = left + (right-left)/2;

            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            int [] leftArr = new  int[mid-left];
            int [] rightArr = new int[right-mid];
            System.arraycopy(arr,left,leftArr,0,(mid-left));
            System.arraycopy(arr,mid,rightArr,0,(right-mid));

            merge(arr,leftArr,rightArr);

        }

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i,j,k;

        // Initialzing the sizes of the temporary arrays
        int lenLeft = mid-left+1;
        int lenRight = right-mid;
        // Initializing temporary arrays
        int leftArr[] = new int[lenLeft];
        int rightArr[] = new int[lenRight];

        // Copying the given array into the temporary arrays
        for (i = 0; i < lenLeft; i++)
            leftArr[i] = arr[left + i];

        for (j = 0; j < lenRight; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Merging the temporary arrays back into the given array
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = left; // Initial index of the given array

        // This is the main part of the algorithm
        // Iterate over both arrays and copy the element that is smaller to the
        // given array.
        while (i < lenLeft && j < lenRight) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }


        // Copying the remaining elements of leftArr[], if there are any
        while (i < lenLeft) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArr[], if there are any
        while (j < lenRight) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i,j,k;

       // Merging the temporary arrays back into the given array
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = 0; // Initial index of the given array

        // This is the main part of the algorithm
        // Iterate over both arrays and copy the element that is smaller to the
        // given array.
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }


        // Copying the remaining elements of leftArr[], if there are any
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArr[], if there are any
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        mergeSort(arr, 0, arrSize - 1);
        Helper obj = new Helper();
        obj.printArray(arr, arrSize);
    }
}
