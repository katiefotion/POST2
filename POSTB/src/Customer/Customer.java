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
  
  public Customer(String name) {
    this.name = name;
    this.items = new String[100];
    this.numItems = 0;
    this.paymentType = "CASH";
  }
  
  public void placeOrder() {
      
    System.out.println("Please enter each upc, followed by a space, followed by the quantity.");
    System.out.println("Start a new line at the end of each product and press enter when finished.");

    Scanner keyboard = new Scanner(System.in);
    String item = keyboard.nextLine();

    //end order when empty line is entered
    while (!item.isEmpty()) {
      items[this.numItems] = item;
      item = keyboard.nextLine();
      this.numItems++;
    }
    
    //prompt for payment type
    System.out.println("Please enter the type of payment you would like to use (CASH, CHECK or CARD)");
    paymentType = keyboard.nextLine();
    
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

  
  public void printOrder() {
    
    for (int i = 0; i < numItems; i++) {
      String item = items[i];
      System.out.println("Item: " + item);
    }
  }
}
