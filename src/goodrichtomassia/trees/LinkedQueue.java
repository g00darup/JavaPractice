package goodrichtomassia.trees;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class LinkedQueue<E> implements Queue<E> {

    /** The primary storage for elements of the queue */
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty  list

    /** Constructs an initially empty queue. */
    public LinkedQueue() { }                  // new queue relies on the initially empty list

    /**
     * Returns the number of elements in the queue.
     * @return number of elements in the queue
     */
    @Override
    public int size() { return list.size(); }

    /**
     * Tests whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() { return list.isEmpty(); }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Inserts an element at the rear of the queue.
     * @param element  the element to be inserted
     */

    public void enqueue(E element) { list.addLast(element); }

    /**
     * Returns, but does not remove, the first element of the queue.
     * @return the first element of the queue (or null if empty)
     */
//    @Override
//    public E first() { return list.first(); }

    /**
     * Removes and returns the first element of the queue.
     * @return element removed (or null if empty)
     */
//    @Override
//    public E dequeue() { return list.removeFirst(); }

    /** Produces a string representation of the contents of the queue.
     *  (from front to back). This exists for debugging purposes only.
     */
    public String toString() {
        return list.toString();
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}