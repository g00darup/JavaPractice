package GrokkingCodingInterview.dynamicprogpatrn.GreedyAlgorithms;

import java.util.Arrays;

/*
Problem statement #
Given n pipes of different lengths, implement a function that connects these pipes into one pipe.
The cost to connect two pipes is equal to the sum of their lengths.
 We need to connect the pipes with minimum cost.

Input #
The input is an int array where its length is equal to the number of pipes available
and its indices are the specific lengths of the pipes.

Output #
The output is the total cost of connecting the pipes.

Sample input #
int [] pipes = {4, 2, 3, 7};  //it means there are a total of 4 pipes
                             // having lengths of 4, 2, 3 & 7 consecutively
Sample output #
cost = 30;
 */
public class MinCost {
/*
Start by sorting the pipes array, shown in line 7.

Next, find the cost of connecting two adjacent pipes by summing the cost at the current index and the next index of the pipes array (line 10).

Insert this cost into the array (line 11).

Next, update the cost by adding it to the previously calculated cost; this is to find the total cost (line 12).

Return the total cost at the end (line 14).

Time complexity #
The time complexity for this solution is O(nlogn)O(nlogn), because of the optimized built-in Java sort function.
 */
    public static int minCost1(int[] pipes) {

        int cost = 0;
        int n = pipes.length;
        Arrays.sort(pipes); //Sorting the array
        for (int i = 0; i < n - 1; i++) {
            int prev_cost = cost; // store previous cost for later use
            cost = (pipes[i] + pipes[i + 1]); //find current cost
            pipes[i + 1] = cost; //insert in array
            cost = cost + prev_cost; //add with previous cost
        }
        return cost;
    }

    /*
    Explanation #
We use a MinHeap to solve this problem (implementation is given in MinHeap.java file).

Start by creating a minHeap of a capacity equal to n and put all the pipes in it (line 6).

Then iterate through the minHeap until its size equals one (line 8).

While iterating, extract two minimum length pipes from the minHeap (lines 10-11).

Then, update the total cost (line 13).

Next, insert a new pipe in minHeap with a length equal to the sum of the two extracted minimum lengths.

Finally, return the total minimum cost for connecting all pipes (line 18).

Time complexity #
The time complexity of the algorithm is O(nlogn)O(nlogn).
     */
    static int minCost2(int pipes[], int n) {

        int cost = 0;
        int minimum, secondMinimum;
        MinHeap minHeap = new MinHeap(pipes, n);

        while (!minHeap.SizeIsOne()) {

            minimum = minHeap.extractMin();
            secondMinimum = minHeap.extractMin();

            cost += (minimum + secondMinimum);


            minHeap.insertKey(minimum + secondMinimum);
        }
        return cost;
    }


}

class MinHeap {
    int[] heaparr;
    int hSize;
    int capacity;

    public MinHeap(int pipes[], int size) {
        hSize = size;
        capacity = size;
        heaparr = pipes;
        int i = (hSize - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < hSize && heaparr[l] < heaparr[i])
            smallest = l;
        if (r < hSize && heaparr[r] < heaparr[smallest])
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            MinHeapify(smallest);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }


    int left(int i) {
        return (2 * i + 1);
    }


    int right(int i) {
        return (2 * i + 2);
    }


    int extractMin() {
        if (hSize <= 0)
            return Integer.MAX_VALUE;
        if (hSize == 1) {
            hSize--;
            return heaparr[0];
        }


        int root = heaparr[0];
        heaparr[0] = heaparr[hSize - 1];
        hSize--;
        MinHeapify(0);

        return root;
    }


    void insertKey(int x) {
        if (hSize == capacity) {
            System.out.println("Could not insertKey");
            return;
        }


        hSize++;
        int i = hSize - 1;
        heaparr[i] = x;


        while (i != 0 && heaparr[parent(i)] > heaparr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }


    boolean SizeIsOne() {
        return (hSize == 1);
    }


    void swap(int x, int y) {
        int temp = heaparr[x];
        heaparr[x] = heaparr[y];
        heaparr[y] = temp;
    }
}
