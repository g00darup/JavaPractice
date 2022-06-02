package GrokkingCodingInterview.dynamicprogpatrn.dp;
/*
Problem statement #
Given two strings, s1 and s2, write a function that finds and returns the length of the longest substring of s2 and s1 (if any exist).

Input #
Two strings

Output #
An integer

Sample input #
string1 = "www.educative.io/explore";
string2 = "educative.io/edpresso";
Sample output #
14
 */
public class LongestCommonSubstring
{
    public static int longestCommonSubstrLengthRecursive(int[][][] lookupTable, String s1, String s2, int i1, int i2, int count)
    {
        if (i1 == s1.length() || i2 == s2.length())
            return count;
        if (lookupTable[i1][i2][count] == -10) {
            int c1 = count;
            if (s1.charAt(i1) == s2.charAt(i2))
                c1 = longestCommonSubstrLengthRecursive(lookupTable, s1, s2, i1 + 1, i2 + 1, count + 1);
            int c2 = longestCommonSubstrLengthRecursive(lookupTable, s1, s2, i1, i2 + 1, 0);
            int c3 = longestCommonSubstrLengthRecursive(lookupTable, s1, s2, i1 + 1, i2, 0);
            lookupTable[i1][i2][count] = Math.max(c1, Math.max(c2, c3));
        }
        return lookupTable[i1][i2][count];
    }

    public static int longestCommonSubstrLength(String s1, String s2)
    {
        //declaring a lookup table with dimensions: lookupTable[s1.size()][s2.size()][maxLength];
        int size1 = s1.length(), size2 = s2.length();
        int maxLength = Math.max(size1, size2);
        int [][][] lookupTable = new int [size1][][];

        for (int i = 0; i < size1; i++) {
            lookupTable[i] = new int [size2][];
            for (int j = 0; j < size2 ; j++) {
                lookupTable[i][j] = new int[maxLength];
                for (int k = 0; k < maxLength; k++)
                    lookupTable[i][j][k] = -10;
            }
        }
        return longestCommonSubstrLengthRecursive(lookupTable, s1, s2, 0, 0, 0);
    }

    public static void main(String args[])
    {
        String S1 = "www.educative.io/explore";
        String S2 = "educative.io/edpresso";
        String S3 = "0abc321";
        String S4 = "123abcdef";
        System.out.println(longestCommonSubstrLength(S3, S4));
        System.out.println(longestCommonSubstrLength(S1, S2));
    }

    public static int longestCommonSubstrLength2(String s1, String s2)
    {
        //lookupTable to store the already computed subproblems solutions
        int[][] lookupTable = new int[s1.length()+1][];

        //Initializing all values in lookupTable to zero
        for(int i = 0; i <= s1.length(); i++)
            lookupTable[i] = new int[s2.length()+1];


        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                lookupTable[i][j] = 0;
            }
        }
        int maxLength = 0;
        //filling lookupTable in a bottom-up manner
        for (int i = 1; i <=s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                //if the current characters of s1 and s2 match
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
                    maxLength = Math.max(maxLength, lookupTable[i][j]);
                }
            }
        }
        return maxLength;
    }
    public static int longestCommonSubstrLength3(String s1, String s2)
    {
        int[][] lookupTable = new int[s1.length()+1][];
        for(int i = 0; i <= s1.length(); i++)
            lookupTable[i] = new int[s2.length()+1];

        // Initializing all values in lookupTable to zero
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                lookupTable[i][j] = 0;
            }
        }
        int maxLength = 0;
        for(int i=1; i <= s1.length(); i++)
        {
            for(int j=1; j <= s2.length(); j++)
            {
                lookupTable[i%2][j] = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    lookupTable[i%2][j] = 1 + lookupTable[(i-1)%2][j-1];
                    maxLength = Math.max(maxLength, lookupTable[i%2][j]);
                }
            }
        }
        return maxLength;
    }

}
