package leetcode.easy.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductExSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int prod[] = new int [len];
        int leftMul=1,rightMul=1;
        for(int i=0; i<len;i++) {
                if(prod[i]!=0)
                    prod[i] = prod[i]*leftMul;
                else
                    prod[i] = leftMul;
                for(int right=i+1;right<len;right++){
                prod[i] = prod[i]*nums[right];
                }
        }

        for(int j = len-1; j>0; j--){
            if(prod[j]!=0)
                prod[j] = prod[j]*rightMul;
            else
                prod[j] = rightMul;
            for(int left=j-1;left>0;left--) {
                prod[j] = prod[j] * nums[left];
            }

        }

        return prod;
    }

    private static int mulSubArr(int[] arr,int src,int dest){
//        int prod = IntStream.range(src,dest).
//                reduce(1,)
        int prod = 1;
        for(int i=src;i<dest;i++){
            prod = prod * arr[i];
        }
        return prod;
    }

    public static void main(String[] args) {
        ProductExSelf p = new ProductExSelf();
        int nums[] = {-1,1,0,-3,3};
        int prod[] = p.productExceptSelf(nums);

        for(int i:prod){
            System.out.println(i);
        }
    }
}
