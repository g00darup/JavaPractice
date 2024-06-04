package crackingcodingint.Chap02LL;

public class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }

    //Just viewing from book and typing..also trying to understand in the process!
    void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;

        while(n.next !=null){
            n = n.next;
        }
        n.next = end;
    }

   static Node deleteNode(Node head, int d){
        Node n = head;
        if(n.data == d){
            return head.next;
        }
        while(n.next !=null){
            if(n.next.data ==d){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node n4 = new Node(4);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n1 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next =null;

        printList(n1);
        Node n = deleteNode(n1,2);
        System.out.println("*********************************************************************************************8");
        printList(n);
    }

    private static void printList(Node n1) {
        while(n1 !=null){
            System.out.println(n1.data);
            n1 = n1.next;
        }
    }
}
