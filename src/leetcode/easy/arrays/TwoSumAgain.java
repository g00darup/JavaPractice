package leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSumAgain {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null)
            return new int[]{0,0};
        if(nums!=null && nums.length<=1)
            return new int[]{0,0};

        HashMap<Integer, Integer> m = new HashMap();

        for(int i = 0; i< nums.length ; i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i], m.get(nums[i])+1);
            }else{
                m.put(nums[i], 1);
            }
        }

        int[] targetList = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            targetList[i] = Math.abs(target-nums[i]);
//            System.out.println(targetList[i]);
        }

        boolean keepTargetListSearch=false;
        int targetListIndex = -99;
        for(int i = 0; i< nums.length ; i++){
            if(m.containsKey(targetList[i]) && targetList[i]!=nums[i]){
                targetListIndex = i;
                keepTargetListSearch=true;
                System.out.println(targetList[i]);
                break;
            }
        }
        if(keepTargetListSearch) {
            int toSearchInNums = -4096;
            if(targetListIndex!=-99)
                toSearchInNums = Math.abs(target-targetList[targetListIndex]);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==toSearchInNums) {
                    res[0] = i;
                System.out.println(res[0]);
                System.out.println(nums[i]);
                    break;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (i!=res[0] && nums[i]==targetList[targetListIndex]) {
                    res[1] = i;
                System.out.println(res[1]);
                System.out.println(i);
                System.out.println(nums[i]);

                    break;
                }
            }
        }

//        List keys = new ArrayList(m.keySet());
//        int index1 = keys.indexOf(res[1]);
//        res[0] = index1;

        return res;

    }

    public static void main(String[] args) {
        int [] nums = {3,2,4};
        int res[] = twoSum(nums,6);

        System.out.println(res[0]+""+res[1]);
    }
}
