package GoodInterviewQuestions.Scheduling;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String args[])
    {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue();
        List<Integer> list1= Arrays.asList(1,2);
        List<Integer> list2= Arrays.asList(2,3,4);
        // Adding items to the pQueue using add()
        list1.forEach(l1->pQueue.add(l1));
        list2.forEach(l2->pQueue.add(l2));
        Collections.sort(list1);
        Collections.sort(list2);
        pQueue.add(list1.get(0));
        Iterator<Integer> iter1 = list1.iterator();
        Iterator<Integer> iter2 = list2.iterator();
        int count2 = 0;
        int count1 = 1;
        int size2=list2.size();
        int size1=list1.size();

        while (iter1.hasNext() && iter2.hasNext()){
            int val2 = iter2.next();
            if(count1<size1 && val2 >= pQueue.peek()){
                pQueue.add(val2);
                count2++;

            }
            int val1 = iter1.next();
            if(count2<size2 && val1>=pQueue.peek()){
                pQueue.add(val2);
            }

        }

        // Printing the top element and removing it
        // from the PriorityQueue container
        //System.out.println(pQueue.poll());
        pQueue.stream().forEach(System.out::println);

    }
}
