package crackingcodingint.LinkedList;

import java.util.HashSet;

class LinkedListNode {
    int val;
    LinkedListNode next;
    LinkedListNode() {}
    LinkedListNode(int val) { this.val = val; }
    LinkedListNode(int val, LinkedListNode next) { this.val = val; this.next = next; }
}

public class LinkedListOps {
    //Taken directly from cracking coding interview book
    void deleteDups(LinkedListNode n){
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode prev = null;

        while (n!=null){
            if(set.contains(n.val)){
                prev.next = n.next;
            }else{
                set.add(n.val);
                prev = n;
            }
            n = n.next;
        }
    }

    void delDupsNoBuffer(LinkedListNode node){
        LinkedListNode curr = node;
        while(curr!=null){
            LinkedListNode runner = curr;
            while(runner.next!=null){
                if(runner.next.val == curr.val){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
                curr = curr.next;
            }
        }

    }
    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2){
        int len1 = length(l1);
        int len2 = length(l2);

        if(len1<len2){
            l1 = padList(l1, len2-len1);
            l2 = padList(l2, len2-len1);
        }
        LinkedListNode res = addListHelper(l1,l2,0);

        return res;
    }

    private LinkedListNode addListHelper(LinkedListNode l1, LinkedListNode l2,int carry) {
        if(l1==null && l2==null){
            return null;
        }

        LinkedListNode sum = addListHelper(l1.next,l2.next,carry);
        int val = carry + l1.val+ l2.val;
        LinkedListNode full_res = insertBefore(sum,val%10);
        sum = full_res;
        carry = val%10;

        return sum;
    }

    private LinkedListNode padList(LinkedListNode l1, int padding) {
        LinkedListNode head = l1;
        for (int i =0;i<padding;i++){
            head = insertBefore(head,0);
        }
        return head;
    }

    private LinkedListNode insertBefore(LinkedListNode head, int i) {
        LinkedListNode node = new LinkedListNode(i);
        if(head!=null){
            node.next = head;
        }
        return node;
    }

    private int length(LinkedListNode l1) {
        //assume this method exists, believe in tooth fairy!! ok bit lazy here eh!
        //This is the best example, how code comments should not be -- avoid humour, be precise
        return 1;
    }

}
