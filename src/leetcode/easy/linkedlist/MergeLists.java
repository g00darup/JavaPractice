package leetcode.easy.linkedlist;

public class MergeLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        if((list1!=null && list2!=null)){
            if(list1.val<list2.val){
                head = new ListNode(list1.val);
                list1=list1.next;
            }else{
                head=new ListNode(list2.val);
                list2=list2.next;
            }
        }else if(list1==null){
            head = list2;
        }else if(list2==null){
            head = list1;
        }
        while(list1!=null || list2!=null){
            if(list1==null){
                head.next = list2;
            } if(list2==null){
                head.next = list1;
            }
            if((list1!=null && list2!=null)){
                if(list2.val>=list1.val){
                    head.next = new ListNode(list2.val);
                    list2=list2.next;
                }else{
                    head = new ListNode(list1.val);
                    list1=list1.next;
                }
            }
            head = head.next;
        }
        return head;
    }
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
            return null;
    }
}
