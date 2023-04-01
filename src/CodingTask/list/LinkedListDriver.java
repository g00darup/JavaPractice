package CodingTask.list;

public class LinkedListDriver {
    public static void main(String[] args) {
        Node head = new Node("b",null);
        SLinkedList sLinkedList = new SLinkedList(head,1);
        Node newN = new Node ("a",null);
        sLinkedList.addFirstAlt(newN);

        Node moreHead =  new Node ("Start",null);
        sLinkedList.addFirstAlt(moreHead);

        Node moreHead2 =  new Node ("EOF",null);
        sLinkedList.addLastAlt(moreHead2);
        //sLinkedList= sLinkedList.remove(sLinkedList,moreHead2);
        //sLinkedList.removeFirstAlt();
        //SLinkedList s = new SLinkedList(n,sLinkedList.size);
        SLinkedList reversed = new SLinkedList();
        reversed=sLinkedList.reverse(sLinkedList);
        sLinkedList.printNode(reversed);
    }
}
