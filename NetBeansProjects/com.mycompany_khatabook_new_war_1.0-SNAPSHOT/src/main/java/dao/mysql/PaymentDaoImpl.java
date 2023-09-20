/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import idao.PaymentDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Payment;

/**
 *
 * @author bas200181
 */
public class PaymentDaoImpl implements PaymentDao {

  @Override
  public int pay(Payment p) {
    int r = 0;
    try (Connection con = MySqlConnection.createConnection(); PreparedStatement ps_b = con.prepareStatement("insert into payment values(?,?,?,default)");) {
      ps_b.setInt(1, p.getPaymentId());
      ps_b.setInt(2, p.getCusId());
      ps_b.setDouble(3, p.getAmount());
      r = ps_b.executeUpdate();
    } catch (SQLException sqe) {
      sqe.printStackTrace();
      System.err.println(sqe);
    }
    return r;
  }

  public static void view(Connection con, String view_Mob) throws SQLException {
    try {
      String viewQuery = "select * from Customer where customer_phoneno=?";
      PreparedStatement ps_b = con.prepareStatement(viewQuery);
      ps_b.setString(1, view_Mob);
      ResultSet rs = ps_b.executeQuery();
      double amount = 0;
      while (rs.next()) {
        System.out.print("Customer_id:" + "" + rs.getInt(1));
        System.out.print("Customer Name:" + "" + rs.getString(2));
        System.out.print("Customer PhoneNumber:" + "" + rs.getString(3));
        System.out.print("Customer Adhaar:" + "" + rs.getString(4));
        System.out.print("Customer Address:" + "" + rs.getString(5));
        System.out.println("Customer Balance:" + "" + rs.getDouble(6));
        amount = rs.getDouble(6);
      }
    } catch (SQLException sqe) {
      sqe.printStackTrace();
      System.err.println(sqe);
    }
  }
}
