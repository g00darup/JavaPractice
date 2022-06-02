package leetcode.easy;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1,s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        upload(s1, s2);
        int ret = s2.pop().intValue();
        upload(s2, s1);
        return ret;

    }

    private void upload(Stack<Integer> s1, Stack<Integer> s2) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
    }

    /** Get the front element. */
    public int peek() {
        upload(s1, s2);
        int ret = s2.peek();
        upload(s2, s1);
        return ret;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */