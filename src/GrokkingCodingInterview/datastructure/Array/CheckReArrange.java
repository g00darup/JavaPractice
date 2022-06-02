package GrokkingCodingInterview.datastructure.Array;
/*
In this problem, you have to implement the void reArrange(int[] arr) method, which will sort the elements,
such that all the negative elements appear at the left and positive elements appear at the right.

Sample Input
arr = {10, -1, 20, 4, 5, -9, -6}

Sample Output #
arr = {-1, -9, -6, 10, 20, 4, 5}
 */
public class CheckReArrange {
    public static void reArrange(int[] arr) {

        int posNums=0;
        int negNums=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<0)
                negNums++;
            else
                posNums++;
        }

        int [] posArr =null;
        int [] negArr =null;

        if(posNums>0)
            posArr = new int[posNums];

        if(negNums>0)
            negArr = new int[negNums];

        int j=0,k=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                negArr[j]=arr[i];
                j++;
            }
            else {
                posArr[k]=arr[i];
                k++;
            }
        }

        if(negArr!=null){
            System.arraycopy(negArr,0,arr,0,negArr.length);
        }

        if(posArr!=null){
            if(negArr!=null)
                System.arraycopy(posArr,negArr.length,arr,negArr.length,posArr.length);
        }

    }

    public static void reArr(int [] arr){

        int maxId = arr.length-1;
        int miIdx = 0;

        int maxElem = arr[maxId]+1;

        for(int i=0; i<arr.length;i++){
         if(i%2 ==0){
             arr[i] += (arr[maxId]%maxElem)*maxElem;
             maxId -=1;
            }else {
             arr[i] += (arr[miIdx]%maxElem)*maxElem;
             miIdx -=1;
         }
        }
        for( int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }

    // Re-arrange in place
    //Re-Arrange Positive and Negative Values of Given Array
    public static void reArrange2(int[] arr)
    {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j]; // swapping with leftmost positive
                    arr[j] = temp;
                }
                j++;
            }
        }
    } //end of reArrange()
}
