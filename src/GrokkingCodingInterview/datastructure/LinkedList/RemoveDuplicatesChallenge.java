package GrokkingCodingInterview.datastructure.LinkedList;

public class RemoveDuplicatesChallenge {
    public static <T> void removeDuplicates2(SinglyLinkedList<T> list) {
        SinglyLinkedList.Node curr = list.headNode;
        SinglyLinkedList.Node runner = list.headNode;




        while(curr!=null && curr.nextNode != null){
            //
            while(runner!=null && runner.nextNode != null){
                if (curr.data.equals(runner.nextNode.data)) { //check if duplicate
                    runner.nextNode = runner.nextNode.nextNode;
                } else {
                    runner = runner.nextNode;
                }
            }
            curr = curr.nextNode;
        }
    }

    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node current = list.headNode; // will be used for outer loop
        SinglyLinkedList<T>.Node compare = null;     // will be used for inner loop

        while (current != null && current.nextNode != null) {
            compare = current;
            while (compare.nextNode != null) {
                if (current.data.equals(compare.nextNode.data)) { //check if duplicate
                    compare.nextNode = compare.nextNode.nextNode;
                } else {
                    compare = compare.nextNode;
                }
            }
            current = current.nextNode;
        }
    }
    public static void main( String args[] ) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for(int i = 0; i < 9; i++)
            list.insertAtEnd(i);
        list.insertAtEnd(0);
        list.insertAtEnd(1);
        System.out.print("Before ");
        list.printList();
        removeDuplicates(list);
        System.out.print("After ");
        list.printList();

    }
}