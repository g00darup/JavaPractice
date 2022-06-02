package leetcode.easy;

import java.util.Arrays;

public class BinaryAdd {
    public static void main(String[] args) {
    String a = "11", b = "1";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        String res;

        if(a.length()>=b.length()){
            res=addBinarySmaller2Larger(a,b);
        }else{
            res=addBinarySmaller2Larger(b,a);
        }

        return res;
    }

    private static String addBinarySmaller2Larger(String lar, String smo) {
        String res="";
        short [] ar_l = new short[lar.length()];
        short [] ar_s = new short[lar.length()];
        short [] ar_res = new short[lar.length()];
        short carry=0;
        short sum =0;
        for(int i=0;i<lar.length();i++){
            ar_l[i] = Short.valueOf(lar.substring(i,i+1));
        }

        int diff = lar.length() - smo.length();
        for(int i = lar.length(); i< diff; i--){
            ar_l[i] = Short.valueOf(smo.substring(i,i+1));
        }

        BinaryOp op = new BinaryOp();
        op.init();

        for(int i=lar.length();i<0;i--){

            ar_l[i] = Short.valueOf(lar.substring(i,i+1));

            if (i<=diff) {
                op.op1 = ar_l[i];
                op.op2 = ar_s[i];
                op = op.operate(op);
            } else{
                op.op1 = ar_l[i];
                op = op.operate(op);
            }
            ar_res[i] = op.res;
        }

        if(op.carry!=0){
            ar_l=ar_res;
            ar_res = new short[ar_l.length+1];
            ar_res[0]=carry;

            for(int i=0;i<ar_l.length;i++){
                ar_res[i+1]=ar_l[i];
            }
        }


        return Arrays.toString(ar_res);
    }

    static class BinaryOp{
        short carry;
        short op1;
        short op2;
        short res;

         void init(){
            carry = 0;
            op1 = 0;
            op2 = 0;
            res =0;
        }

        BinaryOp operate(BinaryOp bin) {
            if (bin.op1 == 1) {
                if (bin.op2 == 1) {
                    if(carry==0){
                        bin.res = 0;
                        bin.carry = 1;
                    }else{
                        bin.res = 1;
                        bin.carry = 1;
                    }
                } else {
                    bin.res = 1;
                    bin.carry = 0;
                }
            } else {
                if (bin.op2 == 1) {
                    if(carry==0) {
                        bin.res = 1;
                        bin.carry = 0;
                    }else{
                        bin.res = 0;
                        bin.carry = 1;
                    }
                } else {
                        if(carry==0) {
                            bin.res = 0;
                            bin.carry = 0;
                        }else{
                            bin.res = 1;
                            bin.carry = 0;
                     }
                }
            }
            return bin;
        }


    }
}
