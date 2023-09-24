package CarranoDS.Trees;

public class BinaryTree {

    Node root;

    public int getHeight(){
        return getHeight(root);
    }

    private int getHeight(Node tree){
        int ht=0;
        if(tree!=null){
            ht = 1+ Math.max(getHeight(tree.left),getHeight(tree.right));
        }
        return ht;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Create root
        tree.root = new Node(1);
        /* Following is the tree after above statement
           1
          / \
        null null
        */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        /* 2 and 3 become left and right children of 1
              1
             / \
            2   3
           / \ / \
       null null null null */
        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
               1
              / \
             2   3
            / \ / \
           4 null null null
          / \
        null null
        */
        traverse(tree.root);
    }

    public static void traverse(Node root){
        traverse(root.left);
        System.out.println(root.value);
        traverse(root.right);
    }
}
