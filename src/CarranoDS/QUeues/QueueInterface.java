package CarranoDS.Queues;

public interface QueueInterface<T> {
    public void enqueue(T newEntry);

    public T deque();

    public T getFront();

    public boolean isEmpty();

    public void clear();
}
