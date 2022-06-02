package GrokkingCodingInterview.dynamicprogpatrn.DnC;
/*
Floor functions #
A floor function takes a real number xx and returns the greatest Integer less than or equal to x.x.

For Example,

floor(x) = \lfloor x \rfloorfloor(x)=⌊x⌋

floor(7.5) = \lfloor 7.5 \rfloor = 7floor(7.5)=⌊7.5⌋=7

Ceiling functions #
A ceiling function takes a real number xx and returns the smallest Integer greater than or equal to x.x.

For Example:

ceil(x) = \lceil x \rceilceil(x)=⌈x⌉

ceil(7.5) = \lceil 7.5 \rceil = 8ceil(7.5)=⌈7.5⌉=8

Problem statement #
You are given a collection of sorted integers say int [] inputs. For any given number xx, return a floorfloor and ceilceil value of xx from the given array inputs. If either ceil or floor does not exist in the given array, -1 should be returned in its place.

Input #
The inputs are:

An int x containing any real number
An array of integers inputs
An output array
Output #
The outputs is two Integer variables containing floorfloor and ceilingceiling value of x.
Have a look at the following illustration for a better understanding:

    3
    1
    2
    3
    5
    7
 Floor
 Ceiling
 x =
    2
    5
Note that for this example we are only considering integer inputs (xx) and not real ones (float/double).
 */

import java.util.Arrays;

public class FloorCeiling {

    public static int findFloor(int[] arr, int x) // Function to find floor of x in a sorted array arr[]
    {
        int left = 0, right = arr.length - 1;
        int floor = -1; // initialize floor to -1, if -1 is returned as it is, then floor does not exist!
        while (left <= right) {

            int mid = (left + right) / 2; // find the middle value
            if (arr[mid] == x) // if x is equal to mid element, it is the floor value
                return arr[mid];
            else if (x < arr[mid]) // if x is less than the mid element, floor exists in the left subArr[left...mid-1]
                right = mid - 1;
            else // if x is more than the mid element, floor exists in the right subArr[mid...right].
            {
                floor = arr[mid];
                left = mid + 1;
            }
        }
        return floor;
    }

    public static int findCeiling(int[] arr, int x) // Function to find ceiling of input x in a sorted array
    {
        int left = 0, right = arr.length - 1;
        int ceil = -1; // initialize ceiling value to -1, if -1 is returned as it is, then ceil doesnot exit!

        while (left <= right) {

            int mid = (left + right) / 2; // find the middle value
            if (arr[mid] == x) // if x is equal to middle element, it is the ceiling
                return arr[mid];
            else if (x < arr[mid]) // if x is less than the mid element, ceil exists in the left subArray[left...mid-1]
            {
                ceil = arr[mid];
                right = mid - 1;
            } else // if x is more than the mid element, ceil exists in the right subArr[mid...right]

                left = mid + 1;
        }
        return ceil;
    }
    // wraper function to call both Floor and Ceiling Functions and then store the output in the `output` array
    public static void findFloorCeiling(int[] input, int x, int[] output) {

        output[0] = findFloor(input, x);
        output[1] = findCeiling(input, x);
    }



    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 5, 7};
        int[] output = new int[2];
        FloorCeiling.findFloorCeiling(inputs, 4, output);
        System.out.println("Floor and Ceil of 4 is: " + Arrays.toString(output));

    }
}
/*
Explanation #
Let’s take you to the step-by-step code break down to gain a better understanding of the solution:

Line 44 - 48: The wrapper function explicitly calls findFloor(input, x) and findCeiling(input, x), respectively, and stores the result in the array called output.
floorfloor function

Continue the iteration until the search space is completely consumed:

Initialize the floor to -1.
Find the mid of the array.
If xx is equal to the middle element, it is the floor. Return the floor.
If xx is less than the mid element, update the right limit to mid - 1 and keep looking for the floor value in the left subarray.
If xx is more than the mid element, update the floor to arr[mid] and the left limit to mid + 1, and keep searching for the target in the right subarray.
ceilceil function

Continue the iteration until the search space is completely consumed:

Initialize the ceil to -1.
Find the mid of the array.
If xx is equal to the middle element, it is the ceil. Return the ceil.
If xx is less than the mid element, update the right limit to mid - 1 and update ceil to arr[mid]. Now search for the ceil in the left subarray.
If xx is more than the mid element, update the left limit to mid + 1 and keep searching for the target in the right subarray.


Time complexity #
You might have figured it out already, and yes the running complexity for this is the same as the binary search, i.e., O(log(n))O(log(n)), where nn is the size of the array.
 */