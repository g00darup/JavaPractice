package leetcode.easy.other;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwoSum {

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        while (count < nums.length) {
                map.put(nums[count], count);
            count++;
        }
        final int[] rest = {0,0};
        count = 0;

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            if(map.containsKey((target-nums[count])) &&
                    count!=map.get((target-nums[count]))){
                rest[1] = map.get((target-nums[count]));
                rest[0] = count;
                break;
            }
            iterator.next();
            count++;
        }
        return rest;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> intMap = new HashMap<>();
        boolean searchMore = false;
        int[] res = {-1,-1};
        int [] tarr = new int[nums.length];
        int count = 0;

        while (count < nums.length) {
            intMap.put(nums[count], count);
            count++;
        }
        for(int i=0;i<nums.length;i++){
            tarr[i] = target-nums[i];
        }

        res = extracted(intMap,tarr,res,-1);

        if(res[1]==-1) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }

        if(nums[res[1]]==(target/2))
            extracted(intMap,tarr,res,res[1]);

        int val = target-nums[res[1]];

        for(int k=0;k<tarr.length;k++){
            if(intMap.containsKey(val)) {
                res[0] = intMap.get(val);
                break;
            }
        }
        return res;
    }

    private int []  extracted(Map<Integer, Integer> intMap, int[] res, int[] tarr,int skip) {
        for(int j = 0; j< tarr.length; j++){
            if(skip==-1 && intMap.containsKey(tarr[j])) {
                res[1] = intMap.get(tarr[j]);
                break;
            }else if(j!=skip  && intMap.containsKey(tarr[j])){
                res[1] = intMap.get(tarr[j]);
                break;
            }
        }
        return res;
    }

    public void run() {
        int[] array_a_1 = {2,7,11,15};
        int target = 9;
        int [] expected_1 = {0,1};
        int [] output_1 = twoSum(array_a_1, target);
        check(expected_1, output_1);

        int[] array_a_2 = {3,2,4};
        int target2 = 6;
        int [] array_b_2 = {1,2};
        boolean expected_2 = false;
        int[] output_2 = twoSum(array_a_2, target2);
        check(array_b_2, output_2);
        // Add your own test cases here

    }
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        boolean result = (expected.equals(output));
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
    public static void main(String[] args) {

        new TwoSum().run();

//        TwoSum ts = new TwoSum();
//        int[] array_a_1 = {1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1};
//       Arrays.stream(Arrays.stream(ts.twoSum(array_a_1,11)).toArray()).forEach(System.out::println);
    }
}
