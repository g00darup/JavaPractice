package leetcode.easy.arrays;

import java.util.Arrays;

public class MoveZeroes {

    int[] moveZeroes(int[] a){
            int len = a.length;
            int zeroPtr=-1;
            int nonZeroPtr=len-1;

    for(int j=0;j<len-1;j++) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                zeroPtr = i;
                break;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0 && i > zeroPtr) {
                nonZeroPtr = i;
                if(zeroPtr >=0) {
                    jump(a, zeroPtr, nonZeroPtr);
                    break;
                }
            }
        }
    }
            return a;
    }



    private int[] jump(int[] a,int zeroPointer, int nonZeroPointer){
        a[zeroPointer] = a[nonZeroPointer];
        a[nonZeroPointer] = 0;
        return a;
    }
    int[] moveZeroes0(int[] nums){
        int len = nums.length;
        int zeroPtr=0;
        int nonZeroPtr=len-1;
            int end = len-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0 && i<end){
                    nums = shiftBy1(nums,i,end);
                    nums[end] = 0;
                    end--;
                }
            }
          end=(len-1);
          for(int i=(len-1);i>1;i--){
            if( nums[i]!=0 && nums[i-1]==0){
                nums = shiftBy1(nums,i-1,end);
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
        int [] nums  = {2,1};
        //nums= new int[]{0,0,1};
        MoveZeroes m = new MoveZeroes();
        int [] res = m.moveZeroes(nums);
        Arrays.stream(res).forEach(System.out::println);
    }
}
