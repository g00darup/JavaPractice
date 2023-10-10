package leetcode.easy.other;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.stream.Collectors;

public class PredictWinner {
    Integer currentSum = 0;
    List<Integer> integers;
    public boolean predictTheWinner(int[] nums) {
        integers =
                Arrays.stream(nums).boxed()
                        .collect(Collectors.toList());

         this.currentSum =
                currentSum(integers);

        Map<Integer, List> map1 = new HashMap<>();
        Map<Integer, List> map2 = new HashMap<>();
        int count = 0;
//        while(count<nums.length) {
//            choose(map1,integers.get(0) );
//        }


        return false;
    }

    private Integer currentSum(List<Integer> integers) {
        return integers.stream()
                .reduce(0, Integer::sum);
    }

//    private Map<String,Integer> choose(Map<Integer,List> maps,int valIndx){
//        Integer
//    }

//    private int declareWinner() {
//    }

}
