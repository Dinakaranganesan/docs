/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.cusomerrepository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.khatabook.model.Customer;
import com.khatabook.model.OrderedDetails;
import com.khatabook.model.PaymentDetails;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bas200181
 */
@Repository
public class Statistics {

  public List<Customer> getPaidCustomer()  {

    List<Customer> ls = new ArrayList<>();
    try (PreparedStatement pg = MySqlConnection.createConnection().prepareStatement("select * from Customer where cus_bal  in (0)")) {
      ResultSet rs = pg.executeQuery();
      while (rs.next()) {
        ls.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
      }
    }
    catch (SQLException se) {
      se.printStackTrace();
    }
 return ls;
 
  }

  public List<Customer> getUnPaidCustomer() {

    List<Customer> ls1 = new ArrayList<>();
    try (PreparedStatement pg1 = MySqlConnection.createConnection().prepareStatement("select * from Customer where cus_bal  not in (0)")) {
      ResultSet rs = pg1.executeQuery();
      while (rs.next()) {
        ls1.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
      }

    } catch (SQLException se) {
      se.printStackTrace();
    }
    return ls1;
  }

  public List<PaymentDetails> getPaymentDetails() {

    List<PaymentDetails> ls1 = new ArrayList<>();
    try (PreparedStatement pg2 = MySqlConnection.createConnection().prepareStatement("select * from Customer,payment where Customer.customer_id=payment.customer_id order by paid_date")) {
      ResultSet rs = pg2.executeQuery();
      while (rs.next()) {
        ls1.add(new PaymentDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(7), rs.getDouble(9), rs.getDate(10)));
      }
    } catch (SQLException se) {
      se.printStackTrace();
    }
    return ls1;
  }

  public List<OrderedDetails> getOrdersByDate(Date date) {
    List<OrderedDetails> ls1 = new ArrayList<>();
    try (PreparedStatement pg3 = MySqlConnection.createConnection().prepareStatement("select * from Customer join Orders on Customer.customer_id=Orders.customer_id where OrderedDate=? order by OrderedDate");) {
      pg3.setDate(1, date);
      ResultSet rs = pg3.executeQuery();
      while (rs.next()) {
        ls1.add(new OrderedDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(7), rs.getDate(9), rs.getDouble(10)));
      }

    } catch (SQLException se) {
      se.printStackTrace();
    }
    return ls1;
  }

  public List<OrderedDetails> getOrdersByRange(Date d1, Date d2) throws SQLException {
    List<OrderedDetails> ls1 = new ArrayList<>();
    try (PreparedStatement pg4 = MySqlConnection.createConnection().prepareStatement("select * from Customer join Orders on Customer.customer_id=Orders.customer_id where OrderedDate between ? and ?");) {
      pg4.setDate(1, d1);
      pg4.setDate(2, d2);
      ResultSet rs = pg4.executeQuery();
      while (rs.next()) {
        ls1.add(new OrderedDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(7), rs.getDate(9), rs.getDouble(10)));
      }

    } catch (SQLException se) {
      se.printStackTrace();
    }
    return ls1;
  }

}
