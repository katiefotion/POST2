package Customer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author: Darryl Raveche
 */
public class OrderReader {

  private String name;
  private ArrayList<CustomerList> list;
  private Scanner scanner;

  public OrderReader(String fileName) {
    list = new ArrayList();
    scanner = new Scanner(fileName);

    name = this.scanner.nextLine();

    while (this.hasMoreProducts()) {
      CustomerList listItem = this.getNextProduct();
      list.add(listItem);
    }

  }

  private boolean hasMoreProducts() {
    return (this.scanner.hasNextLine());
  }

  private CustomerList getNextProduct() {
    String line = this.scanner.nextLine();

    //Obtain the UPC of product
    String upc = "";
    for (int i = 0; i < 4; i++) {
      upc += line.charAt(i);
    }

        //Obtain the quantity of product
    //Note: possible bug with quantities > 9 (multidigit numbers)
    String quantity = line.substring(line.lastIndexOf(' ') + 1);

    // Convert quantity to int
    int intQuantity = Integer.parseInt(quantity);

    CustomerList listItem = new CustomerList(upc, intQuantity);

    return listItem;
  }

  //Setter and Getter for name

  public String getName() {
    return this.name;
  }

  // Setters for UPC and quantity 
  public void setName(String n) {
    this.name = n;
  }

  //print info for debugging purposes    
  public void printInfo() {
    System.out.println("\n\n\n\n" + name + ", These are the items that you are requesting: ");
    //loop the arrayList to list out items bought by customer
    for (int i = 0; i < list.size(); i++) {
      CustomerList temp = new CustomerList(null, 0);
      temp = list.get(i);
      System.out.println("Product UPC: " + temp.getProductUPC()
              + " Quantity: " + temp.getProdQuantity());

    }
    System.out.println("\nEnd of Customer List.");
  }
}
