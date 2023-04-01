package techiedelight.Recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MaxProduct {
    static int mxProduct(Integer[] ins){
        List<Integer> list = Arrays.asList(ins);
        Integer mx1 = Collections.max(list);
        //List<Integer> list2 = list.remove(mx1);
        Integer mx2=Collections.max(list);
        return mx1*mx2;
    }

    public static void main(String[] args) {
        Integer [] arr = {4,3,-4,-5,8};
        System.out.println(mxProduct(arr));
    }
}
