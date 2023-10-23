package leetcode.easy.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDups {
        public int removeDuplicates(int[] nums) {
            int [] copyNums = new int[nums.length];
            int ops = 0;
            if(nums.length==1)
                return 1;
            if(nums.length>1) {
                copyNums[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i-1] == nums[i] && i < (nums.length-1)) {
                        copyNums[i] = nums[i+1];
                        ops++;
                    }else{
                        copyNums[i] = nums[i];
                    }
                }
            }
            nums = copyNums;
            return nums.length-ops;
        }

    public static void main(String[] args) {
        int [] nums = {1,1,2};

        RemoveDups rd = new RemoveDups();
        System.out.println(rd.removeDuplicates(nums));

    }
}
