package main.java.com.testplayground.concurrency;

public class CheckResults2 {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException{

        new Thread(() -> {
            for(int i=0; i<500; i++) CheckResults2.counter++;
        }).start();

        while(CheckResults2.counter<100) {
            System.out.println("Not reached yet");
            Thread.sleep(1000);
        }
        System.out.println("Reached!");
    }
}
