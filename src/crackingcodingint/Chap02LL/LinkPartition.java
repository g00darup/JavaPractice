package crackingcodingint.Chap02LL;

public class LinkPartition {
    static LinkedListNode partition(LinkedListNode node,int x){
        LinkedListNode beforeSt = null;
        LinkedListNode beforeEn = null;
        LinkedListNode afterSt = null;
        LinkedListNode afterEn = null;

        while(node!=null) {
            LinkedListNode next = node.next;
            node.next=null;
            if(node.data < x){
                if(beforeSt == null){
                    beforeSt = node;
                    beforeEn = beforeSt;
                }else{
                    beforeEn.next = node;
                    beforeEn = node;
                }
            }else{
                if(afterSt==null){
                    afterSt = node;
                    afterEn = afterSt;
                }else {
                    afterEn.next=node;
                    afterEn = node;
                }
                node = next;
            }
        }
        if(beforeSt ==null){
            return afterSt;
        }
        beforeEn.next = afterSt;
        return beforeSt;
    }

    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(3);
        LinkedListNode n2 = new LinkedListNode(5);
        LinkedListNode n3 = new LinkedListNode(8);
        LinkedListNode n4 = new LinkedListNode(5);
        LinkedListNode n5 = new LinkedListNode(10);
        LinkedListNode n6 = new LinkedListNode(2);
        LinkedListNode n7 = new LinkedListNode(1);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=null;

        LinkedListNode out = partition(n1,5);
    }

    LinkedListNode partition2(LinkedListNode node,int x){
        LinkedListNode head = node;
        LinkedListNode tail = node;
        while (node!=null){
            LinkedListNode next = node.next;
            if(node.data<x){
                node.next = head;
                head = node;
            }else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
        if(l1==null && l2==null && carry==0){
            return null;
        }
        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if(l1!=null){
            value+=l1.data;
        }
        if(l2!=null){
            value+=l2.data;
        }
        result.data = value%10;
        if(l1!=null || l2!=null){
            LinkedListNode m = addLists(l1==null?null:l1.next,
                    l2==null?null:l2.next,
                    value>=10?1:0);
            result.next=m;
        }
        return result;
    }
}
