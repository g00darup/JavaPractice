package GrokkingCodingInterview.dynamicprogpatrn.GreedyAlgorithms;

import java.util.ArrayList;

/*
Problem statement #
Implement a function that calculates the number of thieves that can be caught.

Input #
The input is an array in which each element contains either a police officer (P) or a thief (T).

Each police officer can catch only one thief, and a police officer cannot catch a thief who is more than k units away from him.

Output #
The output is the maximum number of thieves that can be caught.

Sample input #
    policeThiefArray[] = {'P', 'T', 'T', 'P', 'T'},
    k = 1
Sample output #
    2
 */
public  class MaxThief {
    /*
    Explanation #
If we try the brute force approach, we have to check all the possible combinations of police and thief, and then return their maximum size set. Such an approach hasan exponential time complexity. However, a slight tweak in the brute force method can give us an optimized solution.

We use the greedy approach, ignoring the police officers and focusing on assigning police to thieves.

We get the lowest index of policeman pp and thief tt. We take the absolute value ( |p-t|∣p−t∣) and make an allotment if the difference of the indexes is less than k (line 19). Next, we increment to the next pp and tt (lines 21-22). If the difference is not less than k, increment the minimum of pp and tt to the next pp or tt found (lines 25-29).

Time complexity #
The solution is simple; its time complexity is O(n)O(n).
     */
    public static int policeThief(char[] arr, int k) {
        int result = 0;
        ArrayList< Integer > thieves = new ArrayList < Integer > ();
        ArrayList < Integer > police = new ArrayList < Integer > ();
        int n = arr.length;
        //store indices in the respective vector
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            }
            else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }
        int trackThieves = 0, trackPolice = 0;
        while (trackThieves < thieves.size() && trackPolice < police.size()) {
            //thieves can be caught
            if (Math.abs(thieves.get(trackThieves) - police.get(trackPolice)) <= k) {
                result++;
                trackThieves++;
                trackPolice++;
            }
            //increment the minimum index
            else if (thieves.get(trackThieves) < police.get(trackPolice)) {
                trackThieves++;
            }
            else {
                trackPolice++;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int k, n;

        char policeTheifArray[] = {'P', 'T', 'T', 'P', 'T'};
        k = 2;

        System.out.println("Maximum thieves caught for {P, T, T, P, T}: " + MaxThief.policeThief(policeTheifArray,k));

        char policeTheifArray1[] = {'T', 'T', 'P', 'P', 'T', 'P'};
        k = 2;

        System.out.println("Maximum thieves caught for {T, T, P, P, T,P}: " + MaxThief.policeThief(policeTheifArray1, k));

    }
}
