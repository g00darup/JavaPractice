package GrokkingCodingInterview.dynamicprogpatrn.DnC;

import java.util.Arrays;

public class MissingNumber {

    // Performing a binary search like technique to find the missing number in the array
    public static int missingNumber(int arr[], int size) {

        int leftLimit = 0, rightLimit = size - 1; // initialize limits

        // Keeping in check the Boundary Cases!
        if (arr[leftLimit] != 1) // if '1' is not present at 0th index
            return 1;

        while (leftLimit <= rightLimit) // binary search
        {
            int middle = (leftLimit + rightLimit) / 2;

            // Element at index `i` should be `i+1` (e.g. 1 at index 0). If this is the first element  which is not `i`+ 1, then  missing element is middle+1
            if (arr[middle] != middle + 1 && arr[middle - 1] == middle)
                return middle + 1;

            // If this is not the first missing element search in left subarray
            if (arr[middle] != middle + 1)
                rightLimit = middle - 1; // update rightLimit to search only left

                // if it follows index+1 property then search in right side
            else
                leftLimit = middle + 1; // update leftLimit to search only right
        }
        return -1; // if no element missing
    }

    public static void main(String args[]) {
        int[] input1 = {1,2,4};
        int[] input2 = {1,2,3,4,6};
        int[] input3 = {2,3,4,5,6};
        int[] input4 = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Find the Missing Number!");
        System.out.println(Arrays.toString(input1) + " --> " + missingNumber(input1, input1.length));
        System.out.println(Arrays.toString(input2) + " --> " + missingNumber(input2, input2.length));
        System.out.println(Arrays.toString(input3) + " --> " + missingNumber(input3, input3.length) + "\t\t\t\t\t\t Corner Case I - Handeled");
        System.out.println(Arrays.toString(input4) + " --> " + missingNumber(input4, input4.length) + "\t\t\t Corner Case II - Handeled");
    }
}