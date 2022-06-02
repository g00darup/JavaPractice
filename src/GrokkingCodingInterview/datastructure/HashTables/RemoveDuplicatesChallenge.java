package GrokkingCodingInterview.datastructure.HashTables;

import java.util.HashSet;

/*
Problem Statement: #
In this problem, you have to implement public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) function. This function will take a Singly linked list as input and remove all the elements that appear more than once in the list. An illustration is also provided for your understanding.

Function Prototype: #
public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list)
Output: #
The linked list with all the duplicates removed.

Sample Input #
linkedlist = 7->14->21->14->22->null
Sample Output #
linkedlist = 7->14->21->22->null
    7
    14
    21
    22
    NULL
    7
    14
    21
    14
    22
    7
    NULL
Note: We already covered this problem in chapter 3, but the approach used was different. Previously, a brute-force strategy was used because Hash Tables had not been discussed then. That solution was inefficient and should not be used in a technical interview. Now, let us create an optimized solution for the same problem using hashing!
 */
public class RemoveDuplicatesChallenge {
    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        SinglyLinkedList<V>.Node current = list.getHeadNode();
        SinglyLinkedList<V>.Node prevNode = list.getHeadNode();
        //will store all the elements that we observe once
        HashSet<V> visitedNodes = new HashSet<V>();

        if (!list.isEmpty() && current.nextNode != null) {
            while (current != null) {
                //check if already visited then delete this node
                if (visitedNodes.contains(current.data)) {
                    //deleting the node by undating the pointer of previous node
                    prevNode.nextNode = current.nextNode;
                    current = current.nextNode;
                } else {
                    //if node was not already visited then add it to the visited set
                    visitedNodes.add(current.data);
                    //moving on to next element in the list
                    prevNode = current;
                    current = current.nextNode;
                }
            }
        }
    }
    public static void main(String args[]) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); // created linked list

        for(int i = 1; i <= 8; i++) {
            list.insertAtHead(i);      // inserting data in list
        }
        //inserting duplicates
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(1);

        System.out.println("List before deleting duplicates from list :");
        list.printList();
        removeDuplicatesWithHashing(list); // calling removeDuplicatesWithHashing function
        System.out.println("List after deleting duplicates from list :");
        list.printList();
    }
}