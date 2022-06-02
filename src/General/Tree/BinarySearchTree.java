package General.Tree;

import CarranoDS.Trees.BinaryNode;

/* Creates an empty BST. */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    /* Creates an empty BST. */
    private TreeNode root;
    private int size;

    /* Creates an empty BST. */
    public BinarySearchTree() {
        this(null);
        size = 0;
    }

    /* Creates a BST with root as ROOT. */
    public BinarySearchTree(TreeNode root) {
        this.root = root;
        size = 1;
    }

    /* Returns true if the BST contains the given KEY. */
    public boolean contains(int key) {
        if(key == -99){
            return false;
        }
        return get(key) != -99;
    }

    private int get(int key) {
        return get(root,key);
    }

    private int get(TreeNode cur,int key) {
        if(cur == null) {
            return -99;
        }
        int c = new Integer(key).compareTo(new Integer(cur.key));
        if(c < 0) {
            return get(cur.left, key);
        }else if(c > 0) {
            return get( cur.right, key);
        }else {
            return cur.key;
        }
    }

//    boolean isEmpty(){
//        return size() == 0;
//    }
//
//    public int size(){
//        return size(root);
//    }
//
//    private int size(TreeNode root) {
//        if(root == null) return 0;
//        else return root.size;
//    }

    /* Adds a node for KEY iff KEY isn't in the BST already. */
    public void add(int key) {
        // TODO: YOUR CODE HERE
        if(this.root==null){
            root = new TreeNode(key);
        }else{
            if(key <= root.key)
                add(root.left,key);
            else
                add(root.right,key);
        }
    }

    private TreeNode add(TreeNode node, int key) {

        if (node == null) {
            return new TreeNode(key);
        }

        // if the given key is less than the root node, recur for the left subtree
        if (key < node.key) {
            node.left = add(node.left, key);
        }

        // if the given key is more than the root node, recur for the right subtree
        else {
            node.right = add(node.right, key);
        }

        return node;
    }

    /* Deletes a node from the BST. */
    public T delete(T key) {
        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        for (int key: keys) {
            bst.add(key);
        }

        bst.printPreorder(bst.root);
    }

}
