package GrokkingCodingInterview.dynamicprogpatrn;

public class BottomUpFibonacci {

    public int fibo(int n){
        if(n==0) return 0;
        int dp[] = new int[n+1];

        //base casses
        dp[0]=1;
        dp[1]=1;

        for (int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fib is --->"+fib.calculateFibonacci(5));
        System.out.println("5th Fib is --->"+fib.calculateFibonacci(6));
        System.out.println("5th Fib is --->"+fib.calculateFibonacci(7));

    }
}
