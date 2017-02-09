
package Transaction;

import Customer.Customer;

/**
 *
 * @author katie
 */
public class Transaction {
    
    private TransactionHeader header;
    private TransactionItem[] transItems;
    private int numTransItems;
    private Payment payment;
    
    public Transaction(Customer customer, String transactionTime, double paymentTotal) {
        
        String customerName = customer.getName();
        String[] transactionLines = customer.getOrder();
        int numItems = customer.getNumItems();
        String paymentType = customer.getPaymentType();
        
        this.header = new TransactionHeader(customerName, transactionTime);
        this.transItems = new TransactionItem[100];
        
        for (int i = 0; i < numItems; i++) {
            String[] splitUPCQuantity = transactionLines[i].split(" ");
            
            String upc;
            int quantity; 
            if(splitUPCQuantity.length == 1) {
                upc = splitUPCQuantity[0];
                quantity = 1;
            } 
            else {
                upc = splitUPCQuantity[0];
                quantity = Integer.parseInt(splitUPCQuantity[1]);
            }
            
            TransactionItem item = new TransactionItem(upc, quantity);
            this.transItems[i] = item;
        }
        
        this.numTransItems = transactionLines.length; 
        if(customer.getPaymentType().equals("CARD") || customer.getPaymentType().equals("Card") || customer.getPaymentType().equals("card"))
        {
            this.payment = new Payment(paymentType, customer.getCardNumber());
        }
        else {
            this.payment = new Payment(paymentType, paymentTotal);
        }
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
