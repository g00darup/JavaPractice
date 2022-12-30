package main.java.edu.java.lambda.functional;

class ThreadDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("run methode called ...");
    }
}
public class RunnableLambda {
    public static void main(String[] args) {
        Thread th = new Thread(new ThreadDemo());
        th.start();

        Runnable runnable = () -> {
            System.out.println("run meth called using lambda ...");
        };

        Thread threadLambda = new Thread(runnable);
        threadLambda.start();
    }
}
