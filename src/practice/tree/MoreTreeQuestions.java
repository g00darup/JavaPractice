package practice.tree;

import practice.Node;

public class MoreTreeQuestions {

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        // Let us create a binary tree shown in above diagram
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        while (tree.root != null) {
            System.out.println(tree.root.left);
            System.out.println("Height of tree is " +
                    tree.root);
            System.out.println(tree.root.right);
        }

    }

    boolean isBalanced(BinaryTree tree){
        int leftHeight=0;
        int rightHeight=0;
        while(tree.root.left!=null ||
                tree.root.right!=null){
            if(tree.root.left!=null){
                leftHeight ++;
                tree.root = tree.root.left;
                if(leftHeight>1)
                    return false;
            }
            if(tree.root.right!=null){
                rightHeight ++;
                tree.root = tree.root.left;
                if(rightHeight>1)
                    return false;
            }
        }
        return false;
    }
}
