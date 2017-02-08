/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cashier;

import Customer.Customer;
import POST.POST;
import Products.ProductSpecification;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Flex This class serves as the interface between the frontend and
 * backend of the POST system. The Cashier will enter the customer's items
 * through the POST frontend GUI/CMD line to the POST backend server
 */
public class Cashier {

  private POST post; //post cashier is currently using

  public Cashier(POST post) {
    this.post = post;
  }

  //This is the "GUI" where the cashier is inputting/ringing up
  //the items into the POST system
  public void processOrder(Customer customer, List<String> order) {
    List<ProductSpecification> orderItems = new ArrayList<>();
    String productDesc;
    String upcAndQuantity[]; //order is formatted as [upc][ ][quantity]

    for (String item : order) {
      upcAndQuantity = item.split(" ");

      if (post.isValidUPC(upcAndQuantity[0])) {
        productDesc = post.getProductDescription(upcAndQuantity[0]);
        
        orderItems.add(new ProductSpecification(productDesc, Double.parseDouble(upcAndQuantity[0]), upcAndQuantity[1]));
      }
    }
    
    post.processTransaction(customer, orderItems);
  }

  public void printInvoice() {
    //call post.getTransactionInvoice()
  }
}
