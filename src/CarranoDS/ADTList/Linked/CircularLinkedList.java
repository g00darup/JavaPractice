package CarranoDS.ADTList.Linked;

public class CircularLinkedList<T> {
    private Node firstNode;

    public CircularLinkedList(Node firstNode, Node tailSentinel, int length) {
        this.firstNode = firstNode;
        this.tailSentinel = tailSentinel;
        this.length = length;
    }

    public CircularLinkedList(Node firstNode) {
        this.firstNode = firstNode;
        this.tailSentinel = firstNode;
        this.length = 0;
    }

    public CircularLinkedList() {
        this.firstNode = null;
        this.tailSentinel = null;
        this.length = 0;
    }

    private Node tailSentinel;

    public int getLength() {
        return length;
    }

    private int length;

    private Node getNodeAt(int givenPosition){
        assert !isEmpty() && (1<= givenPosition) && (givenPosition<=length);
        Node currentNode = firstNode;

        for(int count=1;count< givenPosition; count++){
            currentNode = currentNode.next;
        }
        assert currentNode!=null;

        return currentNode;
    }

    public boolean isEmpty(){
        boolean result;
        if(length==0){
            assert firstNode == null;
            result = true;
        }else{
            assert firstNode!=null && tailSentinel!=null;
            result = false;
        }
        return result;
    }

    public boolean add(T newEntry){
        Node newNode = new Node(newEntry);

        if(isEmpty()) {
            firstNode = newNode;
            tailSentinel = firstNode;
        }
        else
        {
            Node lastNode = getNodeAt(length);
            lastNode.next = newNode;
            newNode.next = firstNode;
        }
        length++;
        return true;
    }


}
