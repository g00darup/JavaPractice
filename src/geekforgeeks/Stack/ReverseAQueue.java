package geekforgeeks.Stack;

import java.util.ArrayDeque;

public class ReverseAQueue {
    static ArrayDeque<Integer> queue;
    static class Stack{
        ArrayDeque<Integer> stack = new ArrayDeque();

        public void pop(){
            if(stack.isEmpty()) {
                System.out.println("Stack is empty");
            }else{
                stack.pollLast();
            }
        }

        public Integer peek(){
            return stack.peek();
        }

        public void push(int data){
            stack.push(data);
        }

        boolean isEmpty(){
            return stack.isEmpty();
        }
    }

    static ArrayDeque reverse(ArrayDeque<Integer> queue){
        Stack st = new Stack();

        while(!queue.isEmpty()){
            st.push(queue.peek());
            queue.remove();
        }

        while(!st.isEmpty()){
            queue.add(st.peek());
            st.pop();
        }

        return queue;
    }

    public static void main(String[] args) {
        queue = new ArrayDeque<>();
        queue.offer(8);
        queue.offer(9);
        queue.offer(10);

        ArrayDeque retQueu = reverse(queue);

        while(!retQueu.isEmpty()){
            System.out.println(retQueu.peek());
            retQueu.pollFirst();
        }
    }
}
