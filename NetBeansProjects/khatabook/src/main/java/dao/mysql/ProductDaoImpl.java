/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import static dao.mysql.CustomerDaoImpl.mys;
import static dao.mysql.Input.input;
import idao.ProductDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Inventoryy;

/**
 *
 * @author bas200181
 */
public class ProductDaoImpl implements ProductDao {
  @Override
    public  Inventoryy getProductDetails(int product_id) {
     Inventoryy inv=null;
    try {
      String viewQuery = "select * from product where product_id=?";
      
      PreparedStatement ps_e = MySqlConnection.createConnection().prepareStatement(viewQuery);
//      System.out.println("Enter the Product_id");
//     int temp_id = Integer.parseInt(input.readLine());
      ps_e.setInt(1, product_id);
      ResultSet rs3 = ps_e.executeQuery();
      rs3.next();
      inv=new Inventoryy(rs3.getInt(1),rs3.getString(2),rs3.getInt(3),rs3.getDouble(4));
//     inv.setProductId(rs3.getInt(1));
//      inv.setProName(rs3.getString(2));
//      inv.setQuantity(rs3.getInt(3));
//      inv.setPrice(rs3.getDouble(4));
    }catch(Exception e){
      e.printStackTrace();
    }
    return inv;
}
   
    @Override
   public void stockUpdate(Inventoryy inv) {
      try {
        PreparedStatement ps_h = MySqlConnection.createConnection().prepareStatement("update product set quantity=? where product_id=?");
        ps_h.setInt(1, inv.getQuantity());
        ps_h.setInt(2, inv.getProductId());
        ps_h.executeUpdate();
      } catch (SQLException ex) {
        Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
   

  @Override
  public void addProduct(Inventoryy p) {
    String addProd = "insert into product values(?,?,?,?)";
    try (Connection con = mys.createConnection()) {
      PreparedStatement ps_d = con.prepareStatement(addProd);
      ps_d.setInt(1, p.getProductId());
      ps_d.setString(2, p.getProName());
      ps_d.setInt(3, p.getQuantity());
      ps_d.setDouble(4, p.getPrice());
      System.out.println(" Added Successfully");
      ps_d.executeUpdate();
    } catch (SQLException sqe) {
      sqe.printStackTrace();
    }
  }

  @Override
  public void viewProduct(Inventoryy i) {
    try {
      String viewQuery = "select * from product where product_id=?";
      Connection con = mys.createConnection();
      PreparedStatement ps_e = con.prepareStatement(viewQuery);

      ps_e.setInt(1, i.getProductId());
      ResultSet rs3 = ps_e.executeQuery();

      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(15) + "+");
      System.out.format("\n|%-4s|%-25s|%10s|%-15s|", "p_id", "product_name", "quantity", "product_price");
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(15) + "+");
      while (rs3.next()) {
        System.out.format("\n|%-4d|%-25s|%10s|%-15s|", rs3.getInt(1), rs3.getString(2), rs3.getInt(3), rs3.getString(4));
        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(15) + "+");
      }

    } catch (SQLException sqe) {
      System.err.println(sqe);
    }
  }

  @Override
  public void updateProduct(Inventoryy i) {
    ResultSet r;
    try {
      String updQuery = "Select * from product where product_id=?";
      Connection connection = mys.createConnection();
      PreparedStatement ps_c = connection.prepareStatement(updQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

      ps_c.setInt(1, i.getProductId());
      r = ps_c.executeQuery();
      System.out.println("updated");

      r.absolute(1);
      r.updateInt(3, i.getQuantity());
      r.updateRow();

    } catch (SQLException sqe) {
      sqe.printStackTrace();
      System.err.println(sqe);
    }

  }

  @Override
  public void viewAll() {
    try {
      Connection con = mys.createConnection();
      String view_all = "Select * from product";
      PreparedStatement ps_d = con.prepareStatement(view_all);
      ResultSet rs2 = ps_d.executeQuery();
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(15) + "+");
      System.out.format("\n|%-4s|%-25s|%10s|%-15s|", "p_id", "product_name", "quantity", "product_price");
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(15) + "+");
      while (rs2.next()) {
        System.out.format("\n|%-4d|%-25s|%10s|%-15s|", rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getString(4));
        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(15) + "+");
      }

    } catch (SQLException sqe) {
      sqe.printStackTrace();
    }
  }
}
