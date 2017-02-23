package Store;

import GUI.GUI;
import NetClientGet.NetClientGet;
import POST.POST;
import Products.ProductCatalog;
import Products.ProductSpecification;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author katie
 */
public class Store {

  private String storeAddress;
  private String storeName;
  private ProductCatalog catalog;
  private POST post;
  private GUI postGUI;

  public Store(String address, String name) throws ParserConfigurationException, SAXException {
    this.storeAddress = address;
    this.storeName = name;
  }
  
  public void openStore() throws ParserConfigurationException, SAXException {
      
    initializeCatalog(); //note, catalog needs to be initialized before passing store to post for now...
    this.post = new POST(this);
    
    postGUI = new GUI(post);
    postGUI.start(this.post);
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

  private void initializeCatalog() throws ParserConfigurationException, SAXException {
    List<ProductSpecification> products = NetClientGet.getProducts();

    this.catalog = new ProductCatalog(products);
  }
}
