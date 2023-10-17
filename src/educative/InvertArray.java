package educative;

import java.util.List;

public class InvertArray {
    int[] invert (int[] arr){
        int l = 0;
        int r = arr.length-1;

        if(l<r)
           return invertHelper(arr,l++,r--);

        return arr;
    }

    private int[] invertHelper(int[] arr, int i, int j) {
        return swap (arr,i, j);
    }

    private int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }

    boolean isBalancedPT(String[]  paraArr){
    int l = 0;
    int r = paraArr.length-1;
    if(l<r)
       return check(paraArr,l++,r--);
    else
        return false;
    }

    boolean check(String[] para, int st, int end){
        if(para[st].equals("(") && para[end].equals(")")){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        InvertArray a = new InvertArray();
//        arr = a.invert(arr);

         String pa[] = {"(","(","(",")"};
         boolean res = a.isBalancedPT(pa);
        //List.of(arr).stream().forEach(System.out::println);
//        for(int i:arr){
//            System.out.println(i);
//        }
        System.out.println(res);
    }
}
