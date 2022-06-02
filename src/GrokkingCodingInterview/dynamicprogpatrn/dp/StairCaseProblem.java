package GrokkingCodingInterview.dynamicprogpatrn.dp;
/*
Problem statement #
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a function to count the number of possible ways that the child can run up the stairs.

Input #
An integer that represents the number of stairs

Output #
An integer that represents the number of ways that those stairs can be climbed

Sample input #
int n = 4;
Sample output #
int n = 7;

 */

public class StairCaseProblem
{
    public static int countWaysRec(int n, int[] lookupTable)
    {
        if (n < 0) // negative staircases i.e., invalid input
            return 0;
        else if (n == 0) // if 0 staircases
            return 1;
        else if (lookupTable[n] > -1) // if already present in the array
            return lookupTable[n];
        else
            //storing values in lookupTable
            lookupTable[n] = countWaysRec(n - 1, lookupTable)+ countWaysRec(n - 2, lookupTable)+countWaysRec(n - 3, lookupTable);
        return lookupTable[n];
    }

    public static int countWays(int n)
    {
        int []lookupTable = new int[n + 1];
        for(int i = 0;i < n+1; i++)
            lookupTable[i] = -1;
        return countWaysRec(n, lookupTable);
    }

    public static void main(String args[])
    {
        System.out.println(countWays(3));
    }

    public static int countWays2(int n)
    {
        int[] lookupTable = new int[n+1]; // Initialize lookup table
        lookupTable[0] = 1; // Setting the first three values
        lookupTable[1] = 1;
        lookupTable[2] = 2;

        for (int i = 3; i <= n; i++)
            lookupTable[i] = lookupTable[i-1] + lookupTable[i-2] + lookupTable[i-3]; // Fill up the table by summing up previous two values

        return lookupTable[n];
    }

    public static int countWays3(int n) {
        if (n < 0)
            return 0;
        if (n <= 2)
            return 1;
        int thirdLast = 1; //ways to reach third last stair
        int secondLast = 1; //ways to reach second last stair
        int last = 2; //ways to reach last stair
        int current = 0; //ways to reach current stair
        for (int i = 3; i <= n; i++) {
            current = last + secondLast + thirdLast; //summing ways to reach previous three stairs
            thirdLast = secondLast;
            secondLast = last;
            last = current;
        }
        return current;
    }

}
