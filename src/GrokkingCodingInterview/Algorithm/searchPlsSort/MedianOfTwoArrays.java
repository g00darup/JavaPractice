package GrokkingCodingInterview.Algorithm.searchPlsSort;

import java.util.Arrays;

/*
Input #
Two sorted arrays

Output #
The median of two arrays

Sample input #
A = {100};
B = {1, 5, 8, 10, 20}
Sample output #
9                 // Take mean of 2 central values
                  // (8+10)/2 = 18/2 = 9
 */
public class MedianOfTwoArrays {

    public static double getMedian(int array1[], int array2[]) {

        int len1 = array1.length;
        int len2 = array2.length;
        int totLen = len1 + len2;
//        int[] res = new int[totLen];
        double median = Double.MIN_VALUE;

        //mergeArrays2(array1, array2, len1, len2, totLen, res, i, j);

         merge(array1,array1.length, array2,array2.length);

        if (totLen%2==0)
            median = (array1[(totLen/2)-1]+array1[(totLen/2)])/2.0;
        else
            median = array1[(totLen/2)];

        return median;



    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int left[] =new int [m];
        int[] right = new int[n];

        System.arraycopy(nums1,0,left,0,m);
        System.arraycopy(nums2,0,right,0,n);
        merge(res,left, right);

        nums1 = new int[res.length];
        nums1 = res;
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

    private static void mergeArrays2(int[] array1, int[] array2, int len1, int len2, int totLen, int[] res, int i, int j) {
        int c;
        for(c = 0; c<totLen; c++){
            if ((i< len1 && j< len2)) {
                if (array1[i] < array2[j]) {
                    res[c] = array1[i];
                    i++;
                }else{
                    res[c] = array2[j];
                    j++;
                }
            }else if(i<len1 && j==len2){
                res[c] = array1[i];
                i++;

            }else if(j<len2 && i==len1){
                res[c] = array2[j];
                j++;
            }

        }
    }

    public static void main(String args[]) {
        int array1[] = {
                5,
                8,
                10,
                11,
                20
        };
        int array2[] = {
                900
        };

        //System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is " + getMedian(array1, array2));

        // Example 2
        int array3[] = {
                1,
                2,
                3,
                4,
                5
        };
        int array4[] = {
                100,
                200,
                300,
                400
        };

       // System.out.println("The median of " + Arrays.toString(array3) + " and " + Arrays.toString(array4) + " is " + getMedian(array3, array4));


        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = {2,5,6};
        int n = 3;

        merge(nums1,m,nums2,n);

        for (int b: nums1) {
            System.out.println(b);
        }
    }
}
