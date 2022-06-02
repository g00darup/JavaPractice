package GrokkingCodingInterview.dynamicprogpatrn.DnC;
/*
Inversion count represents how far or close an array is from being sorted. If an array is sorted, the inversion count is 0. But if it’s sorted in the reverse order, the inversion count is maximum.

Let’s say there are two elements arr[i], arr[j] of an array int[]arr. If arr[i] > arr[j] where i < j, there is inversion.

For example:

 (9, 5, 6, 11, 8, 10)

 Number of inversions = 5

 i-e: (9, 5), (9, 6), (9, 8), (11, 8), (11, 10)

Have a look at the following illustration for a better understanding:

    7
    6
    5
    8
    7
    6
    7
    5
    6
    5
The illustration shows how to count the number of Inversions for a given Array.
Problem statement #
Given an array of n integers, find the inversion count for its elements.

Input #
The input is an array containing integers in any order int [] arr. (It might contain negative values too!)

Output #
The output is int inversionCount. An integer is returned after counting the total number of inversions.

 */

import java.util.Arrays;

public class Inversion {

    // A helper method that sorts & finds the number of inversions in the array recursively
    public static int countInversionsUtil(int arr[], int temp[], int left, int right) {

        int mid, invCount = 0;
        if (right > left) {

            mid = (right + left) / 2;

            // Inversion count is the sum of inversions in left-part + right-part + number of inversions in merge phase
            invCount = countInversionsUtil(arr, temp, left, mid);
            invCount += countInversionsUtil(arr, temp, mid + 1, right);

            // Merge both parts
            invCount += merge(arr, temp, left, mid + 1, right);
        }
        return invCount;
    }
/*
Explanation #
Let’s go through the step-by-step break down of the above solution:

Line 57: The driver program calls the function countInversions() with int[]arr passed as the parameter.

Lines 47-49: Calculate the size of the input array and call the utility function countInversionsUtil() with the parameters int arr[], int temp[] (temp array for auxiliary functions), int left (starting index of array), and int right(terminating index of the array).

Lines 9-13: Calculate the middle index of the array and recursively call countInversionsUtil() on both the right and left parts of the array. (applying divide and conquer)

Line 16: Call the function to merge both the left and right parts of the array.

Lines 22-49: The merge function merges the right and left of the array. Then, it returns invCount as it is always equal to the sum of invCount in the left part, right part, and the number of inversions in the merge phase.

Time complexity #
The running time complexity is O(nlogn).O(nlogn).
 */
    // This method will merge two sorted arrays and return the inversion count
    public static int merge(int arr[], int temp[], int left, int mid, int right) {

        int invCount = 0;

        int i = left; // for left subarray
        int j = mid; // for right subarray
        int k = left; // for resultant merged subarray
        while ((i <= mid - 1) && (j <= right)) {

            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];

            else {

                temp[k++] = arr[j++];
                invCount = invCount + (mid - i);
            }
        }

        return invCount;
    }

    // wrapper function for countInversionsUtil
    public static int countInversions(int arr[]) {

        int size = arr.length;
        int temp[] = new int[size];
        return countInversionsUtil(arr, temp, 0, size - 1);
    }

    // Driver program
    public static void main(String[] args) {
        System.out.println("Given Array Inversion Count\n");

        int[] arr = { 3, 2, 8, 4 };
        System.out.println(Arrays.toString(arr) + " -> " + countInversions(arr));

        int[] arr1 = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(arr1) + " -> " + countInversions(arr1));

        int[] arr2 = { 10, 9, 8, 7, 6 };
        System.out.println(Arrays.toString(arr2) + " -> " + countInversions(arr2));
    }

    public static int InvCountNaive(int[] arr) {
        int size = arr.length;
        int count = 0; // variable to store inversion count
        for (int curr = 0; curr < size - 1; curr++)
            for (int right = curr + 1; right < size; right++)
                if (arr[curr] > arr[right])
                    count++;

        return count;
    }
}
