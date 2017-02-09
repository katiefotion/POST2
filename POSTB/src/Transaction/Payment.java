
package Transaction;

/**
 *
 * @author katie
 */
public class Payment {
    
    private String typePayment;
    private double paymentTotal;
    
    public Payment(String type, double total) {
        this.typePayment = type;
        this.paymentTotal = total;
    }
    
    // Getter methods
    public String getTypePayment() {
        return this.typePayment;
    }
    public double getPaymentTotal() {
        return this.paymentTotal;
    }
    
    // Setter methods
    public void setTypePayment(String type) {
        this.typePayment = type;
    }
    public void setPaymentTotal(double total) {
        this.paymentTotal = total;
    }
}
