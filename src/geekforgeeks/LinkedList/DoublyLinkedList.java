package geekforgeeks.LinkedList;

public class DoublyLinkedList {
    static class Nod{
        int data;
        Nod prev;
        Nod next;

        public Nod(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Nod head;

    public DoublyLinkedList(){
        this.head = null;
    }

    public void inserAtPos(int pos, int data){
        Nod newNode = new Nod(data);
        if(pos ==0) {
            newNode.next = this.head;
            newNode.prev = null;


            if (this.head != null) {
                this.head.prev = newNode;
            }

            this.head = newNode;
        }else{
            Nod curr = this.head;
            int cnt = 0;
            while(curr !=null && cnt < pos-1){
                curr = curr.next;
                cnt++;
            }
            if(curr==null){
                System.out.println("pos out of range");
                return;
            }
            newNode.next = curr.next;
            newNode.prev = curr;
            if(curr.next !=null){
                curr.next.prev = newNode;
            }
            curr.next = newNode;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.inserAtPos(0,10);
        dll.inserAtPos(1,20);
        dll.inserAtPos(2,30);

        Nod curr = dll.head;
        while (curr !=null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
