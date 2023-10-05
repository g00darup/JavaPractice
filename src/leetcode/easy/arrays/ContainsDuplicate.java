package leetcode.easy.arrays;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        List lis = List.of(nums);
        Set s = (Set) lis.stream().collect(Collectors.toSet());
        return s.size() == nums.length;
    }
}
