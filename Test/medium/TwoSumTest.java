package medium;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.*;
import leetcode.TwoSum;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest{

//    @Test
//    public void test1(){
//        int [] nums = {2,7,11,15};
//        int target = 9;
//        int [] res = {1,0};
//        assertArrayEquals(res,TwoSum.twoSum(nums,target));
//    }

    @Test
    public void test2(){
        int [] nums = {3,2,4};
        int target = 6;
        int [] res = {1,2};
        assertArrayEquals(res,TwoSum.twoSum(nums,target));
    }
}
