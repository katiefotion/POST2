/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Felix Chan Lee
 */
public class ProductCatalog {

  private List<ProductSpecification> products;
  private Map<String, ProductSpecification> upcToProduct;

  public ProductCatalog() {
    products = new ArrayList<>();
    upcToProduct = new HashMap<>();

    init();
  }

  public ProductCatalog(List<ProductSpecification> products) {
    this.products = products;
    upcToProduct = new HashMap<>();

    init();
  }

  public ProductSpecification getProductByUPC(String upc) {
    if (upcToProduct.get(upc) != null) {
      return upcToProduct.get(upc);
    }
    
    return null;
  }
  public List<ProductSpecification> getProductList(){
      return products;
  }

  private void init() {
    String upc = "";

    for (ProductSpecification product : products) {
      upc = product.getProductUPC();
      upcToProduct.put(upc, product);
    }
  }
}
