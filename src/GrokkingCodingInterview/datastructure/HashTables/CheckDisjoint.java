package GrokkingCodingInterview.datastructure.HashTables;

import java.util.HashSet;
/*
Problem Statement #
In this problem, you have to implement the isDisjoint() function to check whether two given arrays are disjoint or not. Disjoint arrays mean that their intersection returns nothing or there are no common elements in them. The assumption is that there are no duplicate elements in each array. An illustration is also provided for your understanding.

Function Prototype: #
boolean isDisjoint(int []arr1,int[]arr2);
Here, arr1 and arr2 are integer arrays.

Output: #
It returns true if arr1 and arr2 are disjoint, or else it returns false.

Sample Input #
arr1 = [9,4,3,1,-2,6,5]
arr2 = [7,10,8]
Sample Output #
true
 */
public class CheckDisjoint {

    public static boolean isDisjoint(int[] arr1, int[] arr2) {

        //Create an HashSet and store all values of arr1
        HashSet< Integer > hSet = new HashSet < >();

        for (int i = 0; i < arr1.length; i++) {
            if (!hSet.contains(arr1[i])) hSet.add(arr1[i]);
        }

        //Traverse arr2 and check if arr1 contains any arr2 element
        for (int i = 0; i < arr2.length; i++) {
            if (hSet.contains(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String args[]) {

        int[] arr1 = {9, 4, 3, 1, -2, 6, 5};
        int[] arr2 = {7, 10, 8};
        int[] arr3 = {1, 12};
        System.out.println(isDisjoint(arr1, arr2));
        System.out.println(isDisjoint(arr1, arr3));

    }
}
