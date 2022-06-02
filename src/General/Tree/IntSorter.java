package General.Tree;

import java.util.Arrays;

public class IntSorter {
    public static int reverseCompare(Integer i1, Integer i2) {
        return -(Integer.compare(i1, i2));
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        Arrays.sort(arr, IntSorter::reverseCompare);
        //System.out.println(Arrays.toString(arr)); // [3, 2, 1]

        Integer[] arr2 = {1, 2, 3};
        Arrays.sort(arr2, (o1, o2) -> -(Integer.compare(o1, o2)));
        System.out.println(Arrays.toString(arr)); // [3, 2, 1]
    }
}
