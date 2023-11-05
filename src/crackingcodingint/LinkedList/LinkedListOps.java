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
}
