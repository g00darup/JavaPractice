package hackerrank.IntPrepKit.java.advanced.varargs;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        int len = args.length;
        int count = 0;
        int sum = 0;
        for(String arg : args) {
            sum+=Integer.valueOf(arg);
            sb.append(arg);

            if(count>0){
                System.out.println(sb.toString()+"="+sum);
            }
            if(count!=len-1)
                sb.append("+");
            count++;
        }
    }
}
