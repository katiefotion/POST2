package POST;

import Cashier.Cashier;
import Customer.Customer;
import Manager.Manager;
import Store.Store;

public class POSTProject {

  // Main method 
  public static void main(String[] args) {

    Store store = new Store("Geary Street", "SellFoods");
    Manager manager = new Manager(store);

    manager.openStore();

    Customer customer = new Customer("Charlie");
    customer.placeOrder();
    customer.printOrder();
    
    Cashier cashier = new Cashier(store.getPost());
    cashier.processOrder(customer, customer.getOrder());
  }
}
