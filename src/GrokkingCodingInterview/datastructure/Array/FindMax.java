package GrokkingCodingInterview.datastructure.Array;

import java.util.ArrayList;
import java.util.List;

public class FindMax {
    public static int findMaxSumSubArray(int[] arr) {

        int[] maxSum = new int[arr.length-1];
        int currMax=0;
        boolean firstPass=false;

        if(arr!=null)
            maxSum[0]=arr[0];

        if(maxSum[0]<currMax)
            maxSum[0]=currMax;
        int count=0;

        for(int i=0;i<arr.length;i++){
            currMax+=arr[i];
            if(currMax>maxSum[count]) {
                maxSum[count] += currMax;
            }else{
                count++;
            }
        }

        return currMax;
    }

    public static int findMaxSumSubArray2(int[] arr) {
        int max=0;

        List arrPos = new ArrayList();

        for(int i=0;i<arr.length;i++)
            arrPos.add(arr[i]);

        findAllSums(arrPos,0,arr.length);

        //max=findMax(arrPos.toArray());

        return max;
    }

    private static void findAllSums(List arrPos, int i, int length) {

        for(int c=i;c<length-1;c++){
          // arrPos.add(arrPos.get(i) + arrPos.get(i + 1));
        }

    }

    static int nCr(int n, int r)
    {
        return fact(n) / (fact(r) * fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n)
    {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

    static List nthRowPascal(int n){
        List<Integer> arr = new ArrayList<>();
        if(n==0 || n==1){
            arr.add(1);
            return arr;
        }
        if(n>=2)
            arr.add((arr.get(n-1)+arr.get(n-2)));
        return arr;
    }

    static int findMax(int[] arr){
        int max = arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }


    public static int findSecondMaximum2(int[] arr) {

        int max = Integer.MIN_VALUE;;
        int secondmax = Integer.MIN_VALUE;

        // Keep track of Maximum value, whenever the value at an array index is greater
        // than current Maximum value then make that max value 2nd max value and
        // make that index value maximum value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondmax = max;
                max = arr[i];
            }
            else if (arr[i] > secondmax && arr[i] != max) {
                secondmax = arr[i];
            }
        }//end of for-loop

        return secondmax;
    }

    public static void main(String[] args) {
        nthRowPascal(2).stream().forEach(e-> System.out.println(e));
    }
}
