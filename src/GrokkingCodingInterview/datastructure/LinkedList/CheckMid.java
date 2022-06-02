package GrokkingCodingInterview.datastructure.LinkedList;

class CheckMid {

    public static <T> Object findMiddle2(SinglyLinkedList<T> list) {
        // Write -- Your -- Codeif(
        if(list.size==1)
            return list.headNode.data;

        SinglyLinkedList.Node sizer =list.headNode;

        int count=0;
        int size =0;

        while (sizer!=null){
            size++;
            sizer = sizer.nextNode;
        }

        SinglyLinkedList.Node curr =list.headNode;

        while (count<size/2){
            curr = curr.nextNode;
        }

        return curr.data;
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);

        list.insertAtEnd(123);
        list.insertAtEnd(101);
        list.insertAtEnd(61);
        list.printList();
        System.out.println("Middle element is : " + findMiddle(list));
    }
    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        //if list is empty, then return null
        if (list.isEmpty())
            return null;

        //both nodes start from the head
        SinglyLinkedList.Node mid = list.headNode;
        SinglyLinkedList.Node current = list.headNode;

        while(mid != null && current != null && current.nextNode != null)
        {
            //current jumps 2 nodes on each iteration
            current = current.nextNode.nextNode;
            //if current is not null (end of list is not reached)
            if(current != null){
                //then mid jumps 1 node
                //mid is always halfway behind current
                mid = mid.nextNode;
            }
        }
        return mid.data;
    }
}
