package POST;

import Manager.Manager;
import Store.Store;

public class POSTProject {

  // Main method 
  public static void main(String[] args) {
    
    Manager manager = new Manager(new Store("Geary Street", "SellFoods"));
    manager.openStore();
    
        
  }
}
