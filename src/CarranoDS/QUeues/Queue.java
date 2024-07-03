package CarranoDS.QUeues;

import CarranoDS.ADTList.Linked.Node;

public class  Queue<T> implements CarranoDS.QUeues.QueueInterface<T> {

    private CarranoDS.ADTList.Linked.Node firstNode;
    private CarranoDS.ADTList.Linked.Node lastNode;

    public Queue(Node firstNode, Node lastNode) {
        this.firstNode = firstNode;
        this.lastNode = lastNode;
    }

    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry,null);
        if(isEmpty())
            firstNode = newNode;
        else
            lastNode.next = newNode;
    }

    @Override
    public T deque() {
        T front = null;
        if(!isEmpty()) {
            front = (T) firstNode.data;
            firstNode = firstNode.next;
            if(firstNode==null)
                lastNode = null;
        }
        return front;
    }

    @Override
    public T getFront() {
        T front = null;
        if(!isEmpty())
            front = (T) firstNode.data;
        return front;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
