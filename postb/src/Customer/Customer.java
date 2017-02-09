/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import Products.ProductSpecification;
import Transaction.Transaction;
import Transaction.TransactionItem;
import Transaction.Payment;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author Flex
 */
public class Customer {

  private String name;
  private String[] items;       // Assignment says we can assume only 100 max items
  //Format: [upc] [quantity]\n ...
  private int numItems;
  private String paymentType;
  private String cardNumber;

  public Customer(String name) {
    this.name = name;
    this.items = new String[100];
    this.numItems = 0;
    this.paymentType = "CASH";
    this.cardNumber = "";

  }

  public void placeOrder() {

    System.out.println("Please enter each upc, followed by a space, followed by the quantity.");
    System.out.println("Start a new line at the end of each product and press enter when finished.");

    Scanner keyboard = new Scanner(System.in);
    String item = keyboard.nextLine();
    System.out.println("the: " + this.numItems + "\n");

    //end order when empty line is entered
    while (!item.isEmpty()) {
      System.out.println("added: " + item + "\n");
      items[this.numItems] = item;
      item = keyboard.nextLine();
      this.numItems++;
    }

    //prompt for payment type
    System.out.println("Please enter the type of payment you would like to use (CASH, CHECK or CARD)");
    paymentType = keyboard.nextLine();

    // If card, prompt for card number
    if (paymentType.equals("CARD") || paymentType.equals("Card") || paymentType.equals("card")) {
      System.out.println("Please enter your card number");
      cardNumber = keyboard.nextLine();
    }

  }

  // Getter methods
  public String getName() {
    return name;
  }

  public String[] getOrder() {
    return items;
  }

  public int getNumItems() {
    return numItems;
  }

  public String getPaymentType() {
    return paymentType;
  }

  public String getCardNumber() {
    return cardNumber;
  }
}
