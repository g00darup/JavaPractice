package CarranoDS.chap10Recursion;

public class Recursion {

    public static void countDown(int integer) {
        if (integer == 1)
            System.out.println(integer);
        else {
            System.out.println(integer);
            countDown(integer - 1);
        }
    }

        public static int sumOf(int n){
            int sum =0;
            if(n==1)
                sum =1;
            else
                sum = sumOf(n-1);

            return sum;

        }

        public static void displayArray(int arr[], int first, int last) {

        if(first==last)
            System.out.println(arr[first]+" ");
        else{
            int mid = (first+last)/2;
            displayArray(arr, first, mid);
            displayArray(arr, mid+1, last);
        }

    }

    int fibo (int num){
        if(num==1)
            return 1;
        else
            return fibo(num-1)+fibo(num-2);
    }
}
