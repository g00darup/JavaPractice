package CodingTask.list;

public class Node {
    public Node(String element, Node next) {
        this.element = element;
        this.next = next;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    String element;
    Node next;
}
