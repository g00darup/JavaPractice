package goodrichtomassia.chap01;

import java.util.concurrent.Callable;

public class CounterDriver {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter(0);
        Thread t1 = new Thread(c1::incrementCount);
        Thread t2 = new Thread(c1::incrementCount);
        Thread t3 = new Thread(c1::decrementCount);
        t1.start();
        t2.start();
        t3.start();
//        t1.join();
        t3.join();
        t2.join();
        //Thread.sleep(1000);

        System.out.println(c1.displayCount());
    }
}
