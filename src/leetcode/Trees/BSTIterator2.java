package leetcode.Trees;

import java.util.Stack;

class BSTIterator2 {

    Stack<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        // Stack for the recursion simulation
        this.stack = new Stack<TreeNode>();
        // Remember that the algorithm starts with a call to the helper function with the root node as the input
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {
        // For a given node, add all the elements in the leftmost branch of the tree// under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }
    /**
     * @return the next smallest number
     */
    public int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = this.stack.pop();
        // Need to maintain the invariant. If the node has a right child, call the// helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }
        return topmostNode.val;
    }
    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }

    public static void main(String[] args) {
        //TreeNode root =  null;
        TreeNode root = new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                new TreeNode(15), new TreeNode(7)
        ));
        BSTIterator obj = new BSTIterator(root);
        int param_1 = obj.next();
        boolean param_2 = obj.hasNext();
        System.out.println(param_1);
        System.out.println(param_2);
    }
}