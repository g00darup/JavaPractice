package leetcode.easy.arrays;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer > map = new HashMap<>();
        int l=0,r= nums.length-1;
        int left=0,right=0;
        int res[] = new int[2];

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        if(map.containsKey(target/2)){
            res[0] = map.get(target/2);
            for(int i=0;i<nums.length;i++) {
                if (i!= map.get(target / 2) && nums[i] == target / 2) {
                    res[1] = i;
                    Arrays.sort(res);
                    return res;
                }
            }
        }

        Arrays.sort(nums);


        while (l<r){
            int cur = nums[l] + nums[r];
            if(cur<target) {
                l++;
            }else if(cur>target){
                r--;
            }else{
                left = nums[l];
                right = nums[r];
                break;
            }

        }
        if(map.containsKey(left))
            res[0] = map.get(left);
        if(map.containsKey(right))
            res[1] = map.get(right);
        Arrays.sort(res);
        return res;
    }

    public int[] twoSum2(int[] nums, int target){


        int l=0,r= nums.length-1;
        int bl,br;
        bl=l;
        br=r;
        int left=0,right=0;
        int res[] = new int[2];

        while (l<r){
            int cur = nums[l] + nums[r];
            if(cur<target) {
                l++;
            }else if(cur>target){
                r--;
            }else{
                res[0] = l;
                res[1] = r;
                break;
            }

        }




        return res;

    }


    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {3,2,3};
        int target = 6;
        int res[] = ts.twoSum(nums, target);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
