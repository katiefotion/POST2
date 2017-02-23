/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POST;

import NetClientGet.NetClientGet;
import Products.ProductCatalog;
import Store.Store;
import Transaction.Transaction;
import Transaction.TransactionItem;
import Transaction.TransactionHeader;
import Transaction.Payment;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Felix Chan Lee
 */
public class POST {
  private final String transactionPath; //TODO: remove

  private ProductCatalog productCatalog;
  private Store store;

  public POST(Store store) {
    transactionPath = "TextFiles/transaction.txt";

    this.store = store;    
    this.productCatalog = store.getProductCatalog();
  }

  //called to calculate total and store the transaction
  public void processTransaction(Transaction transaction) throws ParserConfigurationException, SAXException {
    // Write transaction to database 
    boolean success = false;
    try {
        NetClientGet.postTransaction(transaction);
        success = true;
    }
    finally {
      if(!success) {
          
          System.out.println("failure");
    
//        TransactionItem[] temp = transaction.getTransactionItems();
//        
//        //writing customer info to transaction  
//        BufferedWriter writeTotranscFile;
//        String cReturn = String.format("%n");
//        try {
//          writeTotranscFile = new BufferedWriter(new FileWriter(transactionPath, true));
//
//          //write header
//          TransactionHeader hTemp = transaction.getTransactionHeader();
//          String f1 = String.format("%-10s%s", hTemp.getCustomerName(), hTemp.getTransactionDate());
//          writeTotranscFile.write(f1);
//          writeTotranscFile.write(System.getProperty("line.separator"));
//
//          //write items
//          for (int i = 0; i < transaction.getNumTransItems(); i++) {
//            if (temp[i] == null) {
//              break;//break where element in TransactionItem list is null(empty)
//            }
//            String f2 = String.format("%-10s%s", temp[i].getProductUPC(), temp[i].getProdQuantity());
//            writeTotranscFile.write(f2);
//            writeTotranscFile.write(System.getProperty("line.separator"));
//          }
//
//          //String pay = pTemp.getClass().getName();
//      
//      
//          /*/write payment
//          if (pTemp.getTypePayment().equals("CARD") || pTemp.getTypePayment().equals("Card") || pTemp.getTypePayment().equals("card")) {
//            writeTotranscFile.write(pTemp.getTypePayment() + " " + pTemp.getCardNumber());
//          } else {
//            writeTotranscFile.write(pTemp.getTypePayment() + " $" + finTotal);
//          }
//          */
//          //end transaction separator
//          writeTotranscFile.write(System.getProperty("line.separator"));
//          writeTotranscFile.write(System.getProperty("line.separator"));
//
//          writeTotranscFile.close();
//        } catch (IOException ex) {
//            Logger.getLogger(POST.class.getName()).log(Level.SEVERE, null, ex);
//        }
      }
      
      //this.printInvoice(transaction);
    }

  }

  private String getTransactionInvoice(Transaction transaction) {
    StringBuilder invoice = new StringBuilder();

    String customerName = transaction.getTransactionHeader().getCustomerName();
    Date transactionDate = transaction.getTransactionHeader().getTransactionDate();
    String itemName, upc;
    double price = 0, total = 0, change = 0;
    Payment payment = transaction.getPayment();

    //header
    invoice.append("\n")
            .append(store.getStoreName())
            .append("\n")
            .append(customerName)
            .append(" ")
            .append(transactionDate)
            .append("\n");

    //items
    for (TransactionItem item : transaction.getTransactionItems()) {
      if (item == null) {
        break;
      }

      upc = item.getProductUPC();
      itemName = getProductDescription(upc);
      price = getProductPrice(upc);
      total += price * item.getProdQuantity();

      invoice.append(itemName)
              .append(" @ ")
              .append(price)
              .append(" ")
              .append(String.format("%.2f", total))
              .append("\n");
    }

    invoice.append("----")
            .append("Total ")
            .append(total)
            .append("\n");

    //payment
    String paymentType = payment.getClass().getName();
    if (paymentType.equals("CASH")) {

      invoice.append("Amount Tendered: ");

      double pay = payment.getPaymentTotal();
      change = 0;

      //note: no check for not enough pay (should be in process order)
      invoice.append(payment.getPaymentTotal())
              .append("\n");

      if (pay >= total) {
        change = total - pay;

        invoice.append("Amount Returned: ")
                .append(change)
                .append("\n");
      }

    } else if (paymentType.equals("CHECK")) {
      invoice.append("Paid by Check\n");
    } else if (paymentType.equals("CARD")) {
      invoice.append("Credit Card: ")
              //.append(transaction.getPayment().getCardNumber())
              .append("\n");
    }

    return invoice.toString();
  }

  /* Helper classes to get info from database */
  public Store getStore() {
      return this.store;
  }
  
  public String getStoreName() {
    return this.store.getStoreName();
  }

  //return N/A if not product found
  public String getProductDescription(String upc) {
    return isValidUPC(upc) ? this.productCatalog.getProductByUPC(upc).getProductDesc() : "N/A";
  }

  //return 0 if not product found
  public double getProductPrice(String upc) {
    return isValidUPC(upc) ? this.productCatalog.getProductByUPC(upc).getProductPrice() : 0;
  }

  public boolean isValidUPC(String upc) {
    return this.productCatalog.getProductByUPC(upc) != null;
  }
  
  private void printInvoice(Transaction transaction) {
    System.out.println(this.getTransactionInvoice(transaction));
  }
}
