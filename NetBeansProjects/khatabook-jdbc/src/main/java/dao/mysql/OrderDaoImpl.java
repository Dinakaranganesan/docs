/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import idao.OrderDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.LineItemss;
import model.Orderrs;

/**
 *
 * @author bas200181
 */
public class OrderDaoImpl implements OrderDao {

  @Override
  public int addOrder(Orderrs o, LineItemss l[]) {
    try (PreparedStatement ps = MySqlConnection.createConnection().prepareStatement("insert into Orders values(?,?,default,?)"); PreparedStatement ps1 = MySqlConnection.createConnection().prepareStatement("insert into line_item values(?,?,?,?,?)");) {
      ps.setInt(1, o.getOrderID());
      ps.setInt(2, o.getCusId());
      ps.setDouble(3, o.getTotalprice());
      ps.execute();
      for (int i = 0; i < l.length; i++) {
        ps1.setInt(1, l[i].getOrderId());
        ps1.setInt(2, l[i].getProductId());
        ps1.setString(3, l[i].getProName());
        ps1.setInt(4, l[i].getQuantity());
        ps1.setDouble(5, l[i].getPrice());
        ps1.execute();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return 1;

  }

  public static String getName(Connection con, int product_id) {

    String name = null;
    try (
            PreparedStatement ps1 = con.prepareStatement("select product_name from product where product_id=?");) {
      ps1.setInt(1, product_id);
      ResultSet rs = ps1.executeQuery();
      while (rs.next()) {
        name = rs.getString(1);
      }
    } catch (SQLException e) {
      System.out.println(e);
    }
    return name;
  }

  public static double getPrice(Connection con, int product_id) {
    double pri = 0;
    try (PreparedStatement ps2 = con.prepareStatement("select price from product where product_id=?");) {
      ps2.setDouble(1, product_id);
      ResultSet rs1 = ps2.executeQuery();
      System.out.println("query execute");
      while (rs1.next()) {
        pri = rs1.getDouble(1);
      }
      System.out.println(pri);
    } catch (SQLException e) {
      System.out.println(e);
    }
    return pri;
  }

  public static int getStack(Connection con, int pro_id) {
    int stack = 0;
    try (PreparedStatement ps2 = con.prepareStatement("select quantity from product where product_id=?");) {
      ps2.setInt(1, pro_id);
      ResultSet rs1 = ps2.executeQuery();
      System.out.println("query execute");
      while (rs1.next()) {
        stack = rs1.getInt(1);
      }
      System.out.println(stack);
    } catch (SQLException e) {
      System.out.println(e);
    }
    return stack;
  }

  public void show() {
    //  boolean sel_a = true;
    try {
      PreparedStatement ps_j = MySqlConnection.createConnection().prepareStatement("select Customer.customer_id,Customer.customer_name,Customer.customer_phoneno,Customer.customer_aadhar,Customer.cus_address,Orders.total_amount ,Orders.order_id,Orders.OrderedDate from Customer,Orders where Customer.customer_id=Orders.customer_id");
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(25) + "+");
      System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%10s|%-10s|%25s|", "Id", "customer name", "phonenumber", "Aadhar Number", "Address", "or_amount", "order_id", "OrderedDate");
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(25) + "+");
      ResultSet rs = ps_j.executeQuery();
      while (rs.next()) {
        System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%10s|%-10s|%25s|", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8));
        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(25) + "+");

        // System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|%-4d|%-15s" |, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8));
      }
    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }
}
