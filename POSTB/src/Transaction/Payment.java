
package Transaction;

/**
 *
 * @author katie
 */
public class Payment {
    
    private String typePayment;
    private double paymentTotal;
    private String cardNumber;
    
    public Payment(String type, double total) {
        this.typePayment = type;
        this.paymentTotal = total;
        this.cardNumber = "";
    }
    
    public Payment(String type, String card) {
        this.typePayment = type;
        this.paymentTotal = 0.0;
        this.cardNumber = card;
    }
    
    // Getter methods
    public String getTypePayment() {
        return this.typePayment;
    }
    public String getCardNumber() {
        return this.cardNumber; 
    }
    
    // Setter methods
    public void setPaymentTotal(double total) {
        this.paymentTotal = total;
    }
}
