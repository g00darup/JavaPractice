package leetcode.Trees;

import java.util.HashMap;
import java.util.Map;

public class BSTIterator {
    Map<Integer,Integer> map = new HashMap();
    int count;
    void resetCount(){
        count=0;
    }
    public BSTIterator(TreeNode root) {
        map =new HashMap();
        count=0;
        helper(root,map);
        resetCount();
    }

    private void helper(TreeNode root, Map<Integer, Integer> map) {
        if(root!=null) {
            if(root.left!=null)
                helper(root.left, map);

            map.put(count,root.val);
            count++;

            if(root.right!=null)
                helper(root.right, map);
        }
    }

    public int next() {
        int val = map.get(count);
        count++;
        return val;
    }

    public boolean hasNext() {
        return map.containsKey(count);
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

//class BSTIterator {
//
//    ArrayList<Integer> nodesSorted;
//    int index;
//
//    public BSTIterator(TreeNode root) {
//
//        // Array containing all the nodes in the sorted order
//        this.nodesSorted = new ArrayList<Integer>();
//
//        // Pointer to the next smallest element in the BST
//        this.index = -1;
//
//        // Call to flatten the input binary search tree
//        this._inorder(root);
//    }
//
//    private void _inorder(TreeNode root) {
//
//        if (root == null) {
//            return;
//        }
//
//        this._inorder(root.left);
//        this.nodesSorted.add(root.val);
//        this._inorder(root.right);
//    }
//
//    /**
//     * @return the next smallest number
//     */
//    public int next() {
//        return this.nodesSorted.get(++this.index);
//    }
//
//    /**
//     * @return whether we have a next smallest number
//     */
//    public boolean hasNext() {
//        return this.index + 1 < this.nodesSorted.size();
//    }
//}