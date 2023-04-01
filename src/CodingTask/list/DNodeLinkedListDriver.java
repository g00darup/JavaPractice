package CodingTask.list;

public class DNodeLinkedListDriver {
    public static void main(String[] args) {
        DNode first = new DNode(null,null,"a");
        DNode second = new DNode(null,null,"b");
        first.setNext(second);
        second.setPrev(first);
        DLinkedList dl = new DLinkedList(first,second,2);
        dl.printNode(dl);
    }
}
