package GrokkingCodingInterview.datastructure.Array;
/*
In this problem, you have to implement the void maxMin(int[] arr) method.
This will re-arrange the elements of a sorted array in such a way that the first position will have the largest number,
the second will have the smallest, the third will have the second-largest, and so on.
*/

public class CheckMaxMin {
    public static void maxMin(int[] arr) {
        int length = arr.length;
        int last = 0;
        int temp=0;
        // Write - Your - Code
        for(int i=0;i<length;i++){
            last = arr[length -1];
            int smaller = arr[i];
            arr[i]=last;
            arr[(length-1)-i]=smaller;
        }
    }
/*
Explanation #
This solution is very smart. We actually store two elements at one index mathematically.
The original element is stored as the remainder, while the max/min element is stored as the multiplier.
The following line achieves this;

arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
Here, arr[maxId] is stored as the multiplier. Whereas, arr[i] is stored as the remainder.
For example in the array, [1, 2, 3, 4, 5, 6, 7, 8, 9],
the maxElem which is any element greater than the maximum element in the array,
in this case, is 10 and 91 is stored at index 0. With 91, we can get the original element, 1,
using the expression 91%10 as well as the new element, 9, using the expression 91/10.

This allows us to swap the numbers in place without losing any data or using any extra space.
To get the final array, we simply divide each element by maxElem as done in the last for loop.
*/

    public static void maxMin2(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for( int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0){
                arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
                maxIdx -= 1;
            }
            else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem ) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for( int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};

        maxMin(arr);

        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
