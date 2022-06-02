package GrokkingCodingInterview.datastructure.Array;

import java.util.Arrays;

public class MergeArrays {
    int[] mergeArrays(int[] arr1, int[] arr2){
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[] res = new int[length1 + length2];
        int tot=0,a1Count=0,a2Count=0;

        for(int i=0;i<res.length;i++){
            if(a1Count==length1 || a2Count == length2){
                break;
            }
            else if(a1Count<length1 && a2Count < length2 && arr1[a1Count]<arr2[a2Count]){
                res[i] = arr1[a1Count];
                a1Count++;
            }else if (a1Count<length1 && a2Count < length2 && arr1[a1Count]>arr2[a2Count]){
                res[i] = arr2[a2Count];
                a2Count++;
            }
            tot=i;
        }


        if(a1Count<length1 && a2Count==length2)
            System.arraycopy(arr1,a1Count,res,a1Count+a2Count,length1-a1Count);

        if(a2Count<length2 && a1Count==length1)
            System.arraycopy(arr2,a2Count,res,a1Count+a2Count,length2-a2Count);

//        while (a1Count < length1)
//            res[tot++] = arr1[a1Count++];
//
//        // Store remaining elements of second array
//        while (a2Count < length2)
//            res[tot++] = arr2[a2Count++];

        return res;
    }

    public static void main(String[] args) {
        new MergeArrays().run();
    }

    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        boolean result =  Arrays.equals(expected,output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        int[] arr1 = {1, 3, 4, 5}, arr2 = {2, 6, 7, 8};
        int[] expected_1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] output_1 = mergeArrays(arr1,arr2);
        check(expected_1, output_1);

       // MergeArrays([1,3,3,4,4,5] + [3,5,6,7,8]) //fails
        // Add your own test cases here
    }
}
