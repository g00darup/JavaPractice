package crackingcodingint.Chap02LL;

import java.util.HashSet;

public class LinkedListNode {
    LinkedListNode next = null;
    int data;

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }

    public LinkedListNode(int data) {
        this.data = data;
    }
    public LinkedListNode() {
        this.data = data;
    }

    //buggy version
    static LinkedListNode deleteDuplicateBuggy(LinkedListNode node){
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode head = node;
        while(head!=null){
            if(head.next!=null){
                if(set.contains(head.data)){
                    head = head.next;
                }else {
                    set.add(head.data);
                }
            }
            head = head.next;
        }
        return node;
    }
    // Corrected version
    static void deleteDuplicate(LinkedListNode node) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        LinkedListNode current = node;

        while (current != null) {
            if (set.contains(current.data)) {
                // Remove current node
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }

    }

    public static LinkedListNode kthLastElement(LinkedListNode node,int k){
        int count = 0;
        LinkedListNode n = null;
        LinkedListNode copy = node;
        while(copy!=null){
            count++;
            copy = copy.next;
        }

        for(int i=0;i<(count-k);i++){
            node = node.next;
        }

        if(node!=null)
            n = new LinkedListNode(node.data);

        return n;
    }
    public static void main(String[] args) {
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n1 = new LinkedListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next =null;

        printList(n1);
        LinkedListNode n = kthLastElement(n1,3);
        // deleteDuplicate(n1);

        System.out.println("*********************************************************************************************8");
        System.out.println(n.data);
    }

    private static void printList(LinkedListNode n1) {
        while(n1 !=null){
            System.out.println(n1.data);
            n1 = n1.next;
        }
    }
}
