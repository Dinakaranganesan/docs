/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.sql.Connection;
import model.Inventoryy;

/**
 *
 * @author bas200181
 */
public interface ProductDao {
  public void addProduct(Inventoryy p);
  public void viewProduct(Inventoryy p);
  public void updateProduct(Inventoryy p);
   public  void viewAll();
   public  Inventoryy getProductDetails(int product_id);
   public void stockUpdate(Inventoryy inv);
   
  
}
