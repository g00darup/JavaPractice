package GrokkingCodingInterview.dynamicprogpatrn;

public class CachedFibonacci {
    int fib[];
    public int calculateFibonacci(int n){
        fib = new int[n+1];
        return cachedFibonacci(n,fib);
    }

    private int cachedFibonacci(int n, int[] fib) {
        if(n<2)
            return n;
        if(fib[n]!=0)
            return fib[n];
        fib[n] = cachedFibonacci(n-1,fib)+cachedFibonacci(n-2,fib);
        return fib[n];
    }

    public static int fib(int n, int lookupTable[])
    {
        if (lookupTable[n] == -1) { // Check if already present
            // Adding entry to table when not present
            if (n <= 1)
                lookupTable[n] = n;
            else
                lookupTable[n] = fib(n - 1, lookupTable) + fib(n - 2, lookupTable);
        }
        return lookupTable[n];
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("5th Fib is --->"+fib.calculateFibonacci(5));
        System.out.println("5th Fib is --->"+fib.calculateFibonacci(6));
        System.out.println("5th Fib is --->"+fib.calculateFibonacci(7));

        int n = 6; // Finding the nth Fibonacci number
        int [] lookupTable = new int[n+1];
        for (int i = 0; i < n+1; i++)
            lookupTable[i] = -1; // Initializing the look up table to have -1

        System.out.println(fib(n, lookupTable));

    }
}
