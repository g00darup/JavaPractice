package GrokkingCodingInterview.Algorithm.searching;

/*
Input #
An integer array

Output #
The output is an ArrayList containing the duplicates if they exist and an empty ArrayList if they don’t.

Sample input #
  int arr[] = {1, 3, 4, 3, 5, 4, 100, 100};
Sample output #
  ArrayList <Integer> output = {3, 4, 100};

 */

import java.util.ArrayList;
import java.util.Arrays;

public class Duplicates {
    public static ArrayList < Integer > findDuplicates(int[] arr) {
        int arrSize = arr.length;
        ArrayList < Integer > duplicates = new ArrayList < Integer > (arrSize);
        for (int i = 0; i < arrSize; i++) {
            for (int j = i + 1; j < arrSize; j++) {
                if (arr[i] == arr[j] && !duplicates.contains(arr[i]))
                    duplicates.add(arr[i]);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        int arr[] = {
                7,
                5,
                4,
                3,
                5,
                11,
                7,
                11,
                9,
                3
        };
        ArrayList< Integer > dupes = findDuplicates(arr);
        System.out.println("Duplicates in " + Arrays.toString(arr) + " are " + dupes);

        int arr1[] = {
                6,
                5,
                17
        };
        dupes = findDuplicates(arr1);
        System.out.println("Duplicates in " + Arrays.toString(arr1) + " are " + dupes);
    }
}