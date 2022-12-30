package main.java.com.testplayground.concurrency;

public class PrintData implements Runnable {
    public void run() {
        for(int i=0; i<3; i++)
            System.out.println("Printing record: "+i);
    }
    public static void main(String[] args) {
        (new Thread(new PrintData())).start();
    }
}
 class ReadInventoryThread extends Thread {
    public void run() {
        System.out.println("Printing zoo inventory");
    }
    public static void main(String[] args) {
        (new ReadInventoryThread()).start();
    }
}
