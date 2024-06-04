package leetcode.easy.linkedlist;

import crackingcodingint.Chap02LL.LinkedListNode;

class MergeList2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null && list2==null) return list1;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode mergedList=new ListNode();
                if(list1!=null && list2!=null ) {
                    if (list1.val >= list2.val) {
                        mergedList = new ListNode(list2.val);
                        mergedListHelper(mergedList, list1, list2.next);
                    }else{
                        mergedList = new ListNode(list1.val);
                        mergedListHelper(mergedList, list1.next, list2);
                    }
                }
                return mergedList;
    }

    private ListNode mergedListHelper(ListNode mergedList, ListNode list1, ListNode list2) {
        if(list1!=null && list2!=null ) {
            if (list1.val >= list2.val) {
                mergedList.next = new ListNode(list2.val);
                mergedList = mergedList.next;
                return mergedListHelper(mergedList, list1, list2.next);
            }else if  (list1.val < list2.val){
                mergedList.next = new ListNode(list1.val);
                mergedList = mergedList.next;
                return mergedListHelper(mergedList, list1.next, list2);
            }
        }
        if(list1==null && list2!=null) {
            mergedList.next = list2;
            mergedList = mergedList.next;
            return mergedList;
        }
        else if(list2==null && list1!=null) {
            mergedList.next = list1;
            mergedList = mergedList.next;
            return mergedList;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        MergeList2 mergeList2 = new MergeList2();

        ListNode n3 = new ListNode(4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);

        ListNode n6 = new ListNode(4);
        ListNode n5 = new ListNode(3,n6);
        ListNode n4 = new ListNode(1,n5);

        ListNode trsd = mergeList2.mergeTwoLists(n1,n4);
        printList(trsd);

    }

    private static void printList(ListNode n1) {
        while(n1 !=null){
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
}
