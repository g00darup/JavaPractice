package crackingcodingint.Chap03;

import java.util.Comparator;
import java.util.EmptyStackException;

public class MinElementStack<T> {
    private class StackNode<U> implements Comparator<U> {
        private T data;
        private StackNode<T> next;
        public StackNode(T data){
            this.data = data;
        }

        @Override
        public int compare(U o1, U o2) {
            String t1 = o1.toString();
            String t2 = o2.toString();
            return t1.compareTo(t2);
        }
    }
    private StackNode<T> top;
    private T min;
    private MinElementStack<T> minStack;

    public T pop() {
        if(top==null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        if(minStack!=null && !minStack.isEmpty() && minStack.peek()==item)
            minStack.pop();
        return item;
    }
    public void push(T item){
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        if(minStack.isEmpty()){
            minStack.push(item);
        }else{
            min = minStack.peek();
            if(t.compare(item,min)>0){
                minStack.pop();
                minStack.push(item);
                minStack.push(min);
            }else if(t.compare(item,min)<0){
                minStack.push(item);
            }else{
                minStack.push(item);
            }
        }
    }
    public T peek(){
        if(top==null) throw new EmptyStackException();
        return top.data;
    }

    public T min(){
        if(!minStack.isEmpty())
            return minStack.peek();
        else
            return null;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
