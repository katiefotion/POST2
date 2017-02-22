package POST;

import Cashier.Cashier;
import Customer.Customer;
import Manager.Manager;
import Store.Store;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class POSTProject {

  // Main method 
  public static void main(String[] args) throws ParserConfigurationException, SAXException {

    // Store is built, named, a manager is hired 
    Store store = new Store("Geary Street", "SellFoods");
    Manager manager = new Manager(store);
    
    // Store is opened
    manager.openStore();

    // A customer walks into the store
    Customer customer = new Customer("Charlie");
    
    // Customer places order with cashier 
    customer.placeOrder();
    
    // Cashier processes customer's order 
    Cashier cashier = new Cashier(store.getPost());
    cashier.processOrder(customer, customer.getOrder(), customer.getNumItems());
  }
}
