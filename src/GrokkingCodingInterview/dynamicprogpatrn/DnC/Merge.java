package GrokkingCodingInterview.dynamicprogpatrn.DnC;

import java.util.Arrays;

/*
Merge k sorted arrays #
Suppose there exists a k number of arrays (always a positive integer),
each containing a fixed number of elements = n. Each individual array is sorted,
and we want to merge all of the n * kn∗k elements into one sorted array.

Have a look at the following illustration. We initially have four arrays and each array has three elements:

svg viewer
Sorting k sorted arrays into one k*n sized array
Problem statement #
Given a 2D array of k rows and 33 sorted columns and an empty 1D output array of size k*nk∗n,
copy all the elements from the k sorted arrays to the k*nk∗n output array using a divide and conquer approach.

Input #
The inputs are:

int[][] arr (2D array of integers)
int k (number of sorted arrays in arr)
int[] result (empty k*nk∗n sized 1D array)
Output #
The output is void (you are required to copy all the sorted elements in the given result array).
Sample input #
{{16, 25, 36}, {2, 9, 15}, {22, 55, 67}, {79, 38, 99}}

Sample output #
{2, 9, 15, 16, 22, 25, 36, 38, 55, 67, 79, 99}


 */
public class Merge {

    public static int n = 4; // Each array has 3 elements, i.e. our 2D array has 3 columns
/*
This is how the algorithm works:

Line 74: The driver program calls the function mergeSortedArrays(arr, k, result); to merge the sorted 1D arrays stored in the input 2D array.

Lines 72 and 73: Initialize k to be equal to the number of subarrays (1D arrays), and the result array to be of appropriate size, i.e., for k arrays of n elements each.

Line 65:Call the wrapper mergeSortedRecursive() method, passing to it the input arrays arr[][], left, and right limits of arrays defining the range and result matrix result.

Lines 46-49: Check the base condition for the recursive call. When left == right, we just copy the rest of the elements in appropriate positions in the result array.

Lines 54 and 57: At each call to the function, call the left and right half of the range recursively so that they might be sorted and stored in the outputoutput array.

Line 60: Merge the left and right half. For merging, this is how we determine the range of indexes for the left and right halves in the output array:

Line 7: The left part starts from the index left * nleft∗n of the output array.
Line 8: The right part starts from the index ((left + right) / 2 + 1) * n((left+right)/2+1)∗n of the output array.
Lines 10-11: Compute the size of the left and right array.

Lines 16-20: Temporarily store the data of the left and right arrays.

Lines 27-39: Finally, we use the pointer technique to merge the left and right array to produce the merged result.

Time complexity #
Merging the k sorted array creates a recursion tree of log(k)log(k) height because at each step the number of remaining arrays becomes half. The algorithm takes a time of O(n*k)O(n∗k) at each recursive call. So, the time complexity of this approach comes out to be O( n*k * log(k))O(n∗k∗log(k)).
 */
    public static void sortAndMerge(int left, int right, int[] result) {

        int leftIndex = left * n;
        int rightIndex = ((left + right) / 2 + 1) * n;

        int leftSize = ((left + right) / 2 - left + 1) * n;
        int rightSize = (right - (left + right) / 2) * n;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++) // Storing data in left array
            leftArr[i] = result[leftIndex + i];

        for (int i = 0; i < rightSize; i++) // Storing data in right array
            rightArr[i] = result[rightIndex + i];

        // Temporarily store the index of the left and right array
        int leftCurr = 0;
        int rightCurr = 0;
        int currIndex = leftIndex; // Storing the current index of the output array

        while (leftCurr + rightCurr < leftSize + rightSize) // implementing two pointers merging technique
        {
            if (rightCurr == rightSize || (leftCurr != leftSize && leftArr[leftCurr] < rightArr[rightCurr])) {

                result[currIndex] = leftArr[leftCurr];
                leftCurr++;
                currIndex++;
            }
            else {

                result[currIndex] = rightArr[rightCurr];
                rightCurr++;
                currIndex++;
            }
        }
    }
    // Implementing the merge-sort alogorithm
    public static void mergeSortedRecursive(int[][] arr, int left, int right, int[] result) {

        if (left == right) // Base condition, recursion breaks when we reach one element
        {
            for (int i = 0; i < n; i++)
                result[left * n + i] = arr[left][i];
        }
        else {

            // Sorting the left half of the array
            mergeSortedRecursive(arr, left, (left + right) / 2, result);

            // Sorting the right half of the array
            mergeSortedRecursive(arr, (left + right) / 2 + 1, right, result);

            // Merging both the right and left halves of the array
            sortAndMerge(left, right, result);
        }
    }
    public static void mergeSortedArrays(int[][] arr, int k, int[] result) {

        mergeSortedRecursive(arr, 0, k - 1, result);
    }


    public static void main(String[] args) {
        int arr[][] = {{ 16, 25, 36, 79 }, { 2, 9, 15, 38 }, { 22, 55, 67, 98 }};
        int k = arr.length, n = arr[k - 1].length;
        int[] result = new int[n * k];
        Merge.mergeSortedArrays(arr, k, result);
        System.out.print(Arrays.toString(result));
    }
}