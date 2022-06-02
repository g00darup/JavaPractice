package GrokkingCodingInterview.datastructure.Tree.bst;

import GrokkingCodingInterview.datastructure.Tree.Node;

public class bst {

    private Node root;

    public void insert(Node root, int data ){
        if(data> root.getData())
            insert(root.getRightChild(),data);
        else
            insert(root.getLeftChild(),data);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //Recursive function to insert a value in BST
    public Node recursive_insert(Node currentNode, int value) {

        //Base Case
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.getData()) {
            //Iterate left sub-tree
            currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            //Iterate right sub-tree
            currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
        } else {
            // value already exists
            return currentNode;
        }

        return currentNode;

    }

    //Iterative Function to insert a value in BST
    public boolean add(int value) {

        //If Tree is empty then insert Root with the given value inside Tree
        if (isEmpty()) {
            root = new Node(value);
            return true;
        }

        //Starting from root
        Node currentNode = root;

        //Traversing the tree untill valid position to insert the value
        while (currentNode != null) {

            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            //If the value to insert is less than root value then move to left subtree
            //else move to right subtree of root
            //and before moving check if the subtree is null, if it's then insert the value.
            if (currentNode.getData() > value) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            } //end of else
        } //end of while
        return false;
    }
    //Searches value in BST
    //Either returns the Node with that value or return null
    public Node search(int value) {

        if (isEmpty()) return null; // if tree is empty simply return null

        Node currentNode = this.root;

        while (currentNode != null) {

            if (currentNode.getData() == value) return currentNode; // compare data from current node

            if (currentNode.getData() > value) //if data from current node is greater than value
                currentNode = currentNode.getLeftChild(); // then move towards left subtree
            else
                currentNode = currentNode.getRightChild(); //else move towards right subtree
        }

        System.out.println(value + " Not found in the Tree!");
        return null;
    }

    //Recursive search function
    public Node searchRecursive(Node currentNode, int value){
        // if node is null or value is found then return node
        if (currentNode==null || currentNode.getData() == value)
            return currentNode;

        // if value is greater than node's data then search left sub-tree
        if (currentNode.getData() > value){
            return searchRecursive(currentNode.getLeftChild(), value);
        }
        else{
            // if value is less than node's data then search right sub-tree
            return searchRecursive(currentNode.getRightChild(), value);
        }
    }

    boolean delete(int value, Node currentNode) {

        if (root == null) {
            return false;
        }

        Node parent = null; //To Store parent of currentNode
        while(currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftChild();
            else
                currentNode = currentNode.getRightChild();

        }

        if(currentNode == null) {
            return false;
        }
        else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            //1. Node is Leaf Node
            //if that leaf node is the root (a tree with just root)
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(null);
                return true;
            }
            else{
                parent.setRightChild(null);
                return true;
            }
        } else if(currentNode.getRightChild() == null) {

            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getLeftChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            }
            else{

                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }

        }
        else if(currentNode.getLeftChild() == null) {

            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getRightChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            }
            else{
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }

        }
        else {
            //Find Least Value Node in right-subtree of current Node
            Node leastNode = findLeastNode(currentNode.getRightChild());
            //Set CurrentNode's Data to the least value in its right-subtree
            int temp = leastNode.getData();
            delete(temp, root);
            currentNode.setData(temp);
            //Delete the leafNode which had the least value
            return true;
        }

    }

    //Helper function to find least value node in right-subtree of currentNode
    private Node findLeastNode(Node currentNode) {

        Node temp = currentNode;

        while (temp.getLeftChild() != null) {
            temp = temp.getLeftChild();
        }

        return temp;

    }

    public static void preTraverse(Node root) {

        if (root == null) return;

        System.out.print(root.getData() + ",");
        preTraverse(root.getLeftChild());
        preTraverse(root.getRightChild());

    }

    public static void inTraverse(Node root) {

        if (root == null) return;

        inTraverse(root.getLeftChild());
        System.out.print(root.getData() + ",");
        inTraverse(root.getRightChild());

    }

    public static void postTraverse(Node root) {

        if (root == null) return;

        postTraverse(root.getLeftChild());
        postTraverse(root.getRightChild());
        System.out.print(root.getData() + ",");

    }

    //Function to check if Tree is empty or not
    public boolean isEmpty()
    {
        return root == null; //if root is null then it means Tree is empty
    }

    //Just for Testing purpose
    public void printTree(Node current)
    {
        if (current == null) return;

        System.out.println(current.getData() + ",");
        System.out.print(current.getData() + "\\");
        printTree(current.getLeftChild());
        System.out.print(current.getData() + "\\");
        printTree(current.getRightChild());

    }
    public static int findMin(Node root) {

        if (root == null)
            return -1;
        // In Binary Search Tree, all values in current node's left subtree are smaller
        // than the current node's value.
        // So keep traversing (in order) towards left till you reach leaf node, and then return leaf node's value
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root.getData();
    }
    static int  counter;
    public static int findKthMax2(Node root, int k) {
        counter = 0;
        Node node = findKthMaxRecursive(root, k);
        if(node != null)
            return node.getData();
        return -1;
    }
    public static Node findKthMaxRecursive(Node root, int k) {
        if(root==null){
            return null;
        }
        //Recursively reach the right-most node (which has the highest value)
        Node node = findKthMaxRecursive(root.getRightChild(), k);

        if(counter != k){
            //Increment counter if kth element is not found
            counter++;
            node = root;
        }
        //Base condition reached as kth largest is found
        if(counter == k){
            return node;
        }else{
            //Traverse left child if kth element is not reached
            return findKthMaxRecursive(root.getLeftChild(), k);
        }
    }
    public static int findKthMax(Node root, int k) {

        //Perform In-Order Traversal to get sorted array. (ascending order)
        //Return value at index [length - k]
        StringBuilder result = new StringBuilder(); //StringBuilder is mutable
        result = inOrderTraversal(root, result);

        String[] array = result.toString().split(","); //Spliting String into array of strings
        if ((array.length - k) >= 0) return Integer.parseInt(array[array.length - k]);

        return - 1;
    }
    public static StringBuilder inOrderTraversal(Node root, StringBuilder result) {

        if (root.getLeftChild() != null) inOrderTraversal(root.getLeftChild(), result);

        result.append(root.getData() + ",");

        if (root.getRightChild() != null) inOrderTraversal(root.getRightChild(), result);

        return result;
    }
    public static String findAncestors(Node root, int k) {

        String result = "";
        Node tempNode = root;
        while(tempNode != null && tempNode.getData() != k){
            result = result + tempNode.getData() + ",";
            if(k <= tempNode.getData()){
                tempNode = tempNode.getLeftChild();
            } else{
                tempNode = tempNode.getRightChild();
            }
        }
        if(tempNode == null){
            return "";
        }
        return result;
    }
    public static String findKNodes(Node root, int k) {

        StringBuilder result = new StringBuilder(); //StringBuilder is immutable
        result = findK(root, k, result);

        return result.toString();
    }

    //Helper recursive function to traverse tree and append all the nodes
    // at k distance into result StringBuilder
    public static StringBuilder findK(Node root, int k, StringBuilder result) {

        if (root == null) return null;

        if (k == 0) {
            result.append(root.getData() + ",");
        }
        else {
            //Decrement k at each step till you reach at the leaf node
            // or when k == 0 then append the Node's data into result string
            findK(root.getLeftChild(), k - 1, result);
            findK(root.getRightChild(), k - 1, result);
        }
        return result;
    }
    public static void main(String args[])
    {
        bst bsT = new bst();

        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

       // bsT.printTree(bsT.getRoot());

       // System.out.println(bst.findMin(bsT.root));

        System.out.println(findAncestors(bsT.getRoot(),10));
    }
}
