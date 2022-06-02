package leetcode.easy;
/*
Given a non-empty array of decimal digits representing a non-negative integer,
increment one to the integer.
The digits are stored such that the most significant digit is at the head of the list,
and each element in the array contains a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.
Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]

Input
[9]

Expected
[1,0]
*/

public class Digits {
    public static void main(String[] args) {
        int[] in = {1,2,3};
        int count=0;
        int [] res = plusOne(in);
        while(count<in.length){
            System.out.println(res[count]);
            count++;
        }

    }
    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int res [] =null;
        int plusOne = 1;
        if(digits==null)
            return digits;

        int length = digits.length;

        if((digits[length -1]+plusOne)>=10) {
            carry=1;
        }

        if(length==1 && digits[0]==9){
            res = new int[2];
            res[0]=1;
            res[1]=0;
        }

//        if(carry>0)
//            res = new int[2];
        int count = length -1;
        if(carry>0){
            res = new int[length];
            while(count>=0){
                    if(count== length -1)
                        res[count]=(digits[length -1]+plusOne)%10;
                    else
                        res[count]=digits[count]+carry;

                    if((digits[count]+carry)>10)
                        carry=1;
                    else
                        carry=0;

            }
        }else {
            res = digits;
            res[(length -1)] = digits[(length -1)]+plusOne;
        }


        return res;
    }

}
