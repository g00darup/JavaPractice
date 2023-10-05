package leetcode.easy.arrays;

public class ProductExSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int prod[] = new int [len];
        int leftMul=1,rightMul=1;
        int rightCount=0,leftCount=0;
        for(int i=1;i<len;i++) {
                prod[i] = leftMul;
                prod[i] = prod[i]*nums[i];
                rightCount++;
        }

        for(int j=len-1;j>1;j--){
            prod[j] = prod[j]*rightMul;
            prod[j] = prod[j]*nums[j];
            leftCount++;
        }

        return prod;
    }

    public static void main(String[] args) {
        ProductExSelf p = new ProductExSelf();
        int nums[] = {1,2,3,4};
        int prod[] = p.productExceptSelf(nums);

        for(int i:prod){
            System.out.println(i);
        }
    }
}
