package cs61b.lab03;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayOperations {



    /*The insert method takes three arguments: an int array, a position in the array,
            and an int to put into that position. All the subsequent elements in the array
            are moved over by one position to make room for the new element. The last value in the array is lost.
             */
    int[] insert (int[] values,int pos, int val) throws Exception {
        if (pos < 0 || pos >= values.length) {
            throw new Exception("position is invalid");
        }
        int len = (values.length) - pos;
        int left[] = new int[pos+1];
        int right[] = new int[len-1];
        System.arraycopy(values,0,left,0,pos);
        left[pos]=val;
        System.arraycopy(values,pos,right,0,len-1);
        int [] result = combine(left,right);
        return result;
    }
    /*
    The delete method takes two arguments: an int array and a position in the array.
    The subsequent elements are moved down one position, and the value 0 is assigned to the last array element.
     */
    int[] delete (int[] values,int pos) throws Exception {
        if (pos < 0 || pos >= values.length) {
            throw new Exception("position is invalid");
        }
        return values;
    }

    public static int[] combine(int[] left, int[] right) {
        int[] res = new int [left.length+ right.length];
        System.arraycopy(left,0,res,0,left.length);
        System.arraycopy(right,0,res,left.length,right.length);
        return res ;
    }

    public static void main(String[] args) throws Exception {
        ArrayOperations ops = new ArrayOperations();
        int [] array = {1, 2, 3, 4, 5};
        int [] res = ops.insert(array, 2, 7);

    }
}
