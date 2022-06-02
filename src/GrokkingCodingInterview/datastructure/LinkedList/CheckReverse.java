package GrokkingCodingInterview.datastructure.LinkedList;

public class CheckReverse {
    public static <T> void reverse1(SinglyLinkedList<T> list){
        SinglyLinkedList newList = new SinglyLinkedList();

        if(list!=null && list.size==1)
            return;

        SinglyLinkedList.Node curr = newList.headNode;

        while(curr!=null){
            newList.insertAtEnd(curr.data);
            curr = curr.nextNode;
        }


        list = newList;

    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0; i < 15; i+=2)
            list.insertAtEnd(i);
        System.out.print("Before ");
        list.printList();
        reverse(list);
        System.out.print("After ");
        list.printList();
    }
    public static <T> void reverse(SinglyLinkedList<T> list){
        SinglyLinkedList<T>.Node previous = null; //To keep track of the previous element, will be used in swapping links
        SinglyLinkedList<T>.Node current = list.headNode; //firstElement
        SinglyLinkedList<T>.Node next = null;

        //While Traversing the list, swap links
        while (current != null) {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }
        //Linking Head Node with the new First Element
        list.headNode = previous;
    }
}
