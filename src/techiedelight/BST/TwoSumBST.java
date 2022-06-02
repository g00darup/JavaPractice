package techiedelight.BST;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {
    Node root;
    class Node
    {
        int data;
        Node left = null, right = null;

        public Node(int data) {
            this.data = data;
        }

   }
    public void printPreorder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            if (root.left != null)
                printPreorder(root.left);
            if (root.right != null)
                printPreorder(root.right);
        }
    }

    public Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }

        // if the given key is less than the root node, recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        // if the given key is more than the root node, recur for the right subtree
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static boolean findPair(Node root, int sum, Set<Integer> set){
        if (root == null) {
            return false;
        }

        // return true if pair is found in the left subtree; otherwise, continue
        // processing the node
        if (findPair(root.left, sum, set)) {
            return true;
        }

        // if a pair is formed with the current node, print the pair and return true
        if (set.contains(sum - root.data))
        {
            System.out.print("Pair found (" + (sum - root.data) + ", "
                    + root.data + ")");
            return true;
        }

        // insert the current node's value into the set
        else {
            set.add(root.data);
        }

        // search in the right subtree
        return findPair(root.right, sum, set);
    }

    public static void main(String[] args)
    {
        TwoSumBST ts = new TwoSumBST();
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
        Node root = null;

        for (int key: keys) {
            root = ts.insert(root, key);
        }
        ts.printPreorder(root);
        // find pair with the given sum
        int sum = 28;

        // create an empty set
        Set<Integer> set = new HashSet<>();

        if (!findPair(root, sum,set)) {
            System.out.print("Pair does not exist");
        }
    }
}
