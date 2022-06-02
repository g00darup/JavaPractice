package GrokkingCodingInterview.datastructure.LinkedList;

 public class SinglyLinkedList<T> {
        //Node inner class for SLL
        public class Node {
            public T data;
            public Node nextNode;

        }

        public Node headNode; //head node of the linked list
        public int size;      //size of the linked list

        //Constructor - initializes headNode and size
        public SinglyLinkedList() {
            headNode = null;
            size = 0;
        }
        public int length() {
         int count = 0;
         // Write -- Your -- Code
         return count;
     }

        //Helper Function that checks if List is empty or not
        public boolean isEmpty() {
            if (headNode == null) return true;
            return false;
        }

        //Inserts new data at the start of the linked list
        public void insertAtHead(T data) {
            //Creating a new node and assigning it the new data value
            Node newNode = new Node();
            newNode.data = data;
            //Linking head to the newNode's nextNode
            newNode.nextNode = headNode;
            headNode = newNode;
            size++;
        }

        public void insertAtEndMySol(T data) {
            Node newNode = new Node();
            newNode.data = data;

            if (headNode == null)
                headNode = newNode;
            else{
                Node cur = headNode;
                while (cur!=null){
                    if(cur.nextNode==null){
                        cur.nextNode = newNode;
                        newNode.nextNode=null;
                    }
                   cur = cur.nextNode;

                }
            }


        }

        //Inserts new data at the end of the linked list
        public void insertAtEnd(T data) {
            //if the list is empty then call insertATHead()
            if (isEmpty()) {
                insertAtHead(data);
                return;
            }
            //Creating a new Node with value data
            Node newNode = new Node();
            newNode.data = data;
            newNode.nextNode = null;

            Node last = headNode;
            //iterate to the last element
            while (last.nextNode != null) {
                last = last.nextNode;
            }
            //make newNode the next element of the last node
            last.nextNode = newNode;
            size++;
        }

        public void insertAfter(T data, T previous) {

            //Creating a new Node with value data
            Node newNode = new Node();
            newNode.data = data;
            //Start from head node
            Node currentNode = this.headNode;
            //traverse the list until node having data equal to previous is found
            while (currentNode != null && !currentNode.data.equals(previous)) {
                currentNode = currentNode.nextNode;
            }
            //if such a node was found
            //then point our newNode to currentNode's nextElement
            if (currentNode != null) {
                newNode.nextNode = currentNode.nextNode;
                currentNode.nextNode = newNode;
                size++;
            }
        }

        public boolean searchNode(T data) {
            // Write -- Your -- Code
            Node currentNode = this.headNode;
            while(currentNode!=null){
                if(currentNode.data.equals(data))return true;

                currentNode=currentNode.nextNode;
            }
            return false; //value not found
        }

     public void deleteByValue(T data) {
         Node currentNode = this.headNode;
         Node prevNode = this.headNode;

         if(currentNode.data.equals(data)){
             headNode =null;
             return;
         }else{
             currentNode = currentNode.nextNode;
         }


         if(currentNode!=null && searchNode(data)){
             while(currentNode!=null){
                 if(currentNode.data.equals(data)){
                     prevNode=currentNode.nextNode;
                 }
                 currentNode = currentNode.nextNode;
                 prevNode = prevNode.nextNode;
             }
         }
     }

        //Deletes data from the head of list
        public void deleteAtHead() {
            //if list is empty then simply return
            if (isEmpty())
                return;
            //make the nextNode of the headNode equal to new headNode
            headNode = headNode.nextNode;
            size--;
        }
     //Deletes data given from the linked list
     public void deleteByValue2(T data) {
         //if empty then simply return
         if (isEmpty())
             return;

         //Start from head node
         Node currentNode = this.headNode;
         Node prevNode = null; //previous node starts from null

         if(currentNode.data.equals(data)) {
             //data is at head so delete from head
             deleteAtHead();
             return;
         }
         //traverse the list searching for the data to delete
         while (currentNode != null) {
             //node to delete is found
             if (data.equals(currentNode.data)){
                 prevNode.nextNode = currentNode.nextNode;
                 size--;
                 return;
             }
             prevNode = currentNode;
             currentNode = currentNode.nextNode;
         }
     }
        // Helper Function to printList
        public void printList() {
            if (isEmpty()) {
                System.out.println("List is Empty!");
                return;
            }

            Node temp = headNode;
            System.out.print("List : ");
            while (temp.nextNode != null) {
                System.out.print(temp.data.toString() + " -> ");
                temp = temp.nextNode;
            }
            System.out.println(temp.data.toString() + " -> null");
        }

        public static void main(String[] args) {

        }
    }

