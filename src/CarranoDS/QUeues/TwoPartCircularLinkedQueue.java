package CarranoDS.QUeues;

import java.io.Serializable;

public class TwoPartCircularLinkedQueue<T> implements QueueInterface<T>, Serializable {
    public TwoPartCircularLinkedQueue(Node queueNode, Node freeNode) {
        this.queueNode = queueNode;
        this.freeNode = freeNode;
    }

    public TwoPartCircularLinkedQueue() {
        freeNode = new Node(null, null);
        freeNode.setNext(getFreeNode());
        queueNode = freeNode;
    }

    public Node getQueueNode() {
        return queueNode;
    }

    public void setQueueNode(Node queueNode) {
        this.queueNode = queueNode;
    }

    public Node getFreeNode() {
        return freeNode;
    }

    public void setFreeNode(Node freeNode) {
        this.freeNode = freeNode;
    }

    private Node queueNode;
    private Node freeNode;

    @Override
    public void enqueue(T newEntry) {
    freeNode.setData(newEntry);
    if(isChainFull()){
        Node newNode = new Node(null, freeNode.getNext());
        freeNode.setNext(newNode);
    }
    }

    @Override
    public T deque() {
        return null;
    }

    @Override
    public T getFront() {
        T front = null;
        if(!isEmpty()){
            front = queueNode.getData();
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return queueNode==freeNode;
    }

    @Override
    public void clear() {

    }

    public boolean isChainFull() {
        return queueNode == freeNode.getNext();
    }

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
}
