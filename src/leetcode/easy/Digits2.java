package leetcode.easy;

import java.math.BigInteger;

public class Digits2
{
    public static void main(String[] args) {
        int[] in = {2,9,9};
        int count=0;
        int [] res = plusOne(in);
        while(count<res.length){
            System.out.println(res[count]);
            count++;
        }

    }
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int count = 0;
        int carry = 0;
        //digits[length-1]+=1;
        int [] newArr;
        BigInteger num = BigInteger.ZERO;

        for(count=0;count<length;count++){
            num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(digits[count]));
        }

        if(String.valueOf(num.add(BigInteger.ONE)).length()>String.valueOf(num).length()){
            newArr = new int[length+1];
            count=length;
            while(count>0){
                if(count==length){
                    int init = digits[count - 1] + 1;
                    newArr[count] = init % 10;
                    if(init>=10){
                        carry=1;
                    }else {
                        carry=0;
                    }
                }
                else{
                    int subs = digits[count - 1] + carry;
                    newArr[count] = subs % 10;
                    if(subs>=10){
                        carry=1;
                    }else {
                        carry=0;
                    }
                }
                count--;
            }

            newArr[count] = carry;
            return newArr;
        }else if(num.equals(BigInteger.ZERO)){
            digits[length-1] = digits[length-1]+1;
            return digits;
        }
        else if(String.valueOf(num.add(BigInteger.ONE)).charAt(length-1)=='0'){
            count=length-1;
            while(count>0){
                if(count==length-1){
                    int init = digits[count] + 1;
                    digits[count] = init % 10;
                    if(init >=10){
                        carry=1;
                    }else {
                        carry=0;
                    }
                }
                else{
                    int subs = digits[count] + carry;
                    digits[count] = subs % 10;
                    if(subs >=10){
                        carry=1;
                    }else {
                        carry=0;
                    }
                }
                count--;
            }
            if(carry>0){
                digits[0]=digits[0]+carry;
            }
            return digits;
        }else{
            digits[length-1] = digits[length-1]+1;
            return digits;
        }



    }
}
