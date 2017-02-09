/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POST;

import Customer.Customer;
import Products.ProductReader;
import Products.ProductSpecification;
import Store.Store;
import Transaction.Transaction;
import Transaction.TransactionItem;
import Transaction.TransactionHeader;
import Transaction.Payment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Time;

/**
 *
 * @author Flex
 */
public class POST {

  // Define filepaths to product, customer list and transaction files 
  private final String productPath;
  private final String transactionPath;

  private List<ProductSpecification> productCatalog;
  private Store store;

  public POST(Store store) {
    productPath = "C:\\Users\\Flex\\Documents\\NetBeansProjects\\POSTB\\POSTB\\src\\TextFiles\\products.txt";
    transactionPath = "C:\\Users\\Flex\\Documents\\NetBeansProjects\\POSTB\\POSTB\\src\\TextFiles\\transaction.txt";

    // Changed from C:\\Users\\Flex\\Documents\\NetBeansProjects\\POSTB\\POSTB\\src\\...
    productCatalog = new ArrayList<>();
    this.store = store;
  }

  public void start() {
    initializeCatalog();

    //printCatalog();
  }

  //TODO: called to calculate total and store the transaction
  public void processTransaction(Customer customer, Transaction transaction) {

    //calculate total
    TransactionItem[] temp = transaction.getTransactionItems();
    String tempUPC;
    int quantity;
    double finalTotal = 0;
    double price, tempTotal;

    for (int i = 0; i < transaction.getNumTransItems(); i++) {
      if (temp[i] == null) {
        System.out.println("BROKE");
        break;//break where element in TransactionItem list is null(empty)
      }
      quantity = temp[i].getProdQuantity();
      tempUPC = temp[i].getProductUPC();
      price = getProductPrice(tempUPC);
      tempTotal = price * quantity;

      finalTotal = finalTotal + tempTotal;

    }
    String finTotal = String.format("%.2f", finalTotal);

    //update payment in transaction
    Payment pTemp = transaction.getPayment();
    pTemp.setPaymentTotal(finalTotal);
    transaction.setPayment(pTemp);

    //writing customer info to transaction  
    BufferedWriter writeTotranscFile;
    String cReturn = String.format("%n");
    try {
      writeTotranscFile = new BufferedWriter(new FileWriter(transactionPath, true));

      //write header
      TransactionHeader hTemp = transaction.getTransactionHeader();
      String f1 = String.format("%-10s%s", hTemp.getCustomerName(), hTemp.getTransactionTime());
      writeTotranscFile.write(f1);
      writeTotranscFile.write(System.getProperty("line.separator"));

      //write items
      for (int i = 0; i < transaction.getNumTransItems(); i++) {
        if (temp[i] == null) {
          break;//break where element in TransactionItem list is null(empty)
        }
        String f2 = String.format("%-10s%s", temp[i].getProductUPC(), temp[i].getProdQuantity());
        writeTotranscFile.write(f2);
        writeTotranscFile.write(System.getProperty("line.separator"));
      }

      //write payment
      if (pTemp.getTypePayment().equals("CARD") || pTemp.getTypePayment().equals("Card") || pTemp.getTypePayment().equals("card")) {
        writeTotranscFile.write(pTemp.getTypePayment() + " " + pTemp.getCardNumber());
      } else {
        writeTotranscFile.write(pTemp.getTypePayment() + " $" + finTotal);
      }

      //end transaction separator
      writeTotranscFile.write(System.getProperty("line.separator"));
      writeTotranscFile.write(System.getProperty("line.separator"));

      writeTotranscFile.close();
    } catch (IOException ex) {
      Logger.getLogger(POST.class
              .getName()).log(Level.SEVERE, null, ex);
    }

  }

  //TODO: called by cashier to print the invoice
  public String getTransactionInvoice(Transaction transaction) {
    StringBuilder invoice = new StringBuilder();

    String customerName = transaction.getTransactionHeader().getCustomerName();
    String transactionDate = transaction.getTransactionHeader().getTransactionTime();
    String itemName, upc;
    double price = 0, total = 0;
    Payment payment = transaction.getPayment();

    //header
    invoice.append(store.getStoreName())
            .append("\n")
            .append(customerName)
            .append(" ")
            .append(transactionDate)
            .append("\n");

    //items
    for (TransactionItem item : transaction.getTransactionItems()) {
      upc = item.getProductUPC();
      itemName = getProductDescription(upc);
      price = getProductPrice(upc);
      total += price * item.getProdQuantity();

      invoice.append(itemName)
              .append(" @ ")
              .append(price)
              .append(" ")
              .append(total)
              .append("\n");
    }

    invoice.append("----")
            .append("Total ")
            .append(total)
            .append("\n");

    //payment
    invoice.append("Amount Tendered: ");

    String paymentType = payment.getTypePayment();
    if (paymentType.equals("Cash")) {
      double pay = payment.getPaymentTotal();
      double change = 0;

      //note: no check for not enough pay (should be in process order)
      invoice.append(payment.getPaymentTotal())
              .append("\n");

      if (pay > total) {
        change = total - pay;
        invoice.append("Amount Returned: ")
                .append("\n");
      }
    } else if (paymentType.equals("Check")) {
      invoice.append("Paid by check");
    } else if (paymentType.equals("Credit Card")) {
      invoice.append("Credit Card");
    }

    return invoice.toString();
  }

  /* Helper classes to get info from database */
  public String getStoreName() {
    return this.store.getStoreName();
  }

  public String getProductDescription(String upc) {

    for (ProductSpecification product : productCatalog) {
      if (product.getProductUPC().equals(upc)) {
        return product.getProductDesc();
      }
    }

    return "N/A";
  }

  public double getProductPrice(String upc) {

    for (ProductSpecification product : productCatalog) {
      if (product.getProductUPC().equals(upc)) {
        return product.getProductPrice();
      }
    }
    return 0;
  }

  public boolean isValidUPC(String upc) {
    for (ProductSpecification product : productCatalog) {
      if (product.getProductUPC().equals(upc)) {
        return true;
      }
    }

    return false;
  }

  private void initializeCatalog() {
    ProductReader productReader;

    try {
      productReader = new ProductReader(readFile(productPath));
      productCatalog = productReader.getProducts();

    } catch (IOException ex) {
      Logger.getLogger(POST.class
              .getName()).log(Level.SEVERE, null, ex);
    }
  }

  private String readFile(String fileName) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    try {
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();

      while (line != null) {
        sb.append(line);
        sb.append("\n");
        line = br.readLine();
      }
      return sb.toString();
    } finally {
      br.close();
    }
  }
}
