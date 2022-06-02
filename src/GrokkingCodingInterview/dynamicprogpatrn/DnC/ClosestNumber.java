package GrokkingCodingInterview.dynamicprogpatrn.DnC;

import java.util.Arrays;

/*
Problem statement #
Given a sorted array int arr[] and target int target, find and return the closest number to the target in the array.

Note that the array may have duplicate and negative values.

Input #
The inputs are:

int arr[] - a sorted array of integers
int target - the target number
Output #
The output is int, closest number to the given target

Sample input #
{1, 2, 4, 5, 6, 6, 8, 9} , target = 11

Sample output #
9


 */
public class ClosestNumber {

    // The method finds the closer of 2 number to the target - assuming that `second` is greater than `first` and `target` lies in the middle
    public static int closer(int first, int second, int target) {

        if (target - first >= second - target)
            return second;
        else
            return first;
    }
    /*
    Now, let’s look at a step-by-step breakdown of the code. We’re given the array, its number of elements, and the target value:

Line 53: The driver program calls the function closestNumber() with int arr[], int target passed as parameters.

Lines 17 and18: Handling boundary case - q, check if the target element is lesser than the first element. If so, return the first element. element.

Lines 20 and 21: Handling boundary case - 2, check if the target element is greater than the last element. If so, return the last element.

Lines 25-48: Perform a method similar to binary search to deal with the rest of the elements:

Line 27: Find the mid of the array.

Lines 28 and 29: If the middle element is equal to the target, the absolute difference is 0. Hence, the middle element is the closest to the target element.

Lines 31-37: If the target element is less than the middle element, check for the element with the smallest difference in the left subarray, which has smaller elements than the middle element. Update j since it keeps track of the rightmost limit.

Lines 38-45: If the target element is greater than the middle element, check it in the right subarray, which has bigger elements than the middle element. Update i since it keeps track of the leftmost limit.

Lines 62: Return the remaining element, which still has the minimum absolute difference with the target even if it isn’t the same as the target value.

Time complexity #
The time complexity of this solution is O(logn)O(logn) because we are looking at the middle element at each step and essentially dropping one half of the array. We are left with only half of the elements we began with to check.
     */

    // Returns the closest number to `target` from the input array `arr[]`
    public static int closestNumber(int arr[], int target) {

        int n = arr.length;
        // Dealing with the Boundary Cases
        if (target <= arr[0]) // if target is lesser than the starting element of array
            return arr[0]; // return starting element as the array is sorted

        if (target >= arr[n - 1]) // if target is greater than the last element of array
            return arr[n - 1]; // return last element

        int i = 0, j = n, mid = 0;

        while (i < j) // Performing Binary search to find closest element
        {
            mid = (i + j) / 2; // get middle index
            if (arr[mid] == target) // if element at middle is equal to target it's the closest, return that.
                return arr[mid];

            if (target < arr[mid]) // if target is less than the element at middle, search in left subarray
            {
                if (mid > 0 && target > arr[mid - 1]) // If target is greater than previous to mid, return closest of two
                    return closer(arr[mid - 1], arr[mid], target);

                j = mid; // Search in rest of the left subarray
            }
            else // if target is greater than the element at middle, search in the right subarray
            {

                if (mid < n - 1 && target < arr[mid + 1])
                    return closer(arr[mid], arr[mid + 1], target);

                i = mid + 1; // Search in rest of the right subarray
            }
        }
        return arr[mid]; // One element left after search, that must be the closest, return that
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, 5, 6, 6, 8, 9 };
        int target = 11;
        System.out.println(Arrays.toString(arr) + "\tTarget = " + target + "  --->   Closest Number = " + closestNumber(arr, target));

        int arr1[] = {3,5,7,9,11,17};
        target = 10;
        System.out.println(Arrays.toString(arr1) + "\t\tTarget = " + target + "  --->   Closest Number = " + closestNumber(arr1, target));
    }
}
