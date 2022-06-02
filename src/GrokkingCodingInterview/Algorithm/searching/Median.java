package GrokkingCodingInterview.Algorithm.searching;

import java.util.Arrays;

public class Median {
    static int maximum(int a, int b) {
        return a > b ? a : b;
    }

    // Function to find minimum
    static int minimum(int a, int b) {
        return a < b ? a : b;
    }
    public static double getMedian2(int array1[], int array2[]) {
        int sizeOfArray1 = array1.length;
        int sizeOfArray2 = array2.length;
        int arraySize = sizeOfArray1 + sizeOfArray2;
        int arraySizeMid = arraySize / 2;

        int i = 0;
        int j = 0;
        int count;

        int median = -1;
        int previousMedian = -1;

        if (arraySize % 2 == 1) { // if the total size of the two arrays is odd
            for (count = 0; count <= arraySizeMid; count++) {
                if (i != sizeOfArray1 && j != sizeOfArray2) {
                    if (array1[i] > array2[j]) {
                        median = array2[j];
                        j++;
                    } else {
                        median = array1[i];
                        i++;
                    }
                } else if (i < sizeOfArray1) {
                    median = array1[i];
                    i++;
                } else {
                    median = array1[j];
                    j++;
                }
            }
            return median;

        } else { // if the total size of the two arrays is even
            for (count = 0; count <= arraySizeMid; count++) {
                previousMedian = median;
                if (i != sizeOfArray1 && j != sizeOfArray2) {
                    if (array1[i] > array2[j]) {
                        median = array2[j];
                        j++;
                    } else {
                        median = array1[i];
                        i++;
                    }
                } else if (i < sizeOfArray1) {
                    median = array1[i];
                    i++;
                } else {
                    median = array1[j];
                    j++;
                }
            }
            return (median + previousMedian) / 2.0;
        }
    }
    static double getMedian(int[] array1, int[] array2) {
        int size1 = array1.length;
        int size2 = array2.length;
        int end_index = size1;
        int start_index = 0, i = 0, j = 0, median = 0;

        while (start_index <= end_index) {
            i = (start_index + end_index) / 2;
            j = ((size1 + size2 + 1) / 2) - i;

            if (i < size1 && j > 0 && array2[j - 1] > array1[i])
                start_index = i + 1;

            else if (i > 0 && j < size2 && array2[j] < array1[i - 1])
                end_index = i - 1;

            else {
                if (i == 0)
                    median = array2[j - 1];

                else if (j == 0)
                    median = array1[i - 1];
                else
                    median = maximum(array1[i - 1],
                            array2[j - 1]);
                break;
            }
        }

        if ((size1 + size2) % 2 == 1)
            return (double) median;


        if (i == size1)
            return (median + array2[j]) / 2.0;


        if (j == size2)
            return (median + array1[i]) / 2.0;

        return (median + minimum(array1[i],
                array2[j])) / 2.0;
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

        System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is " + getMedian(array1, array2));

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

        System.out.println("The median of " + Arrays.toString(array3) + " and " + Arrays.toString(array4) + " is " + getMedian(array3, array4));
    }
}