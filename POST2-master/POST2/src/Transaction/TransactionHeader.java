package Transaction;

import java.util.Date;

/**
 *
 * @author katie
 */
public class TransactionHeader {
    
    private String customerName;
    private Date transactionDate; 
    
    public TransactionHeader(String name, Date date) {
        this.customerName = name;
        this.transactionDate = date;
    }
    
    // Getter methods 
    public String getCustomerName() {
        return this.customerName;
    }
    public Date getTransactionDate() {
        return this.transactionDate;
    }
}
