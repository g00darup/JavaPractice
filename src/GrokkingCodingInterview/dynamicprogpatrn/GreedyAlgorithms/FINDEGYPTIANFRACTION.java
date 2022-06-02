package GrokkingCodingInterview.dynamicprogpatrn.GreedyAlgorithms;
/*
Problem statement #
Every positive fraction can be represented as the sum of its unique unit fractions. A fraction is a unit fraction if the numerator is 1 and the denominator is a positive integer. For example, 1/3 is a unit fraction. Such a representation is called Egyptian fraction.

Input #
The inputs are two variables, numerator and denominator.

Output #
The output is a string in the format n1/d1 , n2/d2 ...

Sample input #
  numerator: 2

  denominator: 3
Sample output #
       1/2, 1/6

 */
public class FINDEGYPTIANFRACTION
{
    /*
    Explanation #
We can generate Egyptian fractions using the greedy algorithm. For a given number of the form n/d, where d > n,
first find the greatest possible unit fraction, and then perform recursion for the remaining part.

For example, consider 6/146/14. We first find the ceiling of \lceil 14/6 \rceil⌈14/6⌉,
i.e., 33, so the first unit fraction becomes 1/31/3. Now subtract 1/31/3 out of 6/146/14
and recur for (6/14(6/14 – $1/3), $ i.e., 4/424/42.

We use the greedy algorithm because we want to reduce the fraction to a form where
the denominator is greater than the numerator and the numerator doesn’t divide the denominator.

The method is to find the biggest unit fraction we can and subtract it from the remaining fraction.
Doing subtractions always decreases this group of unit fractions, but it never repeats a fraction
and eventually will stop, which is why we call this approach greedy.

Time complexity #
The time complexity is O(log n)O(logn) because each time we reduce the fraction using recursive calls as the reduction is in the form of division.
     */
    public static void printEgyptianFraction(int numerator, int denominator)
    {
        //if either numerator or denominator is zero
        if (denominator == 0 || numerator == 0){
            return;
        }
        //numerator divides denominator -> fraction in 1/n form
        if (denominator % numerator == 0) {
            System.out.print("1/" + denominator / numerator);
            return;
        }
        //denominator can divide numerator -> number not a fraction
        if (numerator % denominator == 0) {
            System.out.println(numerator / denominator);
            return;
        }
        //if numerator greater than denominator
        if (numerator > denominator) {
            System.out.println(numerator / denominator + " , ");
            printEgyptianFraction(numerator % denominator, denominator);
            return;
        }
        //denominator  greater than numerator here
        int n = denominator / numerator + 1;
        System.out.print("1/" + n + " , ");
        //call function recursively for remaining part
        printEgyptianFraction(numerator * n - denominator, denominator * n);
    }



    public static void main(String[] args){

        //Example 1
        int numerator = 6, denominator = 14;
        System.out.print("Egyptian Fraction Representation of " + numerator + "/" + denominator + " is\n ");
        FINDEGYPTIANFRACTION.printEgyptianFraction(numerator, denominator);
        System.out.println();

        //Example 2
        numerator = 2;
        denominator = 3;
        System.out.print("Egyptian Fraction Representation of " + numerator + "/" + denominator + " is\n ");
        FINDEGYPTIANFRACTION.printEgyptianFraction(numerator, denominator);

    }
}
