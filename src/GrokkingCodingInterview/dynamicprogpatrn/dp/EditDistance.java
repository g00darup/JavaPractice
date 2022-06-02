package GrokkingCodingInterview.dynamicprogpatrn.dp;

/*
🗺️ What is edit distance?

Edit distance is a metric to quantify how dissimilar two strings are to one another by counting the minimum number of operations required to transform one string into the other.

Edit distances find several applications in the real world.

For example:

It is used to figure out which word is misspelled in automatic spelling correction.
In bioinformatics, it’s used to quantify the similarity between two DNA sequences.
The Levenshtein distance operations are the most famous operations we will be following for this example. These are the String operations; each one of them has the same cost.

Insertion
Deletion
Substitution
Problem statement #
You are given two strings; write code to calculate how many minimum Levenshtein distance operations are required to convert one String to another.

Input #
The input is two words in the form of strings.

Output #
The output is an integer of the minimum edit distance

Sample input #
  string str1 = "Tuesday";
  string str2 = "Thursday";
Sample output #
2

Do you know why output = 2?

First character “T” and last four characters “sday” are same. We basically need to convert “ue” to “hur”. This can be done using 2 operations i-e; Add h after T, Add r after u.

The first character “T” and the last four characters “sday” are the same. We basically need to convert “ue” to “hur”. This can be done using two operations, i.e, add h after T, Add r after u.
 */


public class EditDistance
{
    // Function to find minimum of three integers
    public static int min(int a,int b,int c)
    {
        if (a <= b && a <= c) return a;
        if (b <= a && b <= c) return b;
        else return c;
    }

    public static int minEditDistRec(String str1, String str2, int m, int n, int [][] lookupTable)
    {
        if (m == 0)
            return n;

        if (n == 0)
            return m;

        // if the recursive call has been called previously, then return the stored value that was calculated previously
        if (lookupTable[m - 1][n - 1] != -1)
            return lookupTable[m - 1][n - 1];

        // In case last characters are same, ignore the last char and count for the remaining string

        // Store the returned value at lookupTable[m-1][n-1]

        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return lookupTable[m - 1][n - 1] = minEditDistRec(str1, str2, m - 1, n - 1, lookupTable);

        // If last characters are not same, consider all three
        // operations on last character of first String, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.

        // Store the returned value at lookupTable[m-1][n-1]

        return lookupTable[m - 1][n - 1] = 1 + min(minEditDistRec(str1, str2, m, n - 1, lookupTable),  // Insertion
                minEditDistRec(str1, str2, m - 1, n, lookupTable),          // Deletion
                minEditDistRec(str1, str2, m - 1, n - 1, lookupTable)       // Substitution
        );
    }

    public static int minEditDistance(String str1, String str2, int m, int n)
    {
        int [][]lookupTable = new int [m][];

        for (int i = 0; i < m; i++)
        {
            lookupTable[i] = new int[n];
            for (int j = 0; j < n; j++)
                lookupTable[i][j] = -1;
        }
        return minEditDistRec(str1, str2, m, n, lookupTable);
    }


    public static void main(String args[])
    {
        String str1 = "Tuesday";
        String str2 = "Thursday";

        String str3 = "iLoveEducative";
        String str4 = "EducativeIsFun";

        String str5 = "ImLearningAlgorithmsTheseDays";
        String str6 = "ImLearningSwimmingTheseDays";

        System.out.println("Edit Distance of " + str1 + ", " + str2 + " = " + minEditDistance(str1, str2, str1.length(), str2.length()));
        System.out.println("Edit Distance of " + str3 + ", " + str4 + " = " + minEditDistance(str3, str4, str3.length(), str4.length()));
        System.out.println("Edit Distance of " + str5 + ", " + str6 + " = " + minEditDistance(str5, str6, str5.length(), str6.length()));
    }


        public static int min2(int a,int b,int c) // Helper function to find minimum of 3 integers
        {
            if (a <= b && a <= c) return a;
            if (b <= a && b <= c) return b;
            else return c;
        }

        public static int minEditDistance(String str1, String str2)
        {
            int m = str1.length(), n = str2.length();
            // Create a table to store results of subproblems
            int lookupTable[][] = new int[m+1][n+1];

            for (int i=0; i<=m; i++)
            {
                for (int j=0; j<=n; j++)
                {
                    if (i==0)                  // In case the first string is empty, insert all characters of the second string into first to make them similar
                        lookupTable[i][j] = j;  // min num of operations = j

                    else if (j==0)             //  In case second string is empty, remove all the characters of the first string to make it similar to second string
                        lookupTable[i][j] = i; // min num of operations = i

                    else if (str1.charAt(i-1) == str2.charAt(j-1))     // In case last characters are same
                        lookupTable[i][j] = lookupTable[i-1][j-1];

                    else                        // In case the last character is different, consider all possibilities and compute minimum
                        lookupTable[i][j] = 1 + min2(lookupTable[i][j-1],    // Insertion
                                lookupTable[i-1][j],             // Deletion
                                lookupTable[i-1][j-1]);          // Substitution
                }
            }
            return lookupTable[m][n];
        }


}