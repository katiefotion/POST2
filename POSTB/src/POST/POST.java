/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POST;

import Customer.Customer;
import Products.ProductReader;
import Products.ProductSpecification;
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
import java.text.DecimalFormat;

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
    productPath ="/Users/darrylraveche/Downloads/POSTB-master 2/POSTB/src/TextFiles/products.txt";
    cListPath = "/Users/darrylraveche/Downloads/POSTB-master 2/POSTB/src/TextFiles/customerorder.txt";
    transactionPath = "/Users/darrylraveche/NetBeansProjects/CSC668Project/POSTBFINAL/POSTB/src/TextFiles/transaction.txt";
    
    // Changed from C:\\Users\\Flex\\Documents\\NetBeansProjects\\POSTB\\POSTB\\src\\...

    productCatalog = new ArrayList<>();
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
      
        for(int i = 0; i < transaction.getNumTransItems(); i++)
        {
            if(temp[i] == null)
            {
                break;//break where element in TransactionItem list is null(empty)
            }
            quantity = temp[i].getProdQuantity();
            System.out.println("quantity: " + quantity);
            tempUPC = temp[i].getProductUPC();
            price = getProductPrice(tempUPC);
            tempTotal = price * quantity;
            
            finalTotal = finalTotal + tempTotal;  
            
            //System.out.println("Temp Total: $" + tempTotal + "Final Total: $" + finalTotal);
        }
        String finTotal = String.format("%.2f", finalTotal);
        System.out.println("The Final total is: $" + finTotal);
        
        
        //writing customer info to transaction  
       FileWriter cFile;
       BufferedWriter writeTotranscFile;
       String cReturn = String.format("%n");
        try {
            writeTotranscFile = new BufferedWriter(new FileWriter(transactionPath, true));
            
            //write header
            TransactionHeader hTemp = transaction.getTransactionHeader();
            writeTotranscFile.write(hTemp.getCustomerName());
            writeTotranscFile.write("      ");
            writeTotranscFile.write(hTemp.getTransactionTime());
            writeTotranscFile.write(System.getProperty( "line.separator" ));
            
            writeTotranscFile.write("Item");
            writeTotranscFile.write(System.getProperty( "line.separator" ));
           //write items
           for(int i = 0; i < transaction.getNumTransItems(); i++)
           {
            if(temp[i] == null)
                {
                    break;//break where element in TransactionItem list is null(empty)
                }
            writeTotranscFile.write(temp[i].getProductUPC() + "      " + temp[i].getProdQuantity());
            writeTotranscFile.write(System.getProperty( "line.separator" ));
           }
           //separator
           writeTotranscFile.write("Item");
           writeTotranscFile.write(System.getProperty( "line.separator" ));
           
           //write payment
           Payment pTemp = transaction.getPayment();
           writeTotranscFile.write("Payment: " + pTemp.getTypePayment() + " $" + finTotal);

           //end separator
           writeTotranscFile.write(System.getProperty( "line.separator" ));
           writeTotranscFile.write(System.getProperty( "line.separator" ));
           
           writeTotranscFile.close();
           System.out.println("Successfuly written to transaction file.");
        }
            
         catch (IOException ex) {
             Logger.getLogger(POST.class
             .getName()).log(Level.SEVERE, null, ex);
    }
        
        //writing customer info to transaction
            
    
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

  /* Debug methods */
  public void printCatalog() {
    for (ProductSpecification product : productCatalog) {
      System.out.println(product.toString());
    }
  }
}
