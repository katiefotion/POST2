package Customer;

   /**
   *
   * @author: Darryl Raveche
   */
   
public class CustomerList {
    
    private String productUPC; 
    private int prodQuantity;
    
    
    // Constructor with parameters
    public CustomerList(String upc, int quantity) {
        this.productUPC = upc;
        this.prodQuantity = quantity;
    }
    
    // Getters for UPC and quantity 
    public int getProdQuantity() {
        return this.prodQuantity;
    }    
    public String getProductUPC() {
        return this.productUPC;
    }
    
    // Setters for UPC and quantity 
    public void setProdQuantity(int quantity) {
        this.prodQuantity = quantity;
    }
    public void setProductUPC(String upc) {
        this.productUPC = upc;
    }

   
}