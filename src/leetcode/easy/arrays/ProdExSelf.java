package leetcode.easy.arrays;

import java.util.HashMap;

public class ProdExSelf {
    public int[] productExceptSelf(int[] nums) {
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        int len = nums.length;
        int prod[] = new int [len];
        prod[0] = mulSubArr(nums,1,len-1);
        String key1 = "1"+(String.valueOf(len-1));
        String key2 = "";
        map.put(key1,prod[0]);
        for(int i=1; i<len;i++) {
//            prod[i] = mulSubArr(nums,0,i-1)*mulSubArr(nums,i+1,len-1);
            key1 = "0"+(String.valueOf(i-1));
            map.put(key1,mulSubArr(nums,0,i-1));

            key2=String.valueOf(i+1)+String.valueOf(len-1);
            map.put(key2,mulSubArr(nums,i+1,len-1));
        }

        for(int i=1; i<len;i++) {
            key1 = "0"+(String.valueOf(i-1));
            key2=String.valueOf(i+1)+String.valueOf(len-1);
            prod[i] = map.get(key1)*map.get(key2);

        }
        return prod;
    }

    private static int mulSubArr(int[] arr,int src,int dest){
        int prod = 1;
        for(int i=src;i<=dest;i++){
            prod = prod * arr[i];
        }
        return prod;
    }

    public static void main(String[] args) {
        ProdExSelf prod = new ProdExSelf();
        int [] nums = {-1,1,0,-3,3};
        int res[] = prod.productExceptSelf(nums);
        for(int u : res)
            System.out.println(u);
    }
}