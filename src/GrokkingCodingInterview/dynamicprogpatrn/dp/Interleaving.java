package GrokkingCodingInterview.dynamicprogpatrn.dp;
/*
Problem statement #
Give three strings m, n, and p, write a function to find out if p has been formed by interleaving m and n. ‘p’ should be considered to be an interleaved form of m and n if it contains all the letters from m and n with the order of the letters preserved.

Input #
Three strings

Output #
A boolean

Sample input #
string m= "abd";
string n= "cef";
string p= "abcdef";
 */

import java.util.HashMap;

public class Interleaving {
    public static boolean findSIRecursive(HashMap < String, Boolean > lookupTable, String m, String n, String p, int mIndex, int nIndex, int pIndex) {
        // if we have reached the end of the all the Strings
        if (mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
            return true;

        // if we have reached the end of 'p' but 'm' or 'n' still has some characters left
        if (pIndex == p.length())
            return false;

        String subProblemKey = String.valueOf(mIndex) + "-" + String.valueOf(nIndex) + "-" + String.valueOf(pIndex);
        if (lookupTable.containsKey(subProblemKey) == false) {
            boolean b1 = false, b2 = false;
            if (mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
                b1 = findSIRecursive(lookupTable, m, n, p, mIndex + 1, nIndex, pIndex + 1);

            if (nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
                b2 = findSIRecursive(lookupTable, m, n, p, mIndex, nIndex + 1, pIndex + 1);

            lookupTable.put(subProblemKey, b1 || b2);
        }
        boolean x = false;
        if (lookupTable.containsKey(subProblemKey))
            x = lookupTable.get(subProblemKey);
        return x;
    }

    public static Object findSI(String m, String n, String p) {
        HashMap < String, Boolean > lookupTable = new HashMap< String, Boolean >();
        return findSIRecursive(lookupTable, m, n, p, 0, 0, 0);
    }

    public static void main(String args[]) {
        System.out.println(findSI("abd", "cef", "adcbef"));
        System.out.println(findSI("abc", "def", "abdccf"));
        System.out.println(findSI("abcdef", "mnop", "mnaobcdepf"));
    }

        public static Object findSI2(String m, String n, String p) {
            boolean[][] lookupTable = new boolean[m.length() + 1][];

            for (int i = 0; i < m.length() + 1; i++)
                lookupTable[i] = new boolean[n.length() + 1];


            // for the empty pattern, we have one matching
            if (m.length() + n.length() != p.length())
                return false;

            for (int mIndex = 0; mIndex <= m.length(); mIndex++) {
                for (int nIndex = 0; nIndex <= n.length(); nIndex++) {
                    // if 'm' and 'n' are empty, then 'p' must have been empty too.
                    if (mIndex == 0 && nIndex == 0)
                        lookupTable[mIndex][nIndex] = true;

                        // if 'm' is empty, we need to check the interleaving with 'n' only
                    else if (mIndex == 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))
                        lookupTable[mIndex][nIndex] = lookupTable[mIndex][nIndex - 1];

                        // if 'n' is empty, we need to check the interleaving with 'm' only
                    else if (nIndex == 0 && m.charAt(mIndex - 1) == p.charAt(mIndex + nIndex - 1))
                        lookupTable[mIndex][nIndex] = lookupTable[mIndex - 1][nIndex];

                    else {
                        // if the letter of 'm' and 'p' match, we take whatever is matched till mIndex-1
                        if (mIndex > 0 && m.charAt(mIndex - 1) == p.charAt(mIndex + nIndex - 1))
                            lookupTable[mIndex][nIndex] = lookupTable[mIndex - 1][nIndex];

                        // if the letter of 'n' and 'p' match, we take whatever is matched till nIndex-1 too
                        // note the '|=', this is required when we have common letters
                        if (nIndex > 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))
                            lookupTable[mIndex][nIndex] |= lookupTable[mIndex][nIndex - 1];
                    }
                }
            }
            return lookupTable[m.length()][n.length()];
        }


}
