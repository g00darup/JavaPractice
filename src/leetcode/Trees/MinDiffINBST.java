package leetcode.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinDiffINBST {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        inorderTraversalHelper(root,list);

        for(int i=0;i<list.size();i++){
            if(i!=(list.size()-1)){
                res.add((list.get(i)-list.get(i+1)));
            }
        }

        Collections.sort(res);

        System.out.println(res.size());

        return res.get(0);

    }
    private static void inorderTraversalHelper(TreeNode root, List<Integer> list) {
        if(root!=null) {
            if(root.left!=null)
                inorderTraversalHelper(root.left, list);

            list.add(root.val);

            if(root.right!=null)
                inorderTraversalHelper(root.right, list);
        }
    }

    public static void main(String[] args) {
        //TreeNode root =  null;
        TreeNode root = new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                new TreeNode(15), new TreeNode(7)
        ));
        MinDiffINBST obj = new MinDiffINBST();
        int param_1 = obj.minDiffInBST(root);
        System.out.println(param_1);

    }
}
