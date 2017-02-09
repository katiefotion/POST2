package Transaction;

/**
 *
 * @author katie
 */
public class TransactionHeader {
    
    private String customerName;
    private String transactionTime; 
    
    public TransactionHeader(String name, String time) {
        this.customerName = name;
        this.transactionTime = time;
    }
    
    // Getter methods 
    public String getCustomerName() {
        return this.customerName;
    }
    public String getTransactionTime() {
        return this.transactionTime;
    }
    
    // Setter methods
    public void getCustomerName(String name) {
        this.customerName = name;
    }
    public void getTransactionTime(String time) {
        this.transactionTime = time;
    }
}
