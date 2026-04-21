package praktikum.tpraktikumInterface;

public class Invoice implements Payable {
    String productName;
    int quantity;
    int pricePerItem;
 
    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }
 
    @Override
    public int getPayableAmount() {
        return quantity * pricePerItem;
    }
}
