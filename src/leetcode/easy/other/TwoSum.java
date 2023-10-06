package leetcode.easy.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
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

    public void run() {
        int[] array_a_1 = {-1,-2,-3,-4,-5};
        int target = 9;
        int [] expected_1 = {0,1};
        int [] output_1 = twoSum(array_a_1, target);
        check(expected_1, output_1);

//        int[] array_a_2 = {3,2,4};
//        int target2 = 9;
//        boolean expected_2 = false;
//        boolean output_2 = twoSum(array_a_2, array_b_2);
//        check(expected_2, output_2);
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

        //new TwoSum().run();

        TwoSum ts = new TwoSum();
        int[] array_a_1 = {1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1};
       Arrays.stream(Arrays.stream(ts.twoSum(array_a_1,11)).toArray()).forEach(System.out::println);
    }
}
