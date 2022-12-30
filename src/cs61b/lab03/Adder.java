package cs61b.lab03;

import java.util.Scanner;

public class Adder {
    static final int MAXIMUM_NUMBER_OF_INPUTS = 10;

    private static int reset () {
        return 0;
    }

    private static int adder(int prev, int curr){
        return prev + curr;
    }

    public static void main(String[] args) {
        int count = 0;
        int k;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (count < MAXIMUM_NUMBER_OF_INPUTS){
            k = scanner.nextInt();
            if(k==0){
                System.out.println("subtotal:" + sum);
                sum = reset();
            }else{
                sum = adder(sum,k);
            }
            count++;
        }

    }
}
