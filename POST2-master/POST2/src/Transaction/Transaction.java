
package Transaction;

/**
 *
 * @author katie
 */
public class Transaction {
    
    private TransactionHeader header;
    private TransactionItem[] transItems;
    private int numTransItems;
    private Payment payment;
    
    public Transaction(TransactionHeader h, TransactionItem[] items, int numItems, Payment p) {
        this.header = h;
        this.transItems = items;
        this.numTransItems = numItems; 
        this.payment = p;
    }
    
    // Getter methods
    public TransactionHeader getTransactionHeader() {
        return this.header;
    }
    public TransactionItem[] getTransactionItems() {
        return this.transItems;
    }
    public int getNumTransItems() {
        return this.numTransItems;
    }
    public Payment getPayment() {
        return this.payment;
    }
    
    // Setter methods
    public void setPayment(Payment p) {
        this.payment = p;
    }
}
