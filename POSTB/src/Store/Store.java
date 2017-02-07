
package Store;

/**
 *
 * @author katie
 */
public class Store {
    
    private String storeAddress;
    private String storeName;
    
    public Store(String address, String name) {
        this.storeAddress = address;
        this.storeName = name;
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
