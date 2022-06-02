package GrokkingCodingInterview.dynamicprogpatrn.GreedyAlgorithms;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

/*
Problem Statement #
You are given the capacity of a knapsack WW and a list of ​”​​n​”​​ items that each have a certain value. Fractions of each item can be placed in the knapsack. Your goal is to implement a function for getting the maximum possible total value of VV in the knapsack.

Note: This problem is also known as the continuous\ knapsackcontinuous knapsack problem.

Input #
the inputs are the items as (value, weight)(value,weight) pairs and the knapsack capacity WW.

Output #
The output is the maximum possible value.

Sample input #
double[] weights = {2, 1, 6, 0.5, 0.25, 7};
double[] values = {50, 70, 100, 50, 30, 99};
int capacity = 10;

Sample output #
double result =  303.54;

💡 Did you know?
In the 0/1 Knapsack problem, we are not allowed to break the items. We either take the whole item or do not take it at all. However, here we can split the items.
 */
public class FractionalKnapsack {
    /*
    Explanation #
The key to solving this problem is that we can easily break the items to maximize the total value of the knapsack, just like you would to gold pieces.

Therefore, we can easily grab the item with the greatest ratio and break off the largest piece. The remainder of the bag can be filled with smaller ratio pieces, utilizing the maximum space.

Here, we calculate the ratio value/weightvalue/weight for each item and sort the items on the basis of this ratio.

Then, we take the items with the highest ratio and add them to the knapsack until we cannot add the next item as a whole. At the end, add as much of the next item as you can.

Time complexity #
Since the only step that takes major time is sorting algorithm, in the worst case, the whole solution takes O(n*lg(n))O(n∗lg(n)), where nn is the total number of items available.
     */
    private static double getMaxValue(double[] w, double[] v, double c) {
        int totalItems = v.length;
        ItemValue[] iVal = new ItemValue[totalItems];

        for (int i = 0; i < totalItems; i++) {
            iVal[i] = new ItemValue(w[i], v[i], i);
        }

        Arrays.sort(iVal, new Comparator< ItemValue >(){
            public int compare(ItemValue sampleObj1, ItemValue sampleObj2) {
                return sampleObj2.cost.compareTo(sampleObj1.cost);
            }
        });
        double totalValue = 0;
        for (ItemValue i: iVal) // iterator to traverse items list
        {
            double currWeight = (double) i.w;
            double currValue = (double) i.v;

            if (c - currWeight >= 0) // this item can be picked as whole
            {
                c = c - currWeight;
                totalValue += currValue;

                // uncomment the following line to see the step by step working of this function
                // System.out.println("c, v, t = " + c + ", " + currValue + ", " + totalValue);
            } else // item can't be picked as whole
            {
                double fraction = ((double) c / (double) currWeight); // only a fraction of it can be obtained!
                totalValue += (currValue * fraction);
                c = (double)(c - (currWeight * fraction));

                // uncomment the following line to see the step by step working of this function
                // System.out.println("c, v, t = " + c + ", " + currValue + ", " + totalValue + "\n");
                break;
            }
        }
        return totalValue;
    }

    static class ItemValue // item value class
    {
        Double cost;
        double w, v, i;

        public ItemValue(double weight, double value, int index) // constructor
        {
            w = weight;
            v = value;
            i = index;
            cost = new Double(v / w);
        }
    }

    public static void main(String[] args) {
        DecimalFormat decimal = new DecimalFormat("#.##"); // this class rounds off the double upto 2 decimal places

        double[] weights = {2, 1, 6, 0.5, 0.25, 7};
        double[] values = {50, 70, 100, 50, 30, 99};
        int capacity = 10;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum value we can obtain = " + decimal.format(maxValue));
    }
}
