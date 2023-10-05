package leetcode.easy.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MyStack {
    Deque<Integer> inQ,outQ;
    /** Initialize your data structure here. */
    public MyStack() {
        inQ = new ArrayDeque<Integer>();
        outQ = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        if(!outQ.isEmpty()){
            while(!outQ.isEmpty()){
                inQ.offer(outQ.poll());
            }
                outQ.offer(x);
            while(!inQ.isEmpty()){
                outQ.offer(inQ.poll());
            }
        }
        if(outQ.isEmpty()) {
            inQ.offer(x);
            outQ.offer(inQ.poll());
        }

    }

    public int pop() {
        return outQ.poll();
    }

    public int top() {
        return outQ.peek();
    }

    public boolean empty() {
        return outQ.isEmpty();
    }

    public static void main(String[] args) {
        /**
         * Your MyStack object will be instantiated and called as such: */
         MyStack obj = new MyStack();
         obj.push(3);
         obj.push(5);
         int param_2 = obj.pop();
         int param_3 = obj.top();
         boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

