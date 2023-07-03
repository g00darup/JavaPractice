package CarranoDS.ADTList.Linked;

public class Node<T> {
    public T data;
    public Node next;

    public Node(T dataPortion){
        data = dataPortion;
        next = null;
    }

    public Node(T dataPortion, Node<T> nextNode){
        data = dataPortion;
        next = nextNode;
    }

}
