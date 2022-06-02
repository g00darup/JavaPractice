package GrokkingCodingInterview.datastructure.Array;
/*
    In this problem, you have to implement the void rotateArray(int[] arr) method,
    which takes an arr and rotate it right by 1.
    This means that the right-most elements will appear at the left-most position in the array.
 */
public class CheckRotateArray {
    public static void rotateArray(int[] arr){

       int last = arr[arr.length-1];

       for(int i=arr.length-1;i>0;i--){
           arr[i]=arr[i-1];
       }
       arr[0]=last;
    }
}
