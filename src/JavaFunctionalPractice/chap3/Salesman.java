package JavaFunctionalPractice.chap3;

public class Salesman {
    private Customer bestCustomer;

    Salesman(Customer bestCustomer) {
        this.bestCustomer = bestCustomer;
    }

    public Customer getBestCustomer() {
        return bestCustomer;
    }

    private Manager manager;
    public Salesman(Manager manager) {
        this.manager = manager;
    }
    public Manager getManager() {
        return manager;
    }
}
