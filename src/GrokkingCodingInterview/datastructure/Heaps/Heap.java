package GrokkingCodingInterview.datastructure.Heaps;

import java.util.Arrays;

public class Heap {
    /*
    Explanation #
This code covers all the cases that we discussed in the previous chapter. Let’s look at each function one by one and see what’s going on:

BuildHeap(): It takes the array and starts from the last child node at the last level, then passes it to MaxHeapify for comparison.

MaxHeapify(): This function takes the node value and compares it with the key at the parent node, and swaps them if the condition below stands true.

Child Node >= ParentNodeChildNode>=ParentNode

The while loop makes sure that the nodes keep swapping until the Heap property is satisfied, so we basically call MaxHeapify(); at each small level to achieve Max Heap.


If this Code had a Face #
1
4
7
12
15
2
3
16
14
9
Before Max-Heapify
1 of 18







Time Complexity #
The worst-case time complexity of maxHeapify() is O(lgn)O(lgn) because we start with the rightmost leaf node in the heap, then move left and then up until we reach the root node.

In buildMaxHeap(), the heapify function is called O(n)O(n) times. Therefore, the overall time complexity of building a Heap seems to be O(n(lgn))O(n(lgn)), but this is a very loose upper bound. A more accurate and tight upper-bound for the build heap operation is O(n)O(n). Let me explain how we can calculate this.

The heapify function has different time complexity at each level of the tree i.e it will be O(1)O(1) at the leaf node and O(lg(n))O(lg(n)) at the root. So, the worst-case time complexity of heapify at each node is O(h)O(h) where hh is the height of the node in the heap. The number of nodes for any binary given tree with height hh is given by \frac{n}{2^h + 1}
​2
​h
​​ +1
​
​n
​​ . According to these measures, the total complexity can be calculated by the following expression:

\sum_{h=0}^{log_n} \frac{n}{2^h + 1} O(h)
​h=0
​∑
​log
​n
​​
​​
​2
​h
​​ +1
​
​n
​​ O(h)

\Rightarrow O(n \times \sum_{h=0}^{log_n} \frac{h}{2^h + 1} )⇒O(n×
​h=0
​∑
​log
​n
​​
​​
​2
​h
​​ +1
​
​h
​​ )

When the above summation approaches \infty∞, it converges to 22. The expression thus becomes:

\Rightarrow O(n \times 2 )⇒O(n×2)

\Rightarrow O(n)⇒O(n)

Hence, the time complexity of building a heap is O(n)O(n)

You see, just with the help of two simple functions, we have implemented a whole data structure.

And now that we have covered Max Heap, implementing a Min Heap will not be a problem. So, that’s what we are going to study in the next lesson. See you!
     */

    private void maxHeapify(int[] heapArray, int index, int heapSize){
        int largest = index;
        while (largest < heapSize / 2){      // check parent nodes only
            int left = (2 * index) + 1;       //left child
            int right = (2 * index) + 2;      //right child

            if (left < heapSize && heapArray[left] > heapArray[index]){
                largest = left;
            }
            if (right < heapSize && heapArray[right] > heapArray[largest]){
                largest = right;
            }
            if (largest != index){ // swap parent with largest child
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;
            }
            else
                break; // if heap property is satisfied
        } //end of while
    }
    public void buildMaxHeap(int[] heapArray, int heapSize)
    {
        // swap largest child to parent node
        for (int i = (heapSize - 1) / 2; i >= 0; i--){
            maxHeapify(heapArray, i, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };

        System.out.println("Before heapify: "+Arrays.toString(heapArray));
        new Heap().buildMaxHeap(heapArray, heapArray.length);
        System.out.println("After heapify: "+ Arrays.toString(heapArray));
    }
}