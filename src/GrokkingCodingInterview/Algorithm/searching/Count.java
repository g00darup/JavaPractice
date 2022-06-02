package GrokkingCodingInterview.Algorithm.searching;

/*
Problem statement #
Given a sorted array of integers, find the frequency of
the occurrence of a given target value in the array.
If the value is not found in the array at all, return 0.

Input #
A sorted array and a key value to search for

Output #
The number of times thae value occurs in the array

Sample input #
int arr[] = {-5,-3,0,1,3,3,3,4,5};
int s = 3;
Sample output #
3
 */

public class Count
{
    public static int calcFreq(int[]arr, int key)
    {
        int arrSize = arr.length;
        int index = binarySearch(key, arr, arrSize);

        if (index == -1)   // If element is not present
            return 0;

        int count = 1; // Initialzing a count

        int start = index - 1; // Counting the ones present on the left
        while (start >= 0 && arr[start] == key) {
            count++;
            start--; // Decrement the start index if found
        }

        int end = index + 1;  // Counting the ones present on the right
        while (end < arrSize && arr[end] == key) {
            count++;
            end++; // Increment the end index if found
        }
        return count;
    }

    static int binarySearch(int s, int arr[], int arrSize) {
        if (arrSize <= 0)
            return -1;

        if (arrSize == 1) {
            if (arr[0] == s)
                return 0;
            else
                return -1;
        }

        int start = 0;
        int end = arrSize - 1;
        int mid;

        while (start <= end) {
            mid = (end + start) / 2;
            if (arr[mid] < s)
                start = mid + 1;
            else if (arr[mid] > s)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {-5,-3,0,1,3,3,3,3,4,5};
        int key = 3;
        System.out.println("The key \""+ key + "\" occurs " + calcFreq(arr, key) + " times in the Array.");
    }

        public static int calcFreq2(int arr[], int key)
        {
            // Finding the index of the first occurrence
            int arrSize = arr.length;
            int start = 0, end = arrSize - 1, mid, result = -1;
            while (start <= end) {
                mid = (start + end) / 2;
                if (arr[mid] == key) {
                    result = mid;
                    end = mid - 1;
                } else if (arr[mid] > key) {
                    end = mid - 1;
                } else if (arr[mid] < key) {
                    start = mid + 1;
                }
            }

            // Finding the index of the second occurrence
            int start1 = 0, end1 = arrSize - 1, mid1, result1 = -1;
            while (start1 <= end1) {
                mid1 = (start1 + end1) / 2;
                if (arr[mid1] == key) {
                    result1 = mid1;
                    start1 = mid1 + 1;
                } else if (arr[mid1] > key) {
                    end1 = mid1 - 1;
                } else if (arr[mid1] < key) {
                    start1 = mid1 + 1;
                }
            }

            // If one of them is not found, return their difference
            if (result == -1 || result1 == -1)
                return (result1 - result);

            return (result1 - result + 1);
        }


    }
