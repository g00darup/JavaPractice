package crackingcodingint.Chap03;

import java.util.EmptyStackException;

public class Stack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;
        public StackNode(T data){
            this.data = data;
        }
    }
    private StackNode<T> top;

    public T pop() {
        if(top==null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }
    public void push(T item){
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }
    public T peek(){
        if(top==null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);

        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }

}
