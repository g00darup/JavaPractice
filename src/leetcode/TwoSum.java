package leetcode;

import java.util.Arrays;

public class TwoSum {
    public static void main(String []args){
        //System.out.println("Hello World");
        int [] nums = {3,2,4};;
        int target = 6;;

        System.out.println(twoSum(nums,target)[0]+"\n"+twoSum(nums,target)[1]);
    }

   static public int[]  twoSum(int[] nums, int target) {

        int [] res = new int[2];

        int[] tar = new int[nums.length];

        int ignoreIdx=-99;

        for(int i=0;i<nums.length;i++){

            if(nums[i]==target/2)
                ignoreIdx = i;

            tar[i] = target-nums[i];
        }

        for(int i=0;i<tar.length;i++){
            tar[i] = target-nums[i];
            if(i!=ignoreIdx && find(nums,tar[i])>=0){

                res[0] = find(nums,(target-tar[i]));
                res[1] = find(nums,tar[i]);

                return res;
            }
        }

        return res;

    }

   static int find(int[] nums, int key){

        for(int i=0;i<nums.length;i++){
            if(nums[i]==key)
                return i;
        }

        return -99;

    }

    static int find2(int[] nums, int key){
        int left = 0;
        int right = nums.length;
        

        int indx = findHelper(nums,left,right,key);

        return indx;
    }

    private static int findHelper(int[] nums, int left, int right, int key) {

        int mid = (left+right)/2;

        if(key==nums[mid]){
            return mid;
        }else if(key>nums[mid]){
            left = mid;
            return findHelper(nums,left,right,key);
        }else if(key<nums[mid]){
            right = mid;
            return findHelper(nums,left,right,key);
        }

        return 0;
    }
}
