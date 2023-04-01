package CodingTask.list;

public class DLinkedList {
    public DLinkedList(DNode header, DNode trailer, int size) {
        this.header = header;
        this.trailer = trailer;
        this.size = size;
    }

    protected DNode header,trailer;
    protected int size;

    public void printNode(DLinkedList src) {
        DNode curr = src.header;
        while(curr!=null){
            System.out.println(curr.element()+"--->");
            System.out.println("|||||||");
            curr = curr.getNext();
        }
    }
}
