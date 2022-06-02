package GrokkingCodingInterview.dynamicprogpatrn.GreedyAlgorithms;

public class MaxNumber {
    public static void findLargestNumber(int number_of_digits, int sum_of_digits) {
        int[] result = new int[number_of_digits];
        // If sum of digits is 0, then a number is possible only if number of digits is 1.
        if (sum_of_digits == 0) {
            if (number_of_digits == 1) {
                System.out.print(0);
            } else {
                System.out.print("None");
            }
            return;
        }
        // sumOfDigits is greater than the maximum possible sum.
        if (sum_of_digits > 9 * number_of_digits) {
            System.out.print("None");
            return;
        }
        // Fill from most significant digit to least significant digit!
        for (int i = 0; i < number_of_digits; i++) {
            // Place 9 to make the number largest
            if (sum_of_digits >= 9) {
                result[i] = 9;
                sum_of_digits -= 9;
            }
            // If remaining sum becomes less than 9, then fill the remaining sum
            else {
                result[i] = sum_of_digits;
                sum_of_digits = 0;
            }
        }
        for (int i = 0; i < number_of_digits; i++) {
            System.out.print(result[i]);
        }
    }

    public static void main(String[] args) {
        int sumOfDigits = 20;
        int numberOfDigits = 3;

        System.out.println("If sum of digits is 20 and number of digits is 3 then ");
        MaxNumber.findLargestNumber(numberOfDigits, sumOfDigits);
        System.out.println();

        //Example 2
        sumOfDigits = 100;
        numberOfDigits = 2;

        System.out.println("If sum of digits is 100 and number of digits is 2 then ");
        MaxNumber.findLargestNumber(numberOfDigits, sumOfDigits);

    }
}