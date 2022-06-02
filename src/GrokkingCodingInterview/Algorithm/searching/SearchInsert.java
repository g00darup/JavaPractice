package GrokkingCodingInterview.Algorithm.searching;

/*
Input #
A sorted array, and a target value

Output #
The index at which the array should be inserted
OR the index at which it is already present

Sample input #
  int arr[] = {1,3,5,6};
  int target = 5;
Sample output #
   2
 */

public class SearchInsert
{
    public static int insertPosition(int[] arr, int target)
    {
        int arrSize = arr.length;
        //checking of size of array is less than 1
        if(arrSize < 1)
            return -1;
        int start = 0;
        int end = arrSize - 1;
        int mid = 0, pos = 0;
        //traversing the array
        while(start <= end)
        {
            //calculating the mid value
            mid = start + (end-start)/2;
            //if mid value equals target return the mid index
            if(arr[mid] == target)
                return mid;
                //if mid value greater than target serach in the left half
            else if(arr[mid] > target)
            {
                end = mid - 1;
                pos = mid;
            }
            //otherwise search in the right half
            else
            {
                start = mid + 1;
                pos = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String args[])
    {
        int[]arr = {0, 1, 2, 3, 5, 6};

        // Example 1
        System.out.println("Index to Insert " + "\"5\" is " + insertPosition(arr, 5));

        // Example 2
        System.out.println("Index to Insert " + "\"3\" is " + insertPosition(arr, 3));

        // Example 3
        System.out.println("Index to Insert " + "\"7\" is " + insertPosition(arr, 7));
    }
}