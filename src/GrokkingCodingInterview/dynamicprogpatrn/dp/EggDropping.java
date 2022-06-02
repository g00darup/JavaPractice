package GrokkingCodingInterview.dynamicprogpatrn.dp;
/*
Problem statement #
Given a tall skyscraper and a few eggs, write a function to figure out how many tries it would take to figure out which floor of the skyscraper the eggs can be dropped from without breaking. Here are some rules:

An egg that survives a fall can be used again but a broken egg must be discarded.
The effect of a fall is the same for all eggs.
If an egg breaks when dropped from a certain floor, it would also break if dropped from a higher floor.
If an egg survives a fall from a certain floor, it would also survive a shorter fall.
Input #
The inputs are two integers that represent the number of stories of the skyscraper and number of eggs respectively

Output #
The output is the least number of egg-droppings to figure out the critical floor

Sample input #

 */

public class EggDropping
{
    public static int eggDropRec(int eggs, int floors, int [][] lookupTable)
    {
        // If there are no eggs, then there can't be any tries
        if (eggs <= 0)
            return 0;

        // If there are no floors, then no trials needed. OR if there is
        // one floor, one trial needed.
        if (floors == 1 || floors == 0)
            return floors;

        // We need k trials for one egg and k floors
        if (eggs == 1)
            return floors;

        lookupTable[eggs][floors] = Integer.MAX_VALUE;
        int x, res;

        // Consider all droppings from 1st floor to kth floor and
        // return the minimum of these values plus 1.
        for (x = 1; x <= floors; x++)
        {
            res = 1 + Math.max(eggDropRec(eggs - 1, x - 1, lookupTable), eggDropRec(eggs, floors - x, lookupTable));
            if (res < lookupTable[eggs][floors])
                lookupTable[eggs][floors] = res;
        }
        return lookupTable[eggs][floors];
    }

    public static int eggDrop(int eggs, int floors)
    {
        int [][] lookupTable;
        lookupTable = new int[eggs + 1][];
        for (int i = 0; i < eggs + 1; i++) {
            lookupTable[i] = new int[floors + 1];
            for (int j = 0; j < floors + 1; j++)
                lookupTable[i][j] = 0;
        }
        return eggDropRec(eggs, floors, lookupTable);
    }

    public static void main(String args[])
    {
        int eggs = 2, floors = 10;
        System.out.println("With " + eggs + " eggs and " + floors + " floors, the minimum number of trials in worst case are: " + eggDrop(eggs, floors));
    }

    public static int eggDrop2(int eggs, int floors)
    {
        // If there are no eggs, then there can't be any tries
        if (eggs <= 0)
            return 0;

        // If there are no floors, then no trials needed. OR if there is
        // one floor, one trial needed.
        if (floors == 1 || floors == 0)
            return floors;

        // We need k trials for one egg and k floors
        if (eggs == 1)
            return floors;

        //A 2D table where entery eggFloor[i][j] will represent minimum
        //number of trials needed for i eggs and j floors.
        int [][] eggFloor = new int[eggs + 1][floors + 1];
        int res;
        int i, j, x;

        // We need one trial for one floor and zero trials for zero floors
        for (i = 1; i <= eggs; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        // We always need j trials for one egg and j floors.
        for (j = 1; j <= floors; j++)
            eggFloor[1][j] = j;

        // Fill rest of the entries in table using optimal substructure
        // property
        for (i = 2; i <= eggs; i++) {
            for (j = 2; j <= floors; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }
        // eggFloor[n][k] holds the result
        return eggFloor[eggs][floors];
    }

    public static int binomialCoeff(int x, int n, int k) {
        int sum = 0, term = 1;
        for (int i = 1; i <= n && sum < k; ++i) {
            term *= x - i + 1;
            term /= i;
            sum += term;
        }
        return sum;
    }
    // Do binary search to find minimum number of trials in worst case.
    public static int eggDrop3(int eggs, int floors) {
        // If there are no eggs, then there can't be any tries
        if (eggs <= 0)
            return 0;

        // If there are no floors, then no trials needed. OR if there is one floor, one trial needed.
        if (floors == 1 || floors == 0)
            return floors;

        // We need k trials for one egg and k floors
        if (eggs == 1)
            return floors;

        // Initialize low and high as 1st and last floors
        int low = 1, high = floors;

        // Do binary search, for every mid, find sum of binomial coefficients and check if the sum is greater than k or not.
        while (low < high) {
            int mid = (low + high) / 2;
            if (binomialCoeff(mid, eggs, floors) < floors)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

}
