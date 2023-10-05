package leetcode.easy.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        return s.size() != nums.length;
    }

    public static void main(String[] args) {
        int [] in = {1,2,3,4};
        ContainsDuplicate duplicate = new ContainsDuplicate();
        System.out.println(duplicate.containsDuplicate(in));
    }
}
