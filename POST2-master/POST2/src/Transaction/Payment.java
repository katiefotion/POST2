
package Transaction;

/**
 *
 * @author katie
 */
public class Payment {
    
    private double paymentTotal;

    public Payment(double total) {
        this.paymentTotal = total;
    }
    
    // Getter methods    
    public double getPaymentTotal() {
      return this.paymentTotal;
    }
    
    // Setter methods
    public void setPaymentTotal(double total) {
        this.paymentTotal = total;
    }
}
