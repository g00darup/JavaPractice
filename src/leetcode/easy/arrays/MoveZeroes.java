package leetcode.easy.arrays;

import java.util.Arrays;

public class MoveZeroes {

    static int[] moveZeroes(int[] nums){
            int len = nums.length;
            int end = len-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0 && i<end){
                    nums = shiftBy1(nums,i,end);
                    nums[end] = 0;
                    end--;
                }

            }
            return nums;
    }

    private static int[] shiftBy1(int[] a,int src, int end) {
        for(int i=src;i<end;i++){
            a[i]=a[i+1];
        }
        return a;
    }

    public static void main(String[] args) {
        int [] nums = {0};
        int [] res = moveZeroes(nums);
        Arrays.stream(res).forEach(System.out::println);
    }
}
