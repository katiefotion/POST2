package Products;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Katie Fotion
 */
public class ProductReader {

  private Scanner scanner;
  private ArrayList<ProductSpecification> products;

  // Constructor method
  public ProductReader(String productFile) {

    products = new ArrayList();
    scanner = new Scanner(productFile);
    while (this.hasMoreProducts()) {
      ProductSpecification productSpec = this.getNextProduct();
      products.add(productSpec);
    }
    
  }

  public ArrayList<ProductSpecification> getProducts() {
    return products;
  }

  public void printInfo() {
    //loop the arrayList of products to display info about the product
    for (int i = 0; i < products.size(); i++) {
      ProductSpecification temp = new ProductSpecification(null, 0, null);
      temp = products.get(i);
      System.out.println("Product: " + temp.getProductDesc()
              + "Price: " + temp.getProductPrice() + " UPC: " + temp.getProductUPC());

    }
    System.out.println("\nEnd of Product Catalog.");
  }

  private boolean hasMoreProducts() {
    return (this.scanner.hasNextLine());
  }

  private ProductSpecification getNextProduct() {
    String line = this.scanner.nextLine();

    // Access upc 
    String upc = "";
    for (int i = 0; i < 4; i++) {
      upc += line.charAt(i);
    }
    upc = upc.replace(" ", "");
    
    // Access text desription
    String textDesc = "";
    for (int i = 9; i < 29; i++) {
      textDesc += line.charAt(i);
    }

    // Access price
    String priceStr = "";
    for (int i = 34; i < line.length(); i++) {
      priceStr += line.charAt(i);
    }
    

    // Convert price to double
    double price = Double.parseDouble(priceStr);

    // Initialize new ProductSpecification object
    ProductSpecification productSpec = new ProductSpecification(textDesc, price, upc);

    return productSpec;

  }
}
