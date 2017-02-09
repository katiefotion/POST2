
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
    
    public Transaction(String customerName, String transactionTime, String[] transactionLines, int numItems, String paymentType, double paymentTotal) {
        this.header = new TransactionHeader(customerName, transactionTime);
        this.transItems = new TransactionItem[100];
        
        for (int i = 0; i < numItems; i++) {
            System.out.println("This line is in transaction: " + transactionLines[i]);
            String[] splitUPCQuantity = transactionLines[i].split(" ");
            TransactionItem item = new TransactionItem(splitUPCQuantity[0], Integer.parseInt(splitUPCQuantity[1]));
            this.transItems[i] = item;
        }
        
        this.numTransItems = transactionLines.length; 
        this.payment = new Payment(paymentType, paymentTotal);
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
    public void setTransactionHeader(TransactionHeader transHeader) {
        this.header = transHeader;
    }
    public void setTransactionItems(TransactionItem[] items) {
        this.transItems = items;
    }
    public void setNumTransItems(int numTransactions) {
        this.numTransItems = numTransactions;
    }
    public void setPayment(Payment p) {
        this.payment = p;
    }
}
