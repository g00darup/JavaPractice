package TwoWeekDSLC.day1;
/*
53. Maximum Subarray
Easy

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23


Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution,
try coding another solution using the divide and conquer approach, which is more subtle.

 */

public class MaximumSubarraySolution {
    int sumTillNow=0;
    int maxSum=0;
    public int maxSubArray(int[] nums) {
        if(nums!=null){
            if(nums.length==1)
                sumTillNow = nums[0];
            else if(nums.length>1){
                maxSum = sumTillNow;
                for(int i=0;i<nums.length;i++){
                    if(sumTillNow<0){
                        //i = i+1;
                        sumTillNow=0;
                    }else if(maxSum>=sumTillNow){
                        if(sumTillNow<0)
                            sumTillNow=0;
                    }else if(sumTillNow>=0 && sumTillNow>=maxSum){
                        maxSum = sumTillNow;
                        //sumTillNow+=nums[i];
                    }
                    sumTillNow+=nums[i];
                }

            }
        }
            if(maxSum>sumTillNow)
                return maxSum;
            else
                return sumTillNow;

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
//        int[] array_a_1 = {-2,1,-3,4,-1,2,1,-5,4};
//        int expected_1 = 6;
//        int output_1 = maxSubArray(array_a_1);
//        check(expected_1, output_1);

        int[] array_a_2 = {1};
        int expected_2 = 1;
        int output_2 = maxSubArray(array_a_2);
        check(expected_2, output_2);
        // Add your own test cases here
//        int[] nums = {5,4,-1,7,8};
//        int expected_3 = 23;
//        int output_3 = maxSubArray(nums);
//
//        check(expected_3,output_3);

    }

    public static void main(String[] args){new MaximumSubarraySolution().run();}
}
