package GoodInterviewQuestions.Scheduling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ScheduleMeetings {

    // Complete the repeatedString function below.
    static int maxMeetings(List<Integer> startSchedule, List<Integer> endSchedule) {

        PriorityQueue<Integer> pQueue = new PriorityQueue();
        Collections.sort(startSchedule);
        Collections.sort(endSchedule);
        if(!startSchedule.isEmpty())
            pQueue.add(startSchedule.get(0));
        Iterator<Integer> iter1 = startSchedule.iterator();
        Iterator<Integer> iter2 = endSchedule.iterator();
        int count2 = 0;
        int count1 = 1;
        int size2=endSchedule.size();
        int size1=startSchedule.size();

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
        if(pQueue.size()==1)
            return 0;
        else
        return pQueue.size()/2;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scanner.nextLine();
//
//        long n = scanner.nextLong();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        long result = repeatedString(s, n);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();

        new ScheduleMeetings().run();
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(long expected, long output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        long expected_1 = 3;
        List<Integer> list1_1= Arrays.asList(1,2,3);
        List<Integer> list2_1= Arrays.asList(2,3,4);
        long output_1 = maxMeetings(list1_1,list2_1);
        check(expected_1, output_1);


        long expected_2 = 2;
        List<Integer> list1_2= Arrays.asList(1,2,3,4);
        List<Integer> list2_2= Arrays.asList(3,4);
        long output_2 = maxMeetings(list1_2,list2_2);
        check(expected_2, output_2);

        long expected_3 = 2;
        List<Integer> list1_3= Arrays.asList(1,4);
        List<Integer> list2_3= Arrays.asList(2,3,4,5);
        long output_3= maxMeetings(list1_2,list2_2);
        check(expected_3, output_3);

//
//        long expected_3 = 0;
//        long output_3 = repeatedString("ccd", 10);
//        check(expected_3, output_3);
//
//        long expected_4 = 1000000000;
//        long output_4 = repeatedString("a", 1000000000);
//        check(expected_4, output_4);
        // Add your own test cases here


    }
    void printInteger(long n) {
        System.out.print("[" + n + "]");
    }
}

