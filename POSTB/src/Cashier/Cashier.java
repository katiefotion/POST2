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
import Transaction.Transaction;
import java.text.SimpleDateFormat;
import java.util.Date;

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
  public void processOrder(Customer customer, String[] order, int numOrders) {
    List<ProductSpecification> orderItems = new ArrayList<>();
    String productDesc;
    String upcAndQuantity[]; //order is formatted as [upc][ ][quantity]

    for (int i = 0; i < numOrders; i++) {
      String item = order[i];
      upcAndQuantity = item.split(" ");

      if (post.isValidUPC(upcAndQuantity[0])) {
        productDesc = post.getProductDescription(upcAndQuantity[0]);
        
        orderItems.add(new ProductSpecification(productDesc, Double.parseDouble(upcAndQuantity[0]), upcAndQuantity[1]));
      }
    }
    
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    Transaction transaction = new Transaction(customer.getName(), timeStamp, customer.getOrder(), customer.getNumItems(), customer.getPaymentType(), 0.0);
    
    post.processTransaction(customer, transaction);
  }

  public void printInvoice() {
    //call post.getTransactionInvoice()
  }
}
