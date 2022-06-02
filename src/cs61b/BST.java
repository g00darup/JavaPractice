package cs61b;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<T> {

    BSTNode<T> root;

    public BST(LinkedList<T> list) {
        root = sortedQueueToTree(list, list.size());
    }
    //remove comment directly at github
    /* Returns the root node of a BST (Binary Search Tree) built from the given
       Queue Q  of N items. Q will output the items in sorted order,
       and Q will contain objects that will be the item of each BSTNode. */
    private BSTNode<T> sortedQueueToTree(Queue<T> Q, int N) {
        // TODO: YOUR CODE HERE
        root.item=Q.element();
        Q.remove();
        root.left=sortedQueueToTree(Q,N-1);
        root.left=sortedQueueToTree(Q,N-2);
        // HINT: Remember to pass the same Queue to recursive calls, to
        //			take advantage of the fact that it is sorted.
        return null;
    }

    public static void main(String[] args) {

        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
        LinkedList linkedList = new LinkedList(Arrays.asList(keys));
        BST bst = new BST(linkedList);
        //bst.print(bst);
        bst.print();
    }

    /* Prints the tree represented by ROOT. */
    private void print() {
        print(root, 0);
    }

    private void print(BSTNode<T> node, int d) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < d; i++) {
            System.out.print("  ");
        }
        System.out.println(node.item);
        print(node.left, d + 1);
        print(node.right, d + 1);
    }

    class BSTNode<T> {
        T item;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T item) {
            this.item = item;
        }
    }
}
