package TwoWeekDSLC;

import TwoWeekDSLC.day1.ContainsDuplicateSolution;

import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.


Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> src = new HashMap<>();
        for(int num:nums){
            src.put(num,num);
        }
        HashMap<Integer,Integer> dest = new HashMap<>();
        for(int num:nums){
            dest.put(num,(src.get(num)-target));
        }
        //src.keySet().stream().map(in -> if(dest.get(in)));
        return nums;
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

    public void run() {
        int[] array_a_1 = {1, 2, 3, 4, 1};
        int [] expected_1 = {};
        int[] output_1 = twoSum(array_a_1,7);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int [] expected_2 = {};
        int[]  output_2 = twoSum(array_a_2,7);
        check(expected_2, output_2);
        // Add your own test cases here
        int[] array_a_3 = {1,1,1,3,3,4,3,2,4,2};
        int[]  expected_3 = {};
        int[]  output_3 = twoSum(array_a_3,7);

        check(expected_3,output_3);

    }

    public static void main(String[] args){new TwoSum().run();}
}
