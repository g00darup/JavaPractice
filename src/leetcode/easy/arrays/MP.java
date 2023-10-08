package leetcode.easy.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MP {
    public int maxProfit(int[] prices) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                map.put(String.valueOf(i)+String.valueOf(j),calDiff(prices,i,j));
            }
        }
        List<Integer> result2 = map.values().stream().sorted().toList();
        Integer max = 0;
        if(result2!=null && result2.size()>=1)
            max =result2.get(result2.size() - 1);
        if(max>0)
            return max;
        else
            return 0;
    }

    static int calDiff(int[] arr, int start, int end){
        return arr[end]-arr[start];
    }

    public static void main(String[] args) {
        MP m = new MP();
        int [] prices = {7,1,5,3,6,4};
        System.out.println(m.maxProfit(prices));
    }
}
