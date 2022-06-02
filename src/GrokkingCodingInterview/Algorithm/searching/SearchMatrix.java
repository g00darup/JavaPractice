package GrokkingCodingInterview.Algorithm.searching;
/*
Problem statement #
Implement a function that tells whether a given target is present in the sorted matrix or not.

Input #
The inputs are a sorted matrix and the target that needs to be checked if it is present or not.

Output #
The output should return a boolean variable set to true if the target is found, or false if the target is not found.
 */

public class SearchMatrix {
    public static Object findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        int min = 0;
        int max = numberOfRows * numberOfColumns - 1;

        while (min <= max)
        {
            int middle = (min + max) / 2;
            int row = middle / numberOfColumns;
            int col = middle % numberOfColumns;
            if (target < matrix[row][col])
            {
                max = middle - 1;
            }
            else if (target > matrix[row][col])
            {
                min = middle + 1;
            }
            else
            {
                return true;
            }

        }
        return false;
    }

    public static void main(String args[]) {
        int[][] matrix = {
                {10, 11, 12, 13},
                {14, 15, 16, 17},
                {27, 29, 30, 31},
                {32, 33, 39, 50}
        };

        // Example 1
        Object x = findKey(matrix, 4, 4, 80);
        System.out.println("Search for 80 returned: " + x);

        // Example 2
        x = findKey(matrix, 4, 4, 15);
        System.out.println("Search for 15 returned: " + x);
    }
}