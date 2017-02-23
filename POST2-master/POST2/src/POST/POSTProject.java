package POST;

import Store.Store;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class POSTProject {

  // Main method 
  public static void main(String[] args) throws ParserConfigurationException, SAXException {

    // Store is built, named, a manager is hired 
    Store store = new Store("Geary Street", "SellFoods");
    store.openStore();
  }
}
