package POST;

import Cashier.Cashier;
import Customer.Customer;
import Manager.Manager;
import Store.Store;

public class POSTProject {

  // Main method 
  public static void main(String[] args) {

    // Store is built, named, a manager is hired 
    Store store = new Store("Geary Street", "SellFoods");
    Manager manager = new Manager(store);
    
    // Store is opened
    manager.openStore();

    // A customer walks into the store
    Customer customer = new Customer("Charlie");
    
    // The customer interacts with cashier to place order (via cmd line, write to transaction.txt)
    
    // The customer's order is processed (i.e. read from transaction.txt most recent transaction)  
    customer.placeOrder();
    
    // The customer's invoice is printed
    
    
    
    Cashier cashier = new Cashier(store.getPost());
    cashier.processOrder(customer, customer.getOrder(), customer.getNumItems());
  }
}
