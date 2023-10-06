package leetcode.easy.linkedlist;
/**
 * Definition for singly-linked list.*/
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode newNode = null;
        ListNode rest=null;
        if(head!=null && head.next!=null) {
            newNode = new ListNode(head.next.val);
            rest = head.next;
        }


        newHead.next = reverseList(rest);
        newHead.next = newNode;
        return newHead;


    }

    public static void main(String[] args) {
        ReverseLL reverseLL = new ReverseLL();
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        ListNode head = new ListNode();
        head.next = n1;

        ListNode rev = reverseLL.reverseList(head);
        System.out.println(rev);
    }
}


