/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.sql.Connection;
import java.util.List;
import model.Inventoryy;

/**
 *
 * @author bas200181
 */
public interface ProductDao {

  public int addProduct(Inventoryy p);

  public List<Inventoryy> viewProduct(int productId);

  public int updateProduct(Inventoryy p);

  public List<Inventoryy> viewAll();

  public Inventoryy getProductDetails(int product_id);

  public void stockUpdate(Inventoryy inv);

}
