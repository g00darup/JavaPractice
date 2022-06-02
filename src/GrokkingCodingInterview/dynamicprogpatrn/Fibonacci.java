package GrokkingCodingInterview.dynamicprogpatrn;

public class Fibonacci {

    public int calculateFibonacci(int n){
        if(n<2)
            return n;
        return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fib is --->"+fib.calculateFibonacci(5));
        System.out.println("5th Fib is --->"+fib.calculateFibonacci(6));
        System.out.println("5th Fib is --->"+fib.calculateFibonacci(7));

    }
}
