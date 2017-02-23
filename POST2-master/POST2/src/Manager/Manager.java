/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import GUI.GUI;
import POST.POST;
import Store.Store;

/**
 *
 * @author Flex
 */
public class Manager {

  private Store store;

  public Manager(Store store) {
    this.store = store;
  }

  public void openStore() {
    startPOST();
    
    //String[] arguments = new String[] {""};
    //GUI.main(); 
  }

  private void startPOST() {
  }
}
