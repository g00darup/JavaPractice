package goodrichtomassia.chap01;

public class Counter implements Runnable{
    public Counter(int count) {
        this.count = count;
    }

    public Counter(){
        count = 0;
    }

    protected int count;

    public int displayCount() {return count;}

    public void incrementCount () {count++;}

    public void decrementCount() {count--;}

    @Override
    public void run() {
        System.out.println("Dummy impl.");
    }
}
