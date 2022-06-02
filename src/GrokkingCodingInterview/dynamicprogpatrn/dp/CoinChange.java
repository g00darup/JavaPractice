package GrokkingCodingInterview.dynamicprogpatrn.dp;
/*
Problem statement #
Given an infinite number of quartersquarters (25 cents), dimesdimes (10 cents), nickelsnickels (5 cents), and penniespennies (1 cent), write code to calculate the number of ways to represent n centscents.

Input #
The inputs are the values of the coins available to represent the cents with (the denominations) and the number of cents

Output #
The output is the number of ways that the given number of cents can be represented

Sample input #
int amount = 10;
int denoms = [25,10,5,1]
 */

public class CoinChange {
    public static int countChangeRec(int denoms[], int denomsLength, int amount, int[][] lookupTable) {
        if (amount == 0)
            return 1;
        if (amount < 0 || denomsLength == 0)
            return 0;
        if (lookupTable[denomsLength - 1][amount] != 0)
            return lookupTable[denomsLength - 1][amount];

        lookupTable[denomsLength - 1][amount] = countChangeRec(denoms, denomsLength - 1, amount, lookupTable) + countChangeRec(denoms, denomsLength, amount - denoms[denomsLength - 1], lookupTable);
        return lookupTable[denomsLength - 1][amount];
    }

    public static int countChange(int denoms[], int denomsLength, int amount) {
        int[][] lookupTable;
        lookupTable = new int[denomsLength][];
        for (int i = 0; i < denomsLength; i++) {
            lookupTable[i] = new int[amount + 1];
            for (int j = 0; j < amount + 1; j++) {
                lookupTable[i][j] = 0;
            }
        }
        return countChangeRec(denoms, denomsLength, amount, lookupTable);
    }
    // Driver program to test the functions
    public static void main(String args[]) {
        // Denominations: quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent)
        int[] denoms = {
                25,
                10,
                5,
                1
        };
        System.out.println(countChange(denoms, 4, 10));
    }

        public static int countChange2(int denoms[], int denomsLength, int amount) {
            // Edge cases
            if (amount <= 0 || denomsLength <= 0)
                return 0;

            int i, j, x, y;

            // We need n+1 rows as the table is constructed in bottom up manner using the base case 0
            // value case (n = 0)
            int[][] lookupTable = new int[amount + 1][denomsLength];

            // Fill the enteries for 0
            // value case (n = 0)
            for (i = 0; i < denomsLength; i++)
                lookupTable[0][i] = 1;

            // Fill rest of the table entries
            // in bottom up manner
            for (i = 1; i < amount + 1; i++) {
                for (j = 0; j < denomsLength; j++) {
                    // Count of solutions including denoms[j]
                    x = (i - denoms[j] >= 0) ? lookupTable[i - denoms[j]][j] : 0;

                    // Count of solutions excluding denoms[j]
                    y = (j >= 1) ? lookupTable[i][j - 1] : 0;

                    // total count
                    lookupTable[i][j] = x + y;
                }
            }
            return lookupTable[amount][denomsLength - 1];
        }

    //optimized tabularized version
        public static int countChange3(int denoms[], int amount) {
            int denomsLength = denoms.length;
            if (denomsLength <= 0 || amount <= 0)
                return 0;

            // lookupTable[i] will be storing the number of solutions for
            // the value i. We need amount+1 rows as the table is constructed
            // in a bottom up manner using the base case (n = 0)
            int[] lookupTable = new int[amount + 1];

            // Initialize all table values to 0
            for (int i = 0; i < amount + 1; i++) {
                lookupTable[i] = 0;
            }

            // Base case (If the given value is 0)
            lookupTable[0] = 1;

            // Pick all coins one by one and update the lookupTable[] values
            // after the index greater than or equal to the value of the
            // picked coin
            for (int i = 0; i < denomsLength; i++)
                for (int j = denoms[i]; j <= amount; j++)
                    lookupTable[j] += lookupTable[j - denoms[i]];

            return lookupTable[amount];
        }

        // Driver Code

}