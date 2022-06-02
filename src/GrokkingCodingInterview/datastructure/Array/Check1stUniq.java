package GrokkingCodingInterview.datastructure.Array;

public class Check1stUniq {
    public static int findFirstUnique(int[] arr)
    {
        int result = 0;
        for(int i=0;i<arr.length;i++){
            if(find(arr[i],i,arr)){
                result = i;
            }

        }
        // write your code here
        return arr[result];
    }

    static boolean find(int k, int st, int[] arr){
        int[] res = new int[arr.length-(st+1)];
        System.arraycopy(arr,st,res,0,arr.length-(st+1));

        for(int i=0;i<res.length;i++){
            if(arr[i]==k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Check1stUniq().run();
    }

    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result =  (expected==output);
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
        int[] array_a_1 = {9, 2, 3, 2, 6, 6};
        int expected_1 = 9;
        int output_1 = findFirstUnique(array_a_1);
        check(expected_1, output_1);
        // Add your own test cases here
    }
}
