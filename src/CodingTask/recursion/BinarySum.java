package CodingTask.recursion;

public class BinarySum {
    public static int BinarySum(int[] A,int i,int n){
        if(n==i)
            return A[i];
        else
            return BinarySum(A,i, n/2)+
                    BinarySum(A,i+(n/2),n/2);
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5,6,7,8,9,10,11 };
        System.out.println(BinarySum(arr, 0,10));
    }
}
