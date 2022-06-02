package GrokkingCodingInterview.datastructure.HashTables;

import java.util.HashSet;
/*Problem Statement #
In this problem you have to implement two functions:

SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2)
SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2)
You have to implement these functions using Hashing. The first function will take two linked lists as input and return the union of the two lists. A Union of two sets can be expressed as, “Union of two sets A and B is a set which contains all the elements present in A or B”. Similarly, the second function will return the Intersection of two lists. The Intersection is commonly defined as, “A set which contains all the common elements present in A and B”.

Note: Your solution should also work if there is a duplicate in the lists, e.g.,

2->7->9->9->1
Hint: You can use the solution from the last challenge to help you out if needed.

Function Prototypes #
public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2)
public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2)
Output #
The union and intersection of two linked lists.

Note: The order of elements in the output list does not matter!

Sample Input #
list1 = 15->22->8->null
list2 = 7->14->22->null
Sample Output #
Union = 15->22->8->7->14->null
Intersection = 22->null
 Union
 Intersection
    7
    14
    22
    22
    8
    15
    22
    7
    14
    22
    8
    15
Note: We already covered this problem in chapter 3, but the approach used was different. Previously, a brute-force strategy was used because Hash Tables had not been discussed then. That solution was inefficient and should not be used in a technical interview. Now, let us create an optimized solution for the same problem using hashing!

 */

public class CheckUnionIntersection {

    public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        HashSet<T> visited = new HashSet<T>();

        SinglyLinkedList<T>.Node current = list1.getHeadNode(); //start from list1's head
        //Keep iterating list1
        while (current!=null) {
            //add elements of list1 into the result if they havent been visited before
            if(!visited.contains(current.data)) {
                result.insertAtHead(current.data);
                visited.add(current.data);
            }
            current = current.nextNode;
        }

        //now start from the head of list2
        current = list2.getHeadNode();

        //Keep iterating list2
        while (current!=null) {
            //add elements of list2 into the result if they havent been visited before
            if(!visited.contains(current.data)) {
                result.insertAtHead(current.data);
                visited.add(current.data);
            }
            current = current.nextNode;
        }


        return result;
    }

    public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        HashSet<T> visited = new HashSet<T>();
        //start from the head of list1
        SinglyLinkedList<T>.Node current = list1.getHeadNode();
        //Keep iterating list1
        while (current != null) {
            //Add elements to visited set if they have not been visited
            if (!visited.contains(current.data)) {
                visited.add(current.data);
            }
            current = current.nextNode;
        }
        //now take head of list2
        current = list2.getHeadNode();
        //iterate list2
        while (current != null) {
            //add the elements which have been visited before into the result
            if (visited.contains(current.data)) {
                result.insertAtHead(current.data);
                visited.remove(current.data);
            }
            current = current.nextNode;
        }
        return result;
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        for(int i=7; i>3; i--){
            list1.insertAtHead(i);
        }
        System.out.print("1st ");
        list1.printList();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        for(int i=0; i<5; i++){
            list2.insertAtHead(i);
        }
        System.out.print("2nd ");
        list2.printList();
        System.out.print("After Intersection ");
        intersectionWithHashing(list1, list2).printList();
        System.out.print("After Union ");
        unionWithHashing(list1, list2).printList();
    }
}
