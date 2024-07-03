package CarranoDS.QUeues;

public class ArrayQueue<T> implements CarranoDS.QUeues.QueueInterface<T> {
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        queue= (T[]) new Object[initialCapacity+1];
        frontIndex = 0;
        backIndex = initialCapacity;
    }

    @Override
    public void enqueue(T newEntry) {
        if(isArrayFull()) {
            doubleArray();
        }
         backIndex = (backIndex+1)% queue.length;
         queue[backIndex] = newEntry;
    }

    private void doubleArray() {
    }

    private boolean isArrayFull() {
        return frontIndex == ((backIndex+2)% queue.length);
    }

    @Override
    public T deque() {
        T front = null;
        if(!isEmpty()) {
            front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex+1)% queue.length;
        }
        return front;
    }

    @Override
    public T getFront() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex+1)% queue.length);
    }

    @Override
    public void clear() {

    }
}
