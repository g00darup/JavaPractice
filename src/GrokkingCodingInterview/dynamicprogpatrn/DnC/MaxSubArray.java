package GrokkingCodingInterview.dynamicprogpatrn.DnC;

import java.util.Arrays;

/*
Problem statement #
Given an integer array, return the maximum subarray sum.
The array may contain both positive and negative integers and is unsorted.

Input #
The input is an Array of integers int arr[].

Output #
The output is the maximum subarray sum int.


 */
public class MaxSubArray {
    // helper function to find the max of 3 numbers

    public static int max(int n1, int n2, int n3) {

        return Math.max(Math.max(n1, n2), n3);
    }
    // Finding the largest possible sum in given array
    public static int crossingSum(int arr[], int left, int mid, int right) {
        // mid + elements to the left of mid

        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {

            sum = sum + arr[i];
            if (sum > leftSum)
                leftSum = sum;
        }

        // mid + elements to the right of the mid
        sum = 0; int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {

            sum = sum + arr[i];
            if (sum > rightSum)
                rightSum = sum;
        }
        // sum of elements to the left and right, including mid
        return leftSum + rightSum;
    }

    /*
Line 50: The driver function calls the maxSumArr(arr, left, right) function for the first time.

Line 36: If there is only one element, return it.

Line 39: Find the midpoint.

Line 42-44: Return the maximum of following three using the helper function max(n1, n2, n3).

Subarray with the maximum sum in the left half (make a recursive call)

Subarray with the maximum sum in the right half (make a recursive call)

Subarray with the maximum sum such that the subarray crosses the midpoint

Lines 12-19: The crossing sum can be easily found in linear time. Include the elements to the left of the mid and calculate their maximum sum.

Lines 22-28: Then, include the elements to the right of the mid and calculate their maximum sum.

Lines 30: Simply return the sum of both left and right maximum sum.

Summing it all up!
You have to find the maximum sum starting from the midpoint and ending at some point to the left of mid, then find the maximum sum starting from mid + 1 and ending with some point to the right of mid + 1. Finally, add up the two and return.
     */
    // Gives maximum subarray sum in the given array
    public static int maxSumArr(int arr[], int left, int right) {

        if (left == right) // if there is only 1 element in the array
            return arr[left];

        int mid = (left + right) / 2; // find the mid point

        /* Return maximum of following three possible cases */
        return max(maxSumArr(arr, left, mid), // Max Subarray Sum present in the left half
                maxSumArr(arr, mid + 1, right), // Max Subarray Sum present in the right half
                crossingSum(arr, left, mid, right)); // Max Subarray Sum including the midpoint */
    }
    public static void main(String args[]) {
        int[][] inputs = {{0, 1, 2, 5}, {-1, -2, -3, -4, -5}, {-2, 10, 7, -5, 15, 6}, {-1, -3, 4, -1, -2, 1, 5, -3}};
        for (int i = 0; i < inputs.length; i++) {
            if (i == 0)
                System.out.println("Case I - All Positive Inputs\n" + Arrays.toString(inputs[i]) + "\t---> \tMax Subarr Sum: \"" + maxSumArr(inputs[i], 0, inputs[i].length - 1) + "\"\n");

            else if (i == 1)
                System.out.println("Case II - All Negative Inputs\n" + Arrays.toString(inputs[i]) + "\t---> \tMax Subarr Sum: \"" + maxSumArr(inputs[i], 0, inputs[i].length - 1) + "\"\n");

            else if (i == 2) {
                System.out.println("Case III - Both Positive & Negative Inputs");
                System.out.println(Arrays.toString(inputs[i]) + "\t---> \tMax Subarr Sum: \"" + maxSumArr(inputs[i], 0, inputs[i].length - 1) + "\"");
            } else if (i == 3)
                System.out.println(Arrays.toString(inputs[i]) + "\t---> \tMax Subarr Sum: \"" + maxSumArr(inputs[i], 0, inputs[i].length - 1) + "\"\n");
        }
    }
    /*
    The idea of Kadane’s algorithm is to search all of the positive contiguous segments of the array (currMax is used for this) while keeping track of the contiguous maximum sum segment among all of the positive segments (maxSoFar is used for this). Each time we get a positive sum, compare it with maxSoFar and update maxSoFar if it is greater.

Line 22: The driver program calls the function maxSumArr(int arr[]).

Line 5: Use the built-in function arr.length to find the size of the input array.

Lines 6-7: Initialize currMax and maxSoFar with the starting element of the input array arr[0].

Lines 9-10: Iterate over the whole array by adding the current element to the currMax and compare its existing value with itself.

Line 11: Update the maxSoFar by comparing it with currMax so that it contains the max sum by far.

Line 13: Simply return maxSoFar to get the max sum of the subarray.
     */

    public static int maxSumArr(int arr[])
    {
        int size = arr.length;
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < size; i++) {
            currMax = Math.max(arr[i], currMax+arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}