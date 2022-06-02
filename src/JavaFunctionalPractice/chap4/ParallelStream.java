package JavaFunctionalPractice.chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class ParallelStream {
    static int rate = 30;
    public static void main(String[] args) {
        //below code will throe ConcurrentModificationException
//        List<Integer> hours = new ArrayList<>(
//                Arrays.asList(32, 40, 54, 23, 35, 48, 40, 40, 23,
//                        54, 45, 44, 45, 65, 34, 35, 42, 42, 50, 45,
//                        35, 45, 35, 31, 12, 56));

        CopyOnWriteArrayList<Integer> concurrentHours =
                new CopyOnWriteArrayList(
                        Arrays.asList(32, 40, 54, 23, 35, 48, 40, 40, 23,
                                54, 45, 44, 45, 65, 34, 35, 42, 42, 50, 45,
                                35, 45, 35, 31, 12, 56));

        Stream<Integer> hoursStream;
        hoursStream = concurrentHours.parallelStream();
        int totalHours = hoursStream
                .map(h -> {
                    int amount =h*30;
                    if(amount>40) {
                        concurrentHours.add(h+10);
                    }
                    return amount;
                })
                .reduce(0, (r, s) -> r + s);
        System.out.println(totalHours);


//        List<Integer> hours
//                = Arrays.asList(32, 40, 24, 23, 35, 18, 40, 30, 23,
//                54, 35, 34, 25, 15, 34, 35, 42, 44, 40, 35,
//                35, 45, 35, 31, 12, 56); 31, 12, 56); Stream<Integer> hoursStream2;
//        for(int i=0; i<2; i++) {
//            int total = hours
//                    .parallelStream()
//                    .map(h -> getPay(h))
//                    .reduce(0, (r, s) -> r + s);
//            System.out.println(total);
//        }
    }

    public static int getPay(int hours) {
        if (hours > 40) {
            rate = 25;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // Handle exception
            }
        } else {
            rate = 30;
        }
        return rate * hours;
    }
}
