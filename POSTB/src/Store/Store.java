
package Store;

import Manager.Manager;
import POST.POST;

/**
 *
 * @author katie
 */
public class Store {
  
    private String storeAddress;
    private String storeName;
    private POST post; //assume store only has one POST, otherwise this would be a list
    
    public Store(String address, String name) {
        this.storeAddress = address;
        this.storeName = name;
        this.post = new POST();
    }
    
    public POST getPost() {
      return this.post;
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
}
