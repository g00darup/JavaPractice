package GrokkingCodingInterview.dynamicprogpatrn.dp;
/*
Given two strings, write a function to find the length of their shortest common superstring.
A superstring is a string that has both input strings as substrings.

Input #
Two strings

Output #
The length of the strings shortest common supersequence

Sample input #
string s1 = "abcf";
string s2 = "bdcf";
Sample output #
5 // The SCS is "abdcf"
 */
public class SCS
{
    public static int findSCSLengthRecursive(int [][] lookupTable, String s1, String s2, int i1, int i2) {
        // if we have reached the end of a String, return the remaining length of the other String, as in
        // this case we have to take all of the remaing other String
        if (i1 == s1.length())
            return s2.length() - i2;
        if (i2 == s2.length())
            return s1.length() - i1;

        if (lookupTable[i1][i2] == 0) {
            //if sequences have a matching character
            if (s1.charAt(i1) == s2.charAt(i2))
                lookupTable[i1][i2] = 1 + findSCSLengthRecursive(lookupTable, s1, s2, i1 + 1, i2 + 1);
            else {
                //if matching character not found
                int length1 = 1 + findSCSLengthRecursive(lookupTable, s1, s2, i1, i2 + 1);
                int length2 = 1 + findSCSLengthRecursive(lookupTable, s1, s2, i1 + 1, i2);
                //store minimum of the two in lookupTable
                lookupTable[i1][i2] = Math.min(length1, length2);
            }
        }
        return lookupTable[i1][i2];
    }
    public static int findSCSLength(String s1, String s2) {
        int[][] lookupTable;
        lookupTable = new int [s1.length()][];
        for (int i = 0; i < s1.length(); i++) {
            lookupTable[i] = new int[s2.length()];
            for (int j = 0; j < s2.length(); j++)
                lookupTable[i][j] = 0;
        }
        return findSCSLengthRecursive(lookupTable, s1, s2, 0, 0);
    }
    public static void main(String args[])
    {
        System.out.println(findSCSLength("abcdz", "bdcf"));
        System.out.println(findSCSLength("educative", "educative.io"));
    }

    public static int findSCSLength2(String str1, String str2)
    {
        int s1 = str1.length(), s2 = str2.length();
        int [][] lookupTable = new int [s1 + 1][];
        //initializing the lookupTable
        for (int i = 0; i < s1 + 1; i++)
        {
            lookupTable[i] = new int[s2 + 1];
            for (int j = 0; j < s2 + 1; j++)
                lookupTable[i][j] = 0;
        }
        // if one of the strings is of zero length, Shortest common supersequence(SCS)
        // would be equal to the length of the other string
        for (int i = 0; i <= s1; i++)
            lookupTable[i][0] = i;
        for (int j = 0; j <= s2; j++)
            lookupTable[0][j] = j;

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                //if sequences have a matching end character
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
                else
                    //if matching end character not found
                    lookupTable[i][j] = 1 + Math.min(lookupTable[i - 1][j], lookupTable[i][j - 1]);
            }
        }
        return lookupTable[s1][s2];
    }


}