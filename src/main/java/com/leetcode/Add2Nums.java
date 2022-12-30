package main.java.com.leetcode;
/**
 * Definition for singly-linked list. */
class ListNode {
       int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Add2Nums {
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0,rev1=0, count=0;
        int num2 = 0,rev2=0;

        while(l1!=null) {
            num1 = num1 * 10 + l1.val;
            l1=l1.next;
        }

        while(l2!=null) {
            num2 = num2 * 10 + l2.val;
            l2=l2.next;
        }

       rev1 = reverse(num1);
        rev2 = reverse(num2);

        num1 = rev1 + rev2;
        num2 = num1;
        num1 = reverse(num2);

        ListNode n1=null,n2;

        num2 = num1;

        while (num2 != 0) {
            // num = num/10
            num2 /= 10;
            ++count;
        }

        int i=0;


        n1= new ListNode(num1%10);
        num1=num1/10;
        i=1;

        while (i<count){
            n2= new ListNode(num1%10);

            n1.next=n2;
            num1=num1/10;
            i++;
        }

        return n1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6, new ListNode(4)));
        ListNode l = (addTwoNumbers(l1,l2));

        while ((l!=null)){
            System.out.println(l.val);
            l=l.next;
        }

    }

    static public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            rev = rev*10 + x%10;
            x = x/10;
        }

        return rev;
    }
}
