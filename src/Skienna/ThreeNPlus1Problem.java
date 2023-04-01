package Skienna;

import java.util.Arrays;
import java.util.Collections;

public class ThreeNPlus1Problem {
    public static int ThreeNPlus1SubProblem(int num){
        int count =0;
        while(num!=1 && num>1){
            if(num%2==0){
                num = num/2;
                count++;
            }else{
                num = 3*num +1;
                count++;
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        System.out.println("1 " + "10 " +threeNPlus1ProblemMethod(1,10));
        System.out.println("100 " + "200 " +threeNPlus1ProblemMethod(100,200));
        System.out.println("201 " + "210 " +threeNPlus1ProblemMethod(201,210));
        System.out.println("900 " + "1000 " +threeNPlus1ProblemMethod(900,1000));
    }

    private static int threeNPlus1ProblemMethod(int i, int i1) {
        Integer [] cycleLengths = new Integer[i1-i];

        for(int count=0;count<cycleLengths.length;count++){
            cycleLengths[count] = ThreeNPlus1SubProblem(i+count);
        }

        return Collections.max(Arrays.asList(cycleLengths));
    }
}
