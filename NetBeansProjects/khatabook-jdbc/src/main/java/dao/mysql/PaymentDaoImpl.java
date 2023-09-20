/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import static dao.mysql.Input.input;
import idao.PaymentDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import model.Payment;

/**
 *
 * @author bas200181
 */
public class PaymentDaoImpl implements PaymentDao {
    @Override
    public int  pay(Connection con)  {
    try {
      System.out.println("Enter  customer phonenumber to pay amount");
      String phone = input.readLine();
      view(con, phone);
      String viewQuery = "select * from Customer where customer_phoneno=?";
      PreparedStatement ps_b = con.prepareStatement(viewQuery);
      ps_b.setString(1, phone);
      ResultSet rs = ps_b.executeQuery();
      rs.next();
      double amount = rs.getDouble(6);
      int cus_id = rs.getInt(1);

      System.out.println("Enter the amount");
      double price = Double.parseDouble(input.readLine());
      System.out.println("Enter the paymentId");
      int paymentId = Integer.parseInt(input.readLine());
      double balance = amount - price;
      PreparedStatement ps_aa = con.prepareStatement("update Customer set cus_bal=? where customer_id=?");
      PreparedStatement ps_bb = con.prepareStatement("insert into payment values(?,?,?,?)");
      Date d=Date.valueOf(LocalDate.now());
     Payment p=new Payment(paymentId, cus_id, amount,d); 
      ps_aa.setDouble(1, balance);
      ps_aa.setInt(2, cus_id);
      ps_aa.executeUpdate();
      ps_bb.setInt(1, p.getPaymentId());
      ps_bb.setInt(2, p.getCusId());
      ps_bb.setDouble(3, p.getAmount());
      ps_bb.setDate(4, p.getPaidDate());
      int q = ps_bb.executeUpdate();
      System.out.println(+balance +"amount paid");
    } catch (SQLException sqe) {
      sqe.printStackTrace();
      System.err.println(sqe);
    } catch (IOException ioe) {
      ioe.printStackTrace();
      System.out.println(ioe);
    }
    return 1;
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
