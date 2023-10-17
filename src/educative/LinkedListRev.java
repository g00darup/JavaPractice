package educative;


public class LinkedListRev {
    private static class ListNode {
        int val;

        public void setNext(ListNode next) {
            this.next = next;
        }

        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
       LinkedListRev reverseLL = new LinkedListRev();
       ListNode n3 = new ListNode(3);
       ListNode n2 = new ListNode(2,n3);
       ListNode n1 = new ListNode(1,n2);


       ListNode rev = reverseLL.reverseList(n1);
       System.out.println(rev);
    }

    private ListNode reverseList(ListNode head) {
        ListNode first = new ListNode(head.val);
        ListNode rest = null;
        if(head!=null && head.next!=null){
            rest = head.next;
        }
        ListNode res = reverseList(rest);
        res.setNext(first);
        return res;
    }
}
