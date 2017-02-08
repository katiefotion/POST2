/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import Products.ProductSpecification;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Flex
 */
public class Customer {

  private String name;
  private List<String> order; //Format: [upc] [quantity]\n ...
  private String paymentType;

  public Customer(String name) {
    this.name = name;
    this.order = new ArrayList<>();
    paymentType = "Cash";
  }

  public void placeOrder() {
    Scanner keyboard = new Scanner(System.in);
    String item = keyboard.nextLine();

    //end order when empty line is entered
    while (!item.isEmpty()) {
      order.add(item);
      item = keyboard.nextLine();
    }
    
    //prompt for payment type
    paymentType = keyboard.nextLine();
  }

  public List<String> getOrder() {
    return order;
  }
  
  public String getName() {
    return name;
  }
  
  public String getPaymentType() {
    return paymentType;
  }

  public void printOrder() {
    for (String item : order) {
      System.out.println("Item: " + item);
    }
  }
}
