package leetcode.hard.arrays;

public class MedianOfSortedArray {


        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double ret = 0.0;
            int totLen = nums1.length + nums2.length;
            int [] nT = new int[totLen];

            if(nums1.length>nums2.length)
                System.arraycopy(nums1,0,nT, nums1.length-1,nums1.length);
            else
                System.arraycopy(nums2,0,nT, nums2.length-1,nums2.length);

            if(nums1.length>=nums2.length){
                for(int j=0,p=0;j< nT.length;){
                    int pos = findPos(nums1,nums2[p]);
                    if(pos!= nT.length-1)
                        shiftRightByOne(nT,pos);
                    nT[pos] = nums2[p];
                    p++;
                    j=j+pos;
                }
            }else{
                for(int k=0,p=0;k< nT.length;){
                    int pos = findPos(nums1,nums2[k]);
                    if(pos!= nT.length-1)
                        shiftRightByOne(nT,pos);
                    nT[pos] = nums2[p];
                    p++;
                    k=k+pos;
                }
            }
            return ret;
        }

        int findPos(int[] nums,int key){
            int l = 0;
            int r = nums.length-1;
            int m = (l+r)/2;
            return 0;
        }

        int[] shiftRightByOne(int[] nums,int pos){

            for(int i=pos;i<(nums.length-1);i++){
                nums[i] = nums[i+1];
            }
            return nums;
        }

}
