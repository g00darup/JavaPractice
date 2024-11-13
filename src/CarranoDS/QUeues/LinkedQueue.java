package CarranoDS.QUeues;

import java.io.Serializable;

public class LinkedQueue<T> implements QueueInterface<T>, Serializable {
    private class Node implements Serializable {
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        private T data;
        private Node next;
    }

    private Node firstNode;
    private Node lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);
        if(isEmpty())
            firstNode = newNode;
        else
            lastNode.setNext(newNode);
        lastNode = newNode;
    }

    @Override
    public T deque() {
        T front = null;
        if(!isEmpty()){
            front = firstNode.getData();
            firstNode = firstNode.getNext();
        }
        if(firstNode==null)
            lastNode=null;
        return front;

    }

    @Override
    public T getFront() {
        return firstNode.getData() ;
    }

    @Override
    public boolean isEmpty() {
        return (firstNode==null && lastNode==null);
    }

    @Override
    public void clear() {

    }
}
