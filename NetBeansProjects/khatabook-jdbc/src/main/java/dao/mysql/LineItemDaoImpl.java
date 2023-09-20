/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import idao.LineItemDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LineItemss;

/**
 *
 * @author bas200181
 */
public class LineItemDaoImpl implements LineItemDao {

  @Override
  public void addLineItems(Connection con, int orderId, int productId, String p_name, int quantity, double price) {
    LineItemss li = new LineItemss(orderId, productId, p_name, quantity, price);
    PreparedStatement ps_l;
    try {
      ps_l = con.prepareStatement("insert into line_item values(?,?,?,?,?)");

      ps_l.setInt(1, li.getOrderId());
      ps_l.setInt(2, li.getProductId());
      ps_l.setString(3, li.getProName());
      ps_l.setInt(4, li.getQuantity());
      ps_l.setDouble(5, li.getPrice());
      ps_l.executeUpdate();
    } catch (SQLException sqe) {
      sqe.printStackTrace();

    }
  }
}
