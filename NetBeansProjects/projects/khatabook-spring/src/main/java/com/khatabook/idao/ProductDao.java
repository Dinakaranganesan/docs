/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.khatabook.idao;

import java.sql.Connection;
import java.util.List;
import com.khatabook.model.Inventory;

/**
 *
 * @author bas200181
 */
public interface ProductDao {

  public int addProduct(Inventory p);

  public List<Inventory> viewProduct(int productId);

  public int updateProduct(Inventory p);

  public List<Inventory> viewAll();

  public Inventory getProductDetails(int product_id);

  public void stockUpdate(Inventory inv);

}
