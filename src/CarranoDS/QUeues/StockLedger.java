package CarranoDS.QUeues;

public class StockLedger {
    private QueueInterface<StockPurchase> ledger;

    public StockLedger(QueueInterface<StockPurchase> ledger) {
        this.ledger = ledger;
    }
    /*
        Records stock purchase in ledger
        @param shares brought -> No.of shares purchased
        @param pricePerShare  -> Price per share
     */
    public void buy(int sharesBought, double pricePerShare){
        for(;sharesBought>0;sharesBought--){
            StockPurchase purchase = new StockPurchase(pricePerShare);
            ledger.enqueue(purchase);
        }
    }

    public double sell(int sharesSold, double pricePerShare){
        double saleAmt = sharesSold*pricePerShare;
        double totCost = 0;

        while(sharesSold>0){
            StockPurchase share = ledger.deque();
            double shareCost = share.getCostPerShare(sharesSold);
            totCost  = totCost + shareCost;
            sharesSold--;
        }

        return saleAmt-totCost;
    }
}
