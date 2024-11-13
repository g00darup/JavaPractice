package leetcode.easy.arrays;

public class XorTrick {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};

        boolean res = containsDuplicate(arr);
        System.out.println( res);

    }

    public static boolean containsDuplicate(int[] nums) {
        boolean result = false;
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                int res = 0;
                if(i!=j) {
                    res = nums[i]^nums[j];
                    if(res==0)
                        return true;
                }
            }
        }

        return result;
    }
}
