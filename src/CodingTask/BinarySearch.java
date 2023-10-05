package CodingTask;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6};
        System.out.println(bsearch(arr,5));
    }

    public static final int bsearch(int[] arr,int key){
        int left = 0;
        int right = arr.length-1;
        return  bsearchHelper(arr,left,right,key);
    }

    private static int bsearchHelper(int[] arr, int left, int right,int key) {
        if(left>right)
            return -99;
        int mid = (left+right)/2;
        if(key==arr[mid])
            return mid;
        else if(key<arr[mid]){
            right=mid;
            return bsearchHelper(arr,left,right,key);
        }else if(key>arr[mid]){
            left=mid;
            return bsearchHelper(arr,left,right,key);
        }
        return -99;


    }
}
