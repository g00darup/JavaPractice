package leetcode.easy.arrays;

import java.util.*;

public class Add2ArrayFormOfInt {
    public static void main(String[] args) {

        int [] A = {9,3};
        int K = 636;

        List out = addToArrayForm(A,K);

        out.forEach(e-> System.out.println(e));

    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        Stack<Integer> stack = new Stack();
        Deque<Integer> updatedDeck = new LinkedList<>();
        int carry = 0;
        for (int num : A) {
            stack.add(num);
        }
        if(A.length<Math.log10(K)){
            int indx;
                while (K != 0) {
                    if(!stack.isEmpty())
                        indx = (stack.pop() + K % 10 + carry);
                    else
                        indx = ( K % 10 + carry);

                    if (indx >= 10)
                        carry = 1;
                    else
                        carry = 0;

                    updatedDeck.add(indx % 10);
                    K = K / 10;

                }

        }else {
            while (K != 0) {
                int indx = (stack.pop() + K % 10 + carry);
                if (indx >= 10)
                    carry = 1;
                else
                    carry = 0;

                updatedDeck.add(indx % 10);
                K = K / 10;
            }
            while (!stack.isEmpty()) {
                int indx = (stack.pop() + K % 10 + carry);
                if (indx >= 10)
                    carry = 1;
                else
                    carry = 0;

                updatedDeck.add(indx % 10);
            }

        }

        if (carry == 1) {
            updatedDeck.addLast(carry);
        }

        while (!updatedDeck.isEmpty()) {
            stack.add(updatedDeck.peek());
            updatedDeck.remove();
        }
        while (!stack.isEmpty()) {
            updatedDeck.add(stack.peek());
            stack.pop();
        }

        return (List)updatedDeck;


    }

}
