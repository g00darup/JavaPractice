package leetcode.easy.arrays;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums,target));
    }
   static public int searchInsert(int[] nums, int target) {
        int res = 0;
        if(isFound(nums,nums.length-1,0,target)){
            res = findIndex(nums,nums.length-1,0,target);
        }else{
            res = findIndex(nums,nums.length-1,0,target);
            if(res <= nums.length-2 && nums[res]<target)
                res = res + 1;
        }
        return res;
    }

    static boolean isFound(int[] nums,int l, int r, int t){
        int m = (l+r)/2;
        if (l < r) {
            if(nums[m]==t){
                return true;
            }else if(t>nums[m]){
                r = m;
                return isFound(nums,l,r,t);
            }else if(t<nums[m]){
                l = m;
                return isFound(nums,l,r,t);
            }else{
                return false;
            }
        }else{
            return false;
        }

    }

    static int findIndex(int[] nums,int l, int r, int t){
        int res = -99;
        int m = (l+r)/2;
        if (l < r) {
            if (nums[m] == t) {
                res = m;
                return res;
            } else if (t > nums[m]) {
                r = m;
                return findIndex(nums, l, r, t);
            } else if (t < nums[m]) {
                l = m;
                return findIndex(nums, l, r, t);
            }
        }else {
            return r;
        }
        return res;
    }

}