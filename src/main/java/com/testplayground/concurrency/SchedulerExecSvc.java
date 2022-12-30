package main.java.com.testplayground.concurrency;

import java.util.concurrent.*;

public class SchedulerExecSvc {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";

        Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        Future<?> result2 = service.schedule(task2, 30, TimeUnit.SECONDS);

        //service.scheduleAtFixedRate(task1,5,1,TimeUnit.MINUTES);
    }
}
