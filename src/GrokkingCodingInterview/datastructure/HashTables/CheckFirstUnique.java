package GrokkingCodingInterview.datastructure.HashTables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem Statement #
In this problem, you have to implement the int findFirstUnique(int[] arr) function that will look for a first unique integer which appears only once in the whole array. You must use hashing to implement this function in the most optimized way possible.

Note: We consider zero to be an integer for the premise of this challenge.

Function Prototype #
int findFirstUnique(int[] arr)
Output #
The first unique element in the array.

Sample Input #
arr = {9, 2, 3, 2, 6, 6}
Sample Output #
9
 lnput
 Output
    24
    12
    8
    6
    9
    2
    3
    2
    6
    6
    9
    4
    5
    1
    2
    0
    4
    5
 Output
 lnput
Note: We already covered this problem in chapter 2, but the approach used was different. Previously, a brute-force strategy was used because Hash Tables had not been discussed then. That solution was inefficient and should not be used in a technical interview. Now, let us create an optimized solution for the same problem using hashing!


 */
public class CheckFirstUnique {
    public static int findFirstUnique(int[] arr) {

        Map<Integer, Integer> countElements = new HashMap<>();
        //If the element does not exist in the HashMap
        //Add that element with value = 0
        //or else update the number of occurrences of that element by adding 1
        for (int i = 0; i < arr.length; i++) {
            if(countElements.containsKey(arr[i])){
                int occurence = countElements.get(arr[i]) + 1;
                countElements.put(arr[i], occurence);
            }
            else
                countElements.put(arr[i], 0);
        }
        //Traverse the array and check the number of occurrences
        //Return the first element with 0 occurences
        for (int i = 0; i < arr.length; i++) {
            if (countElements.get(arr[i]) == 0) {
                return arr[i];
            }
        }
        //If no such element is found, return -1
        return -1;
    }

    public static void main(String args[]) {

        int[] arr = {2, 54, 7, 2, 6, 54};

        System.out.println("Array: " + Arrays.toString(arr));

        int unique = findFirstUnique(arr);
        System.out.print("First Unique in an Array: " + unique);

    }
}