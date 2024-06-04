package techiedelight.Recursion;

import java.util.Arrays;

public class SumArr {
    public static int sum(int[] arr){
        if(arr!=null && arr.length>1)
            return arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
        else if (arr!=null && arr.length==1)
            return arr[0];
        return 0;
    }

//    private static int sumHelper(int i, int[] arr) {
//        return i + sumHelper(arr[0], Arrays.copyOfRange(arr, 0, arr.length));
//    }

    public static void main(String[] args) {
        int[] sampleArray = {1, 2, 3, 4, 5};
        int sum = sum(sampleArray);
        System.out.println(sum);
    }
}
