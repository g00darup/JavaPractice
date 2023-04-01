package CodingTask.recursion;

public class LinearSum {
    public static int linearSum(int[] src,int len){
        if(len==1)
            return src[0];
        else
            return src[len-1]+
                    linearSum(src,len-1);
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5,6,7 };
        System.out.println(linearSum(arr, arr.length));
    }
}
