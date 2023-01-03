package main.java.com.testplayground.concurrency;

import java.util.concurrent.*;
public class SheepManager {
    private static int sheepCount = 0;

    private static void incrementAndReport() {
        synchronized (SheepManager.class) {
            System.out.print((++sheepCount) + " ");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager manager = new SheepManager();
            for (int i = 0; i < 10; i++)
                service.submit(() -> incrementAndReport());
        } finally {
            if (service != null) service.shutdown();
        }
    }
}