package GrokkingCodingInterview.dynamicprogpatrn;

public class Tabulation
{
    public static int fib(int n, int[] lookupTable)
    {
        lookupTable[0] = 0; // Set zeroth and first values
        lookupTable[1] = 1;

        for (int i = 2; i <= n; i++)
            lookupTable[i] = lookupTable[i-1] + lookupTable[i-2];
        // Fill up the table by summing up
        // previous two values

        return lookupTable[n]; // Return the nth Fibonacci number
    }

    public static int fib(int n)
    {
        if (n == 0)
            return 0;
        int secondLast = 0; // the zeroth
        int last = 1; // the first
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = secondLast + last; // the current is the sum of the last plus
            // second last number before the current one
            secondLast = last;
            last = current;
        }
        return current;
    }

    public static void main(String args[]) {
        int n = 6;
        int[] lookupTable = new int[n+1];
        System.out.print(fib(n, lookupTable));
    }
}
