package CarranoDS.Queues;

public class StockPurchase {
    double cost;

    public StockPurchase(double pricePerShare) {
        cost = pricePerShare;
    }

    public double getCostPerShare(int shares) {
        return cost/shares;
    }
}
