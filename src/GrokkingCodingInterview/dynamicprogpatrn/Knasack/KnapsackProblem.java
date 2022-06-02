package GrokkingCodingInterview.dynamicprogpatrn.Knasack;

/*
Problem statement #
Imagine that you’re a burglar at a jewelry store with a knapsack.
Your goal is to choose a combination of jewelry that results in the most profit.
Let’s see how you would code this problem.

Given two integer arrays that represent the weights and profits of N items,
implement a function knapSack() that finds a subset of these items that will gives us the maximum profit without their cumulative weight exceeding a given number capacity. Each item can only be selected once, which means we either skip it or put it in the knapsack.


Input #
The input includes:

The profit that can be gained by each piece of the jewelry
The number of pieces of jewelry
The weight of each piece of jewelry
The maximum weight that the knapsack can hold
The length of the array
Output #
The maximum profit that can be returned

Sample input #
    int profit[] = {60, 100, 120};
    int profitsLength;
    int weight[] = {10, 20, 30};
    int weightsLength;
    int capacity = 50;

Sample output #
    220
 */
public class KnapsackProblem
{
    /*
    Explanation #
The function knapSack makes a lookupTable within the function that stores the maximum value that can be
attained with maximum capacity (lines 29-35). This function calls the
helper function knapsackRecursive (line 36). It returns the maximum value that can be attained using only
the first i items, i.e., items at the currentIndex while keeping their total weight no more than weights.
We have two varying values (capacity and currentIndex),
so we can use a two-dimensional array to store the results of all the solved subproblems in our
recursive function knapsackRecursive.

We need to store results for every subarray, i.e., for every possible index and for every possible capacity.
If the lookupTable[currentIndex][capacity] is already computed before (line 10),
 this value is immediately returned (line 11).

Otherwise, we call the function recursively:

with the item, saving the result in profit1(line 17).

without the item, saving the result in the variable, profit2 (line 21).

Out of the two, we return the result that is greater (as done on lines 23-24).

Time complexity #
Our memoization array lookupTable[profitsLength][capacity+1] stores the results for all the subproblems. We can conclude that we do not have more than N*CN∗C subproblems (where “N” is the number of items and “C” is the knapsack capacity). This means that our time complexity is O(N*C)O(N∗C).

Furthermore, other than the space used for the memoization lookup table, which is O(N*C)O(N∗C), we use O(N)O(N) space for the recursion call-stack. So, the total space complexity is O(N*C+N)O(N∗C+N), which is asymptotically equivalent to O(N*C)O(N∗C).
     */
    public static int knapsackRecursive(int [][] lookupTable, int profits[], int profitsLength, int weights[], int weightsLength, int capacity, int currentIndex) {

        // base checks
        if (capacity <= 0 || currentIndex >= profitsLength || currentIndex < 0 || weightsLength != profitsLength)
            return 0;

        // if we have already solved the problem, return the result from the table
        if (lookupTable[currentIndex][capacity] != 0)
            return lookupTable[currentIndex][capacity];

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength, capacity, currentIndex + 1);

        lookupTable[currentIndex][capacity] = Math.max(profit1, profit2);
        return lookupTable[currentIndex][capacity];
    }

    public static int knapSack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity)
    {
        int lookupTable[][] = new int [profitsLength][];

        for (int i = 0; i < profitsLength; i++) {
            lookupTable[i] = new int[capacity + 1];
            for (int j = 0; j < capacity + 1; j++)
                lookupTable[i][j] = 0;
        }
        return knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength, capacity, 0);
    }


    /*
    Explanation #
In the function, we populate our lookupTable list in a bottom-up fashion. Essentially, we want to find the maximum profit for every sub-list and for every possible capacity. This means lookupTable[i][w] represents the maximum knapsack profit for capacity w calculated from the first i items.

So, for each item at index i and capacity w, we have two options:

Exclude the item at index i. In this case, we take whatever profit we get from the sub-list excluding this item => lookupTable[i-1][w] (line 19).

Include the item at index i if its weight is not more than the capacity. In this case, we include its profit plus whatever profit we get from the remaining capacity and from remaining items => profit[i-1] + lookupTable[i-1][w-weight[i-1]]) (line 17).

Finally, our optimal solution will be the maximum of the above two values (line 17):

lookupTable[i][j] = max (lookupTable[i-1][w], profit[i] + lookupTable[i-1][w-weight[i]])

Time complexity #
The above solution has a time and space complexity of O(N*C)O(N∗C), where “N” represents the total items and “C” is the maximum capacity.
     */

 static int knapSack2(int profits[], int profitsLength, int weights[], int weightsLength, int capacity) {
            // Basic checks
            if (capacity <= 0 || profitsLength == 0 || weightsLength != profitsLength)
                return 0;

            int i, w;
            int[][]lookupTable = new int[profitsLength + 1][capacity + 1];

            // Building the lookup table in bottom up manner
            for (i = 0; i <= profitsLength; i++) {
                for (w = 0; w <= capacity; w++) {
                    if (i == 0 || w == 0)
                        lookupTable[i][w] = 0;
                    else if (weights[i - 1] <= w)
                        lookupTable[i][w] = Math.max(profits[i - 1] + lookupTable[i - 1][w - weights[i - 1]], lookupTable[i - 1][w]);
                    else
                        lookupTable[i][w] = lookupTable[i - 1][w];
                }
            }

            return lookupTable[profitsLength][capacity];
        }
/*
Explanation #
This space optimization solution can be implemented using a single array. The intuition is to use the same array for the previous and the next iteration!

We need two values from the previous iteration: lookupTabe[c] and lookupTable[c-weights[i]]

Since our inner loop is iterating over the capacity, let’s see how this might affect our two required values:

When we access lookupTable[c], it won’t be overwritten yet for the current iteration, so it should be fine.
lookupTable[c-weights[i]] would get overwritten if weights[i] > 0. Therefore, we can’t use this value for the current iteration.
To solve the second case, we change our inner loop to process in the reverse direction: c:capacity-->0. This ensures that whenever we change a value in lookupTable[], we do not need it anymore in the current iteration. This is similar to the Fibonacci space optimization that we looked at in the beginning of the chapter.

Time complexity #
While the time complexity remains the same, i.e., O(N*C)O(N∗C), the space complexity of this solution is brought down to O(C)O(C).
 */


   static int knapSack3(int profits[], int profitsLength, int weights[], int weightsLength, int capacity) {
            // basic checks
            if (capacity <= 0 || profitsLength == 0 || weightsLength != profitsLength)
                return 0;

            int[] lookupTable = new int[capacity + 1];

            // if we have only one weight, we will take it if it is not more than the capacity
            for (int c = 0; c <= capacity; c++) {
                if (weights[0] <= c)
                    lookupTable[c] = profits[0];
            }
            // process all sub-arrays for all the capacities
            for (int i = 1; i < profitsLength; i++) {
                for (int c = capacity; c >= 0; c--) {
                    int profit1 = 0, profit2 = 0;
                    // include the item, if it is not more than the capacity
                    if (weights[i] <= c)
                        profit1 = profits[i] + lookupTable[c - weights[i]];
                    // exclude the item
                    profit2 = lookupTable[c];
                    // take maximum
                    lookupTable[c] = Math.max(profit1, profit2);
                }
            }
            return lookupTable[capacity];
        }

        public static void main(String args[]) {
            int profits[] = {1, 6, 10, 16}; // The values of the jewelry
            int weights[] = {1, 2, 3, 5}; // The weight of each
            System.out.println("Total knapsack profit ---> " + knapSack(profits, 4, weights, 4, 7));
            System.out.println("Total knapsack profit ---> " + knapSack(profits, 4, weights, 4, 6));
        }

}


