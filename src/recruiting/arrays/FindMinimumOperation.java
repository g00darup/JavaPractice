package recruiting.arrays;

public class FindMinimumOperation {

    static int findDirectionOfMin(int[] arr, int left, int right){
        //arr already sorted in correct order
            if(right<left)
                return arr[0];
//            if(left==right)
//                return arr[left];

            int mid = left + (right-left)/2;
            //if mid+1 is min
            if(mid<right && arr[mid+1]<arr[mid])
                return arr[mid+1];
            //if mid is min
            if(mid>left && arr[mid]<arr[mid-1])
                return arr[mid];

            if(arr[right]>arr[mid])
                return findDirectionOfMin(arr,left,mid-1);
            else
                return findDirectionOfMin(arr,mid+1,right);

    }

    public static void main(String args[]){
        //int[] arr = { 4, 5, 6, 7, 0, 1, 2};
        //int [] arr = {0,1,2,3,4,5,6,7};
        int[] arr = {2};
        System.out.println(findDirectionOfMin(arr,0,arr.length-1));
    }

}

