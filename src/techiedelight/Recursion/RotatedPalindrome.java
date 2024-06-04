/*
Given a string, check if it is a rotated palindrome or not.

Input: "CBAABCD"
Output: true
Explanation: "CBAABCD" is a rotation of the palindrome "ABCDCBA"

Input: "BAABCC"
Output: true
Explanation: "BAABCC" is a rotation of the palindrome "ABCCBA"

Input: "DCABC"
Output: false


import java.util.List;

public class RotatedPalindrome
{
//    public static boolean isRotatedPalindrome(String s)
//    {
//        // Write your code here...
//        List<String> allPossibleCombo = generateCombo(s);
//    }

//    private static List<String> generateCombo(String s) {
//    }

    public boolean isPalindrome(String s){
        if (s.length() <= 1) {
            return true;
        }
        if(s.substring(0,1).equals(s.substring(s.length()-1,s.length())))
            return isPalindrome(s.substring(1,s.length()-1));
        else
            return false;
    }
}
*/