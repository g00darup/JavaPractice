package GrokkingCodingInterview.dynamicprogpatrn.dp;

import java.util.Arrays;

/*
Problem statement #
Given an array of integers, write a function to find if any two subsets of the input array exist such that the sum of both subsets is equal. You can assume that the array will only consist of positive integers.

Input #
An array of positive integers

Output #
The output is a boolean. It will be True if such subsets exist and False if they do not

Sample input #
int set[] = {1, 2, 3, 4};
Sample output #
true          // (The 2 subsets will be 1,4 & 2,3)

 */
public class Partition
{
    public static int canPartitionRecursive(int[][]lookupTable, int num[], int sum, int currentIndex)
    {
        int numLength = num.length;
        // base check
        if (sum == 0)
            return 1;
        if (numLength == 0 || currentIndex >= numLength)
            return 0;

        // if we have not already processed a similar problem
        if (lookupTable[currentIndex][sum] == -1) {
            // recursive call after choosing the number at the currentIndex
            // if the number at currentIndex exceeds the sum, we shouldn't process this
            if (num[currentIndex] <= sum)
            {
                if (canPartitionRecursive(lookupTable, num, sum - num[currentIndex], currentIndex + 1) == 1) {
                    lookupTable[currentIndex][sum] = 1;
                    return 1;
                }
            }
            // recursive call after excluding the number at the currentIndex
            lookupTable[currentIndex][sum] = (int)canPartitionRecursive(lookupTable, num, sum, currentIndex + 1);
        }
        return lookupTable[currentIndex][sum];
    }

    public static int canPartition(int[] num)
    {
        int numLength = num.length;
        int sum = 0;
        for (int i = 0; i < numLength; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0)
            return 0;

        int [][] lookupTable = new int [numLength][];
        for (int i = 0; i < numLength; i++)
        {
            lookupTable[i] = new int[sum / 2 + 1];

            for (int j = 0; j < sum / 2 + 1; j++)
                lookupTable[i][j] = -1;
        }
        return canPartitionRecursive(lookupTable, num, sum / 2, 0);
    }

    public static void main(String args[])
    {
        int set1[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(set1) + "\t--->\t" + canPartition(set1));
        int set2[] = {1, 1, 3, 4, 7};
        System.out.println(Arrays.toString(set2) + "\t--->\t" + canPartition(set2));
        int set3[] = {2, 3, 4, 6};
        System.out.println(Arrays.toString(set3) + "\t--->\t" + canPartition(set3));
    }

        public static Object canPartition2(int[]num)
        {
            int n = num.length;
            // find the total sum
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += num[i];

            // if 'sum' is a an odd number, we can't have two subsets with same total
            if (sum % 2 != 0)
                return false;
            // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
            sum /= 2;

            boolean [][]lookupTable = new boolean[n][];
            for (int i = 0; i < n; i++)
                lookupTable[i] = new boolean[sum + 1];

            // populate the sum=0 columns, as we can always for '0' sum with an empty set
            for (int i = 0; i < n; i++)
                lookupTable[i][0] = true;

            // with only one number, we can form a subset only when the required sum is equal to its value
            for (int s = 1; s <= sum; s++)
                lookupTable[0][s] = (num[0] == s ? true : false);

            // process all subsets for all sums
            for (int i = 1; i < n; i++) {
                for (int s = 1; s <= sum; s++) {
                    // if we can get the sum 's' without the number at index 'i'
                    if (lookupTable[i - 1][s]) {
                        lookupTable[i][s] = lookupTable[i - 1][s];
                    } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
                        lookupTable[i][s] = lookupTable[i - 1][s - num[i]];
                    }
                }
            }
            // the bottom-right corner will have our answer.
            return lookupTable[n - 1][sum];
        }



}
