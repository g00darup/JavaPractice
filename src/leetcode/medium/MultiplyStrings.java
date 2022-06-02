package leetcode.medium;

import java.math.BigInteger;

public class MultiplyStrings {
    public static void main(String[] args) {
//        "498828660196"
//        "840477629533"
        System.out.println(multiply("498828660196","840477629533"));
    }

    public static String multiply(String num1, String num2) {

    BigInteger sum=  BigInteger.ZERO;
    BigInteger longer= BigInteger.ZERO;
    BigInteger shorter=BigInteger.ZERO;
    String shorty;


    int count =0;
    if(num2.length()<=num1.length()){
        longer = new BigInteger(num1);
        shorter = new BigInteger(num2);
        shorty=num2;
    }else {
        longer=new BigInteger(num2);
        shorter=new BigInteger(num1);
        shorty=num1;
    }

    while(count<shorty.length()){

        BigInteger adder = getAdder(longer, shorter, count);
       sum= sum.add(adder);
       shorter=shorter.divide(BigInteger.TEN);
       count++;
    }


    return String.valueOf(sum);
    }

    private static BigInteger getAdder(BigInteger longer, BigInteger shorter, int count) {
        BigInteger mul = longer.multiply(shorter.remainder(BigInteger.TEN));
        if(count==0)
            return mul;
        int i=1;
        while(i<=count) {
            mul=mul.multiply(BigInteger.TEN);
            i++;
        }
        return mul;
    }

}
