package geekforgeeks.LinkedList;

public class LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    public int findLength(){
        int len=0;
        Node curr = head;

        while (curr !=null){
            len++;
            curr = curr.next;
        }

        return len;
    }

    public void push(int newDt){
        Node newNode = new Node(newDt);
        newNode.next = head;
        head = newNode;
    }

    public static void deleteAtEnd(){
        if(head == null){
            return;
        }

        if(head.next == null){
            head = null;
            return;
        }
        Node curr = head;
        while (curr.next.next !=null){
            curr = curr.next;
        }
        curr.next = null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(1);
        linkedList.push(3);
        linkedList.push(4);
        System.out.println(linkedList.findLength());

    }

}
