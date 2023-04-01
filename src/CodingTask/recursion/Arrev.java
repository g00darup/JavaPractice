package CodingTask.recursion;

import java.util.Arrays;

public class Arrev {

    public static int[] rev(int[] src){
        int [] res = revHelper(src,0);
        return src;
    }

    private static int[] revHelper(int[] src, int count) {
        if(count*2>=src.length){
            return src;
        }else {
            int temp = src[count];
            src[count] = src[(src.length - 1) - count];
            src[(src.length - 1) - count] = temp;
            return revHelper(src,count+1);
        }
    }

    public static void main(String[] args) {
        int[] res = {1,2,3,4,5};
        int [] rev = rev(res);
        Arrays.stream(rev).forEach(System.out::println);
    }
}
