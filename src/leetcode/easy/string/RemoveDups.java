package leetcode.easy.string;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDups {
        public int removeDuplicates(int[] nums) {

            Set s = Arrays.asList(nums).stream().collect(Collectors.toSet());

            return s.size();
        }

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};

        RemoveDups rd = new RemoveDups();
        System.out.println(rd.removeDuplicates(nums));
    }
}
