package GrokkingCodingInterview.dynamicprogpatrn.GreedyAlgorithms;

/*
Problem statement #
You have to make such a change machine that only returns the change in the form of coinscoins.

You are supplied with an infinite number of quarters (25\ cents)(25 cents), dimes (10\ cents)(10 cents), nickels (5\ cents)(5 cents), and pennies (1\ cent)(1 cent). The user will enter any amount. For each amount, you have to return the minimum number of coins possible!

svg viewer
An image showing the coins used along with their values
Input #
The input is a variable C (total amount of moneymoney to convert into coins).

Output #
The outputs are the number of coinscoins and a print statement that tells the number and type of coins.

Sample input #
C = $50
Sample output #
25, 25
 */

import java.util.ArrayList;

public class ChangeMachine {

    public static int[] coins = {25, 10, 5, 1}; // a public collection of available coins

    // function to recieve change in the form of coins
    public static ArrayList < Integer > getMinCoins(int amount) {

        // an array list to store all the coins
        ArrayList< Integer > change = new ArrayList < Integer > ();
        for (int i = 0; i < coins.length && amount > 0; i++) // traverse through all available coins
        {
            while (amount >= coins[i]) // keep checking if the amount is greater than the max coin
            {
                amount -= coins[i]; // subtract the maximum coin selected from the total amount in every iteration
                change.add(coins[i]); // add the coin to the list of 'change'
            }
        }
        return change; // return the list containing all the change
    }

    public static void main(String args[])
    {
        // Play around with this amount to see how many coins you get!
        int amount = 1;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 17;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 33;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 99;
        System.out.println(amount + " --> " + getMinCoins(amount));
    }
}