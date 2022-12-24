package TwoWeekDSLC.day1;
/*
217. Contains Duplicate
Easy
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
    1 <= nums.length <= 105
    -109 <= nums[i] <= 109
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class ContainsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {
        boolean res = false;
        for(int i=0;i<nums.length;i++){
            int [] a = Arrays.copyOfRange(nums,0,i);
            int [] b = Arrays.copyOfRange(nums,i+1,nums.length);
            int a1 = a.length;

            // determines length of secondArray
            int b1 = b.length;

            // resultant array size
            int c1 = a1 + b1;

            // create the resultant array
            int[] c = new int[c1];

            // using the pre-defined function arraycopy
            System.arraycopy(a, 0, c, 0, a1);
            System.arraycopy(b, 0, c, a1, b1);

            res = search(nums[i],c);

            if(res)
                break;
        }

    return  res;
    }

    public boolean search(int key,int[] nums){
        boolean res=false;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==key){
                res = true;
                break;
            }
        }
        return res;
    }

    int test_case_number = 1;
    void check(boolean expected, boolean output) {
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
        int[] array_a_1 = {1, 2, 3, 4, 1};
        boolean expected_1 = true;
        boolean output_1 = containsDuplicate(array_a_1);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        boolean expected_2 = false;
        boolean output_2 = containsDuplicate(array_a_2);
        check(expected_2, output_2);
        // Add your own test cases here
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean expected_3 = true;
        boolean output_3 = containsDuplicate(nums);

        check(expected_3,output_3);

    }

    public static void main(String[] args){new ContainsDuplicateSolution().run();}
}
