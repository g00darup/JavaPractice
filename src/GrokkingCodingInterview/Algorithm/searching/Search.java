package GrokkingCodingInterview.Algorithm.searching;

import GrokkingCodingInterview.Algorithm.Helper;

class Search {
    static int binarySearch(int s, int arr[], int arrSize) {
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
        return Integer.MIN_VALUE; // Ignore this for now -
    }
    //What If the element being searched for isn’t in the array? #
    static int binarySearch2(int s, int arr[], int arrSize) {
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

    // Driver code to test the function
    public static void main(String args[]) {
        int arr[] = {5,4,1,410,5,95,4,-100,20,0};
        int arrSize = 10;
        int key = 1;
        int index = binarySearch(key, arr, arrSize);
        Helper obj = new Helper();
        obj.printArray(arr, arrSize);
        if (index != -1)
            System.out.println("Your Key \"" + key + "\" is found at index \"" + index + "\"");
        else
            System.out.println("Your Key \"" + key + "\" not found in the array: ");


    }
}