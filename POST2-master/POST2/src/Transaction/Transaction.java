package Transaction;

import Customer.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author katie
 */
public class Transaction {

    private TransactionHeader header;
    private TransactionItem[] transItems;
    private int numTransItems;
    private Payment payment1;

    //new vars below
    private String customerName;
    private String transactionTime;
    private Payment payment;
    private List<TransactionItem> items;

    public Transaction(List<TransactionItem> items, String customerName, String transactionTime, Payment payment) {
        this.customerName = customerName;
        this.transactionTime = transactionTime;
        this.payment = payment;
        this.items = items;
    }

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
            if (splitUPCQuantity.length == 1) {
                upc = splitUPCQuantity[0];
                quantity = 1;
            } else {
                upc = splitUPCQuantity[0];
                quantity = Integer.parseInt(splitUPCQuantity[1]);
            }

            TransactionItem item = new TransactionItem(upc, quantity);
            this.transItems[i] = item;
        }

        this.numTransItems = transactionLines.length;
        if (customer.getPaymentType().equals("CARD") || customer.getPaymentType().equals("Card") || customer.getPaymentType().equals("card")) {
            this.payment = new CardPayment(customer.getCardNumber(), paymentTotal);
        } else if (customer.getPaymentType().equals("CHECK") || customer.getPaymentType().equals("Check") || customer.getPaymentType().equals("check")) {
            this.payment = new CheckPayment(paymentTotal);
        } else if (customer.getPaymentType().equals("CASH") || customer.getPaymentType().equals("Cash") || customer.getPaymentType().equals("cash")) {
            this.payment = new CashPayment(paymentTotal);
        } else {
            this.payment = new Payment(paymentTotal);
        }
    }

    /*
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
     */
    public String getCustomerName() {
        return this.customerName;
    }

    public String getTransactionTime() {
        return this.transactionTime;
    }

    //note: this might be better as a field inside each payment subclass 
    public String getPaymentType() {
        return this.payment.getClass().getName();
    }

    public double getPaymentTotal() {
        return this.payment.getPaymentTotal();
    }
    
    public TransactionItem[] getTransactionItems() {
        return (TransactionItem[]) items.toArray();
    }
    
    public int getNumTransItems() {
        return items.size();
    }
}
