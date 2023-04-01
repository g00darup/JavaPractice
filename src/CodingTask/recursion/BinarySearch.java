package CodingTask.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    static int search (ArrayList<Integer> arr, int left, int right, int key){
        if(left>right)
            return -1;
        int mid = (left+right)/2;

        if(key==arr.get(mid)){
            return mid;
        }else if (key > arr.get(mid)){
           return search(arr,mid-1,right,key);
        }else if (key < arr.get(mid)){
            return search(arr,left,mid-1,key);
        }

        return -1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0,1);
        arr.add(1,2);
        arr.add(2,3);
        arr.add(3,4);
        arr.add(4,5);
        int indx = search(arr,0,arr.size()-1,3);
        if(indx>0)
            System.out.println("element foind at "+indx);
    }
}
