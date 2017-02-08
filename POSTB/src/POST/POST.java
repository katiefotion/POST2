/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POST;

import Customer.Customer;
import Products.ProductReader;
import Products.ProductSpecification;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Flex
 */
public class POST {

  // Define filepaths to product, customer list and transaction files 
  private final String productPath;
  private final String cListPath;
  private final String transactionPath;

  private List<ProductSpecification> productCatalog;

  public POST() {
    productPath = "C:\\Users\\Flex\\Documents\\NetBeansProjects\\POSTB\\POSTB\\src\\TextFiles\\products.txt";
    cListPath = "C:\\Users\\Flex\\Documents\\NetBeansProjects\\POSTB\\POSTB\\src\\TextFiles\\customerorder.txt";
    transactionPath = "C:\\Users\\Flex\\Documents\\NetBeansProjects\\POSTB\\POSTB\\src\\TextFiles\\transaction.txt";

    productCatalog = new ArrayList<>();
  }

  public void start() {
    initializeCatalog();

    //printCatalog();
  }
  
  //TODO: called to store the transaction
  public void processTransaction(Customer customer, List<ProductSpecification> orderItems) {
    
  }
  
  //TODO: called by cashier to print the invoice
  public String getTransactionInvoice() {
    return "";
  }

  /* Helper classes to get info from database */
  public String getProductDescription(String upc) {

    for (ProductSpecification product : productCatalog) {
      if (product.getProductUPC().equals(upc)) {
        return product.getProductDesc();
      }
    }

    return "N/A";
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

  /* Debug methods */
  public void printCatalog() {
    for (ProductSpecification product : productCatalog) {
      System.out.println(product.toString());
    }
  }
}
