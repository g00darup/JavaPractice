package GrokkingCodingInterview.datastructure.Array;

import GrokkingCodingInterview.dynamicprogpatrn.Knasack.BruteForce;

import java.util.Arrays;

public class CheckRemoveEven {

    public int[] removeEven(int[] arr) {
        boolean[] markedForDel = new boolean[arr.length];
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    markedForDel[i] = true;
                }
            }
        }
        int count = arr.length - 1;
        int delArrayCount = count;
        int[] modifiedArr=null;
        if (markedForDel != null) {
            modifiedArr = arr;
            while (count > 0) {
                if (markedForDel[count]) {
                    int element = modifiedArr[modifiedArr.length-1];
                    int[] modifiedArr2 = new int[modifiedArr.length - 1];
                    System.arraycopy(modifiedArr, 0, modifiedArr2, 0, modifiedArr.length - 1);
                    modifiedArr2[modifiedArr2.length - 1] = element;
                    modifiedArr = modifiedArr2;
                }
                count--;
            }
            arr = modifiedArr;

        }


        // Write - Your - Code- Here
        return arr; // change this and return the correct result array
    }

    public int[] filterEven(int[] arr) {
        int[] newArr = new int[arr.length];
        int newCount=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                newArr[newCount]=arr[i];
                newCount++;
            }
        }

        arr = new int[newCount];

        System.arraycopy(newArr,0,arr,0,newCount);

        return  arr;

    }

    public static void main(String[] args) {
        new CheckRemoveEven().run();
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
        int[] array_a_1 = {1, 2, 4, 5, 10, 6, 3};
        int[] expected_1 = {1, 5, 3};
        int[] output_1 = filterEven(array_a_1);
        check(expected_1, output_1);
       // Add your own test cases here
    }
}