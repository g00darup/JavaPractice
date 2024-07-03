package crackingcodingint.Chap03;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;
        public QueueNode(T data){
            this.data = data;
        }
    }
    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item){
        QueueNode it  = new QueueNode(item);

        if(last!=null)
            last.next = it;

        last = it;

        if(first == null){
            first = last;
        }
    }

    public void remove() {
        if(first!=null){
            first = first.next;
        }

        if(first==null){
            last = null;
            throw new NoSuchElementException();
        }

        if(last==null){
            last = first;
        }
    }

    public boolean isEmpty(){
        return first==null;
    }

    T peek(){
        if(!isEmpty()){
            return first.data;
        }else{
            throw new NoSuchElementException();
        }
    }

}
