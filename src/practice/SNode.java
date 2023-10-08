package practice;

public class SNode {
    @Override
    public String toString() {
        return "SNode{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }

    SNode next = null;
    int data;

    public SNode(int d){data=d;}

    void appendToTail(int d){
        SNode end = new SNode(d);
        SNode n = this;
        while (n.next!=null){
            n = n.next;
        }
    }

    void displayNodes(SNode head){
        SNode n = head;
        while(n!=null) {
            System.out.println(n.toString());
            n=n.next;
        }
    }

    public static void main(String[] args) {
        SNode n1 = new SNode(1);
        SNode n2 = new SNode(2);
        SNode n3 = new SNode(3);
        n2.next = n3;
        n1.next = n2;
        n1.displayNodes(n1);
    }

}
