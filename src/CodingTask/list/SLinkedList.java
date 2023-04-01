package CodingTask.list;

public class SLinkedList {
    public SLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    protected Node head;
    protected int size;

    public SLinkedList() {

    }

    Node addFirst(Node newLink){
        if(newLink!=null) {
            newLink.setNext(this.head);
            size++;
            this.head=newLink;
        }
        return newLink;
    }

    SLinkedList addFirstAlt(Node newLink){
        if(newLink!=null) {
            newLink.setNext(this.head);
            size++;
            this.head=newLink;
        }
        return this;
    }

    SLinkedList reverse(SLinkedList goal){
        Node first = null;
        Node rest = null;
        SLinkedList restList = new SLinkedList();
        if(goal.head!=null)
            first = new Node(goal.head.getElement(), null);
        if(goal.head!=null)
            rest = goal.head.getNext();
        if(rest!=null)
            restList = new SLinkedList(rest, goal.size-1);
        int count = 1;
        while (count<size){
            restList = reverse(restList).addFirstAlt(first);
            count++;
        }
        return restList;
    }

    public Node addLast(Node newLink){
        Node tail = this.head;
        if(tail!=null) {
            while(tail.next!=null) {
                tail = tail.next;
            }
        }
        tail.next=newLink;
        size++;
        return head;
    }
    public SLinkedList addLastAlt(Node newLink){
        Node tail = this.head;
        if(head!=null) {
            while(tail.next!=null) {
                tail = tail.next;
            }
        }
        tail.next=newLink;
        size++;
        return this;
    }
    public Node removeFirst(Node head){
        Node rest = head.getNext();
        head.next=null;
        return rest;
    }
    public SLinkedList removeFirstAlt(){
        Node t = head;
        head = head.next;
        t.next = null;
        size--;
        return this;
    }
//    public SLinkedList remove(SLinkedList src, Node del){
//        Node curr = src.head;
//        while (curr!=null){
//            if(curr.getElement().equalsIgnoreCase(del.getElement())){
//                curr=curr.getNext();
//            }
//            if(curr!=null)
//                curr=curr.getNext();
//        }
//        return src;
//    }

    public void printNode(SLinkedList src) {
        while(src.head!=null){
            System.out.println(src.head.element+"--->");
            System.out.println("|||||||");
            src.head=src.head.next;
        }
    }
}
