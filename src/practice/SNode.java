package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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

    SNode removeDups(SNode head){
        HashSet<Integer> set = new HashSet<>();
        while(head!=null){
            set.add(head.data);
            set.add(head.data);
            head = head.next;
        }

        head = null;
        SNode node = null;
        int cnt = 1;
        Iterator iter = set.iterator();
        while(iter.hasNext())
        if(cnt<=1){
            head = new SNode((int)iter.next());
            cnt++;
        }else{
            node = new SNode((int)iter.next());
            head.next = node;
            node.next = null;
            cnt++;
        }
        return head;

    }

    public static void main(String[] args) {
        SNode n1 = new SNode(1);
        SNode n2 = new SNode(2);
        SNode n3 = new SNode(3);
        SNode n4 = new SNode(2);
        SNode n5 = new SNode(3);

        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        //n1.displayNodes(n1);
        SNode node = new SNode(-1);
        node = node.removeDups(n1);
        node.displayNodes(node);

    }

}
