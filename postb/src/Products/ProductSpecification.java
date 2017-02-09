/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

/**
 *
 * @author katie
 */
public class ProductSpecification {

  private String productDesc;
  private double productPrice;
  private String productUPC;

  // Constructor with parameters
  public ProductSpecification(String description, double price, String upc) {
    this.productDesc = description;
    this.productPrice = price;
    this.productUPC = upc;
  }

  // Getter method for product description 
  public String getProductDesc() {
    return this.productDesc;
  }

  // Getter method for product price
  public double getProductPrice() {
    return this.productPrice;
  }

  // Getter method for product upc 
  public String getProductUPC() {
    return this.productUPC;
  }

  // Setter method for product description 
  public void setProductDesc(String description) {
    this.productDesc = description;
  }

  // Setter method for product price 
  public void setProductPrice(double price) {
    this.productPrice = price;
  }

  // Setter method for product upc 
  public void setProductUPC(String upc) {
    this.productUPC = upc;
  }

  @Override
  public String toString() {
    return this.productUPC + " " + this.productDesc + " " + this.productPrice;
  }
}
