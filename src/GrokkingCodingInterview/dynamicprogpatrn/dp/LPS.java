package GrokkingCodingInterview.dynamicprogpatrn.dp;
/*
Problem statement #
Given a string, find the length of its longest palindromic subsequence. In a palindromic subsequence, elements read the same backward and forward.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements

Input #
A string

Output #
The length of the longest palindromic subsequence

Sample input #
string s = "abdbca"
Sample output #
5
 */

public class LPS
{
    public static int LPSLengthRec(int [][] lookupTable, String st, int startIndex, int endIndex)
    {
        if(startIndex > endIndex)
            return 0;

        // every sequence with one element is a palindrome of length 1
        if(startIndex == endIndex)
            return 1;

        if(lookupTable[startIndex][endIndex] == 0) {
            // case 1: elements at the beginning and the end are the same
            if(st.charAt(startIndex) == st.charAt(endIndex)) {
                lookupTable[startIndex][endIndex] = 2 + LPSLengthRec(lookupTable, st, startIndex+1, endIndex-1);
            } else {
                // case 2: skip one element either from the beginning or the end
                int c1 =  LPSLengthRec(lookupTable, st, startIndex+1, endIndex);
                int c2 =  LPSLengthRec(lookupTable, st, startIndex, endIndex-1);
                lookupTable[startIndex][endIndex] = Math.max(c1, c2);
            }
        }
        return lookupTable[startIndex][endIndex];
    }
    public static int LPSLength(String st)
    {
        // Initializing a lookup table of dimensions st.length() x st.length()
        int [][] lookupTable;
        lookupTable = new int [st.length()][];
        for (int i = 0; i < st.length(); i++) {
            lookupTable[i] = new int[st.length()];
            for (int j = 0; j < st.length(); j++)
                lookupTable[i][j] = 0;
        }
        return LPSLengthRec(lookupTable, st, 0, st.length()-1);
    }
    public static void main(String args[])
    {
        System.out.println(LPSLength("cddpd"));
        System.out.println(LPSLength("abdbca"));
        System.out.println(LPSLength("cddpd"));
        System.out.println(LPSLength("pqr"));
    }


        public static int LPSLength2(String st)
        {
            int size = st.length();
            // Initializing a lookup table of dimensions size * size
            int [][] lookupTable;
            lookupTable = new int [size][];
            for (int i = 0; i < size; i++) {
                lookupTable[i] = new int[size];
                for (int j = 0; j < size; j++)
                    lookupTable[i][j] = 0;
            }
            // every sequence with one element is a palindrome of length 1
            for (int i = 0; i < size; i++)
                lookupTable[i][i] = 1;

            for (int startIndex = size - 1; startIndex >= 0; startIndex--) {
                for (int endIndex = startIndex + 1; endIndex < size; endIndex++)
                {
                    // case 1: elements at the beginning and the end are the same
                    if (st.charAt(startIndex) == st.charAt(endIndex))
                        lookupTable[startIndex][endIndex] = 2 + lookupTable[startIndex + 1][endIndex - 1];
                    else // case 2: skip one element either from the beginning or the end
                        lookupTable[startIndex][endIndex] = Math.max(lookupTable[startIndex + 1][endIndex], lookupTable[startIndex][endIndex - 1]);
                }
            }
            return lookupTable[0][size - 1];
        }

}