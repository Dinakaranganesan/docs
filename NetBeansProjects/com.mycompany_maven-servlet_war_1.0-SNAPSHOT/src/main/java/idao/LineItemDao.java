/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.sql.Connection;

/**
 *
 * @author bas200181
 */
public interface LineItemDao {
  public void addLineItems(Connection con, int orderId, int productId, String p_name, int quantity, double price);
  
}
