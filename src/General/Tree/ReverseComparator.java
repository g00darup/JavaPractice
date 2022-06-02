package General.Tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReverseComparator implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        return -(Integer.compare(o1, o2));
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 6};
        List list = Arrays.asList(arr);
        Collections.sort(list, new ReverseComparator());
        // The above line sorts based on ReverseComparator's compare method
        list.forEach(t-> System.out.println(t.toString()));
        //System.out.println(Arrays.toString(arr)); // [3, 2, 1]
    }
}
