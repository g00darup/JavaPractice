package GrokkingCodingInterview.Algorithm.searching;

/*
Problem statement #
Implement a function that sorts an array of 0's0
​′
​​ s, 1's1
​′
​​ s and 2's2
​′
​​ s. This is called the Dutch national flag problem. Since the number OO
can be represented as the blue color, 11 as the white color, and 22 as the red color,
we want the array to form the Dutch flag.

Try solving this problem inplace and in linear time without using any extra space!

Input #
The input is an array of 0's0
​′
​​ s, 1's1
​′
​​ s and 2's2
​′
​​ s

Output #
The output is a printed array where the numbers 00, 11, and 22 are sorted

Sample input #
arr = {2, 0, 0, 1, 2, 1, 0}
Sample output #
0 0 0 1 1 2 2
Coding exercise #
Take a close look and design a step-by-step algorithm before jumping to the implementation.
This problem is designed for your practice, so try to solve it on your own first. If you get stuck, you can always refer to the hint and solution provided in the code tab. Good Luck!
 */

import java.util.Arrays;

public class DutchFlag
{
    public static void dutchNationalFlag(int [] arr)
    {
        int i = 0;
        int mid = 0;
        int j = arr.length - 1;

        while (mid <= j)
        {
            //if value at mid equals to zero
            if (arr[mid] == 0)
                mySwap(arr, i++, mid++);
                //if value at mid equals to two
            else if (arr[mid] == 2)
                mySwap(arr, mid, j--);
                //if value at mid equals to one
            else if (arr[mid] == 1)
                mid++;
        }
    }

    static void mySwap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[])
    {
        int[] arr = {2, 0, 0, 1, 2, 1};
        dutchNationalFlag(arr);
        System.out.println(Arrays.toString(arr)); // import java.util.Arrays; for this functionality
    }
}
