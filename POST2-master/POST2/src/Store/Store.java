package Store;

import Manager.Manager;
import POST.POST;
import Products.ProductCatalog;
import Products.ProductSpecification;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author katie
 */
public class Store {

  private String storeAddress;
  private String storeName;
  private ProductCatalog catalog;
  private POST post; //assume store only has one POST, otherwise this would be a list

  public Store(String address, String name) {
    this.storeAddress = address;
    this.storeName = name;
    
    initializeCatalog(); //note, catalog needs to be initialized before passing store to post for now...
    this.post = new POST(this);
  }

  public POST getPost() {
    return this.post;
  }

  public ProductCatalog getProductCatalog() {
    return this.catalog;
  }

  // Getter method for store address
  public String getStoreAddress() {
    return this.storeAddress;
  }

  // Getter method for store name
  public String getStoreName() {
    return this.storeName;
  }

  // Setter method for store address
  public void setStoreAddress(String address) {
    this.storeAddress = address;
  }

  // Setter method for store name 
  public void setStoreName(String name) {
    this.storeName = name;
  }

  private void initializeCatalog() {
    List<ProductSpecification> products = new ArrayList<>();

    products.add(new ProductSpecification("Tomato", 2.5, "1234"));
    products.add(new ProductSpecification("Baked Beans", 1.78, "13"));

    this.catalog = new ProductCatalog(products);
  }

}
