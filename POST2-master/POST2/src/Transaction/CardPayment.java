/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

/**
 *
 * @author darrylraveche
 */


public class CardPayment extends Payment{
    
    private String cardNumber;
        
    public CardPayment(String card, double total) {
        super(total);
        this.cardNumber = card;
    }
    
    public String getCardNumber() {
        return cardNumber; 
    }
}

