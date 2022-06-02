package General.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class BinaryTree<T> {
    protected TreeNode root;


    // Traverse tree
    public void traverseTree(TreeNode TreeNode) {
        if (TreeNode != null) {
            System.out.print(" " + TreeNode.key);
            traverseTree(TreeNode.left);
            traverseTree(TreeNode.right);
        }
    }

    List bfs(TreeNode root){
        List arr = new ArrayList<>();
        if(root==null)
            return null;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();
            arr.add(cur.key);
            //queue.remove(cur);
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
            //queue.remove(cur);

        }

        return arr;
    }
    public static void main(String[] args) {

        // create an object of BinaryTree
        BinaryTree tree = new BinaryTree();
        // create nodes of the tree
        tree.createTree(tree);
        System.out.print("\nBinary Tree: ");
        //tree.traverseTree(tree.root);
        tree.bfs(tree.root).stream().forEach(e-> System.out.println(e));
        //tree.printPreorder(tree.root);
    }

    private void createTree(BinaryTree tree) {
        tree.root = new TreeNode(15);
        tree.root.left = new TreeNode(9);
        tree.root.left.left = new TreeNode(8);
        tree.root.left.right = new TreeNode(6);
        tree.root.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(3);
        tree.root.right.right = new TreeNode(2);
        tree.root.right.left.left = new TreeNode(1);
    }
    public void printPreorder(TreeNode root) {
        if(root!=null) {
            System.out.println(root.key);
            if (root.left != null)
                printPreorder(root.left);
            if (root.right != null)
                printPreorder(root.right);
        }
    }

    class TreeNode {
        public int key;
        public TreeNode left, right;

        public TreeNode(int item) {
            key = item;
            left = right = null;
        }
    }

}