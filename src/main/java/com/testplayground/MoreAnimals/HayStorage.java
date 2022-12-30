package main.java.com.testplayground.MoreAnimals;

public class HayStorage {

    private int quantity = 0;
    private HayStorage() {}
    private static HayStorage instance;
    //private static final HayStorage instance = new HayStorage();


//    public static HayStorage getInstance() {
//        return instance;
//    }
    public synchronized void addHay(int amount) {
        quantity += amount;
    }
    public synchronized boolean removeHay (int amount) {
        if(quantity < amount) return false;
        quantity -= amount;
        return true;
    }
    public synchronized int getHayQuantity() {
        return quantity;    }

    public static HayStorage getInstance() {
        if(instance == null) {
            synchronized(HayStorage.class) {
                if(instance == null) {
                    instance = new HayStorage();
                }
            }
        }
        return instance;
    }
}