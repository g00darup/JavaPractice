package GrokkingCodingInterview.dynamicprogpatrn.DnC;

import java.util.Arrays;

/*
Problem statement #
Given an array of integers, and taking all the boundary cases into consideration, shuffle the array without using extra space.

Input #
The input is an array of integers int arr[].

Output #
The output is a boolean that returns true if shuffling can be performed on the given int arr[]. If shuffling is not possible, it returns false.

Sample input #
{1, 3, 5, 7, 2, 4, 6, 8}

Sample output #
[1, 2, 3, 4, 5, 6, 7, 8]
 */
public class ShuffleArray
{
    public static void shuffleArr(int arr[], int size)  // Swap elements from left to right
    {
        for (int i = 0, q = 1, k = size; i < size; i++, k++, q++)
            for (int j = k; j > i + q; j--)
                swap(arr, j-1, j);
    }
    public static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main( String args[] )
    {
        int [] arr = {3, 5, 7, 9, 11, 13};
        shuffleArr(arr, arr.length/2);
        System.out.println( Arrays.toString(arr) );
    }

    /*
    Explanation #
Let’s go through the code step by step, so you have a better understanding:

Line 44: Call the function ShuffleArray() with the input int[]arr passed as a parameter.

Lines 22-26: Check if the size of the input int[]arr is equal to 2. Return true if it is and keep the array the same.

Lines 27-31: Check if the size of the input is oddodd. If so, return from the function as it is. No shuffling required!

Lines 32-36: Call the utility function for further processing.

Lines 7-9: Divide the given array into two smaller subarrays of equal length and find the middle of those subarrays.

Lines 11-12: Swap the elements from the right subarray to the left subarray.

Lines 15-16: Make recursive calls to the utility function with the updated arguments, as calculated by finding the middle on lines 7-9.

Time complexity #
This solution gives the worst-case time complexity of O(nlogn)O(nlogn).
     */
        public static void shuffleArrayUtil(int arr[], int left, int right) // Method to shuffle 2*n sized array's elements
        {

            if (right - left <= 1) // Base case: return array if only 2 elements are remaining
                return;

            int middle = (left + right) / 2; // compute middle index
            int temp = middle + 1; // first half of second array
            int mmiddle = (left + middle) / 2; // second half of first array

            for (int i = mmiddle + 1; i <= middle; i++) // swapping elements for subarray
                swap(arr, i, temp++);

            // Pass splitted first and second half of the array to utility function
            shuffleArrayUtil(arr, left, middle);
            shuffleArrayUtil(arr, middle + 1, right);
        }

        public static Object ShuffleArray(int arr[]) {

            int size = arr.length;
            if (size == 2) // corner case 1 check
            {
                System.out.println("After: " + Arrays.toString(arr));
                return true;
            } else if (size % 2 != 0) // corner case 2 check
            {

                System.out.println("After: " + Arrays.toString(arr));
                return false;
            } else {

                shuffleArrayUtil(arr, 0, size -1 );
                System.out.println("After: " + Arrays.toString(arr));
                return true;
            }
        }

          static void test(String args[]) {
            int[][] arr = {{0, 1}, { 11, 12, 13}, {0, 1, 2, 3, 4, 5}, { 1, 3, 5, 7, 2, 4, 6, 8 }};
            boolean check = true;
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Before: " + Arrays.toString(arr[i]));
                ShuffleArray(arr[i]);
                System.out.println();
            }
        }

}
