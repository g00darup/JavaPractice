package leetcode.Trees;

import java.util.LinkedList;
import java.util.List;

public class Inorder {
    public static List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> list = new LinkedList<>();
                inorderTraversalHelper(root,list);
                return list;
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
        TreeNode root =  null;

        List<Integer> list=inorderTraversal(root);

        list.stream().forEach(e-> System.out.println(e));
    }

//    int test_case_number = 1;
//    void check(boolean expected, boolean output) {
//        boolean result = (expected == output);
//        char rightTick = '\u2713';
//        char wrongTick = '\u2717';
//        if (result) {
//            System.out.println(rightTick + " Test #" + test_case_number);
//        }
//        else {
//            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
//            System.out.print(expected);
//            System.out.print(" Your output: ");
//            System.out.print(output);
//            System.out.println();
//        }
//        test_case_number++;
//    }
//
//    public void run() {
//        int[] array_a_1 = {1, 2, 3, 4};
//        int[] array_b_1 = {1, 4, 3, 2};
//        boolean expected_1 = true;
//        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
//        check(expected_1, output_1);
//
//        int[] array_a_2 = {1, 2, 3, 4};
//        int[] array_b_2 = {1, 4, 3, 3};
//        boolean expected_2 = false;
//        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
//        check(expected_2, output_2);
//        // Add your own test cases here
//
//    }

}
