package main.java.com.wk127jan3592;

/**
 * Definition for singly-linked list.
 *  */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null ){

            if(l2==null) {
                return l2;
            }
            return l2;
        }

        if(l2==null){

            if(l1==null) {
                return l1;
            }
            return l1;
        }

        ListNode temp = l2;

        while(l1.next!=null){
            int l1NextVal  = l1.next.val;
            if(temp!=null && temp.val<=l1NextVal){
                ListNode newTemp = new ListNode(temp.val,l1.next);
                l1.next = newTemp;
                l1 = l1.next.next;

                temp = temp.next;
            }else{
                l1=l1.next;
            }
        }



        return l1;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2,n3);
        ListNode l1 =new ListNode(1,n2);

        ListNode l2 = new ListNode(1,n3);

        System.out.println(mergeTwoLists(l1,l2));

    }
}