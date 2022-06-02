package GrokkingCodingInterview.dynamicprogpatrn.Knasack;

import java.util.*;
//Not getting desired o/p, need to re-look
public class BruteForce {
    int solve(int[] weight, int[] value, int capacity){
        return solveHelper(weight, value, capacity);
    }

    int solveHelper(int[] weight, int[] value, int cap){
        int max=0;
        int weightCount=0;
        int[] maximus = null;
        Set<List<Integer>> s = new HashSet<>();

        for(int i =0;i<weight.length;i++){
            List<Integer> l = findCombines(i,weight,cap);
            if(l!=null)
                s.add(l);
        }

        if(s!=null){
            maximus = new int[s.size()];
            maximus = generateSums(s,value);
        }

        if (maximus!=null)
            max = maximus[0];

        while(weightCount<maximus.length){
            if(maximus[weightCount]>max)
                max=maximus[weightCount];
        }


        return  max;
    }

    private int[] generateSums(Set<List<Integer>> s, int[] value) {
        int [] maximus = new int[s.size()];
        Iterator iter = s.iterator();
        int c=0;
        while(iter.hasNext()){
            List l = (List)iter.next();
            for(int i=0;i<l.size();i++){
                maximus[c]+= value[((Integer)l.get(i)).intValue()];
                c++;
            }
        }
        return maximus;
    }

    private List<Integer> findCombines(int weightTracker, int[] weight, int cap) {
        List<Integer> localCount=null;
        int count=weightTracker;
        if(weight[weightTracker]<cap){
            localCount = new ArrayList<>();
            localCount.add(weightTracker);
            weightTracker=weight[weightTracker];
            count++;
        }

        for(int k=count;k<weight.length;k++){
            if(weightTracker<cap){
                weightTracker+=weight[k];
                localCount.add(k);
            }
        }
        return localCount;
    }

    public static void main(String[] args) {
    new BruteForce().run();
    }

    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
//        int[] array_a_1 = { 2, 3, 1, 4 };
//        int[] array_b_1 = { 4, 5, 3, 7 };
//        int expected_1 = 10;
//        int output_1 = solve(array_a_1, array_b_1,5);
//        check(expected_1, output_1);
//
//        int[] array_a_2 = { 2, 3, 1, 4 };
//        int[] array_b_2 = { 4, 5, 3, 7 };
//        int expected_2 = 10;
//        int output_2 = solve(array_a_2, array_b_2,5);
//        check(expected_2, output_2);
        // Add your own test cases here

        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int expected_3 = 22;

        int output_3 = solve(weights, profits,7);
        check(expected_3, output_3);

        int expected_4 = 17;

        int output_4 = solve(weights, profits,6);
        check(expected_4, output_4);
    }
}
