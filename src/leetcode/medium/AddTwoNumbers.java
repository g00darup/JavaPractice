package leetcode.medium;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int [] l1 = {9,9,9,9,9,9,9}, l2 = {9,9,9,9};
        ListNode n1 = ListNode.testCase(l1);
        ListNode n2 = ListNode.testCase(l2);

        System.out.println(addTwoNumbers(n1,n2).toString());
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null && l2==null)
            return l1;

        if(l1==null && l2!=null)
            return l2;

        if(l1!=null && l2==null)
            return l1;

        ListNode head = new ListNode();
        int carry =0;
        if(l1!=null && l2!=null){
            head = new ListNode((l1.val+l2.val)%10);
            if(l1.val+l2.val >=10)
                carry = 1;
            l1=l1.next;
            l2=l2.next;
        }
        ListNode it = head;

        while(l1!=null && l2!=null){
            int sum =l1.val+l2.val+carry;
            it.next = new ListNode(sum%10);
            if(sum>=10)
                carry=1;
            else if(sum>=20)
                carry=2;
            else
                carry=0;
            it = it.next;
            l1=l1.next;
            l2=l2.next;
        }

        if(l1!=null && l2==null){
            while(l1!=null){
                int sum =l1.val+carry;
                it.next = new ListNode(sum%10);
                if(sum>=10)
                    carry=1;
                else if(sum>=20)
                    carry=2;
                else
                    carry=0;
                it = it.next;
                l1=l1.next;
            }
        }

        if(l2!=null && l1==null){
            while(l2!=null){
                int sum =l2.val+carry;
                it.next = new ListNode(sum%10);
                if(sum>=10)
                    carry=1;
                else if(sum>=20)
                    carry=2;
                else
                    carry=0;
                it = it.next;
                l2=l2.next;
            }
        }

        if(carry>0){
            it.next = new ListNode(carry);
        }
        return head;

    }

//    evaluate (ListNode it,ListNode l1,ListNode l2){
//        it.next = new ListNode(sum%10);
//        if(sum>=10)
//            carry=1;
//        else if(sum>=20)
//            carry=2;
//        else
//            carry=0;
//        it = it.next;
//        l1=l1.next;
//    }

    private static ListNode convertNum2List(int n1) {
        ListNode head = new ListNode(n1%10);
        n1 = n1/10;
        ListNode it = head;
        while(n1!=0){
            it.next = new ListNode(n1%10);
            n1 = n1/10;
            it = it.next;
        }
        return head;
    }

    private static int convertList2Num(ListNode n){
        int res = 0;
        if(n.next!=null) {
            res = n.val;
            n = n.next;
        }
        while(n!=null){
            res = res*10+n.val;
            n = n.next;
        }
        return res;
    }
}




class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public String toString(){
        String res = "";
        ListNode n = this;
        while(n!=null){
            res += n.val+" -> ";
            n = n.next;
        }
        res += "null";
        return res;
    }
    public static ListNode testCase(int[] test){
        //int[] test = {44, 23, 12, 23, 0, 29, 12, 20};
        ListNode head = new ListNode(test[0]);
        ListNode it = head;
        for(int i=1; i<test.length; i++){
            it.next = new ListNode(test[i]);
            it = it.next;
        }
        return head;
    }

  }
