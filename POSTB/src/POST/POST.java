/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POST;

import Customer.OrderReader;
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
  private String productPath;
  private String cListPath;
  private String transactionPath;

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

  public void printCatalog() {
    for (ProductSpecification product : productCatalog) {
      System.out.println(product.toString());
    }
  }

  private void initializeCatalog() {
    ProductReader productReader;
    
    try {
      productReader = new ProductReader(readFile(productPath));
      productCatalog = productReader.getProducts();
    } catch (IOException ex) {
      Logger.getLogger(POST.class.getName()).log(Level.SEVERE, null, ex);
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
