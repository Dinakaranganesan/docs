/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import static dao.mysql.Input.input;
import idao.CustomerDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customerr;

/**
 *
 * @author bas200181
 */
public class CustomerDaoImpl implements CustomerDao {

  public static MySqlConnection mys = new MySqlConnection();

  @Override
  public void addCustomer(Customerr c) {

    String addCust = "insert into Customer values(?,?,?,?,?,?)";

    try (Connection con = getMys().createConnection(); PreparedStatement ps_a = con.prepareStatement(addCust);) {

      ps_a.setInt(1, c.getCusId());
      ps_a.setString(2, c.getCusName());
      ps_a.setString(3, c.getPhoneNo());
      ps_a.setString(4, c.getCusAadhaar());
      ps_a.setString(5, c.getCusAddress());
      ps_a.setDouble(6, c.getCusBal());
      int row = ps_a.executeUpdate();

      System.out.println(+row + "affected");
//     
    } catch (Exception e) {
      e.printStackTrace();
    }

//    return 1;
  }

  @Override
  public void updateCustomer(Customerr c) {
    String updQry = "update Customer set cus_address=? where customer_phoneno=?";
    try (Connection con = getMys().createConnection(); PreparedStatement ps_b = con.prepareStatement(updQry);) {
      ps_b.setString(1, c.getCusAddress());
      ps_b.setString(2, c.getPhoneNo());
      int row = ps_b.executeUpdate();
      System.out.println("address Updated");
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  @Override
  public void viewCustomer(Customerr c) {
    String viewQuery = "select * from Customer where customer_phoneno=?";
    try (Connection con = getMys().createConnection(); PreparedStatement ps_a = con.prepareStatement(viewQuery)) {
      PreparedStatement ps_b = con.prepareStatement(viewQuery);
      ps_b.setString(1, c.getPhoneNo());
      ResultSet rs = ps_b.executeQuery();
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
      System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|", "Id", "customer name", "phonenumber", "Aadhar Number", "Address", "Balance");
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
      while (rs.next()) {
        System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
      }

    } catch (SQLException sqe) {
      sqe.printStackTrace();
    }
  }

  @Override
  public void viewAll() {
     String view_all = "Select * from Customer";
      try (Connection con = getMys().createConnection(); PreparedStatement ps_c = con.prepareStatement(view_all)){
     
      PreparedStatement ps_d = con.prepareStatement(view_all);
      ResultSet rs1 = ps_d.executeQuery();
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
      System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|", "Id", "customer name", "phonenumber", "Aadhar Number", "Address", "Balance");
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
      while (rs1.next()) {
        System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|", rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getDouble(6));
        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");

      }
    } catch (SQLException sqe) {
      sqe.printStackTrace();
    }
  }
//  
//  public static void main(String[] args) {
////     CustomerDaoImpl cd=new CustomerDaoImpl();
////     cd.addCustomer();
//
//System.out.println("testing");
//    
//  }

  public void stats(Connection con) {
    boolean sts = true;
    try {
      do {
        System.out.println("");
        System.out.println("1.paid customers");
        System.out.println("2.Not paid customers");
        System.out.println("3.customer payment details");
        System.out.println("4.order placed on particular date");
        System.out.println("5. Order placed between dates");
        System.out.println("6.Exit");
        System.out.println("Enter the option");
        int st = Integer.parseInt(input.readLine());
        switch (st) {
          case 1: {
            PreparedStatement pg = con.prepareStatement("select * from Customer where cus_bal  in (0)");
            ResultSet d = pg.executeQuery();
            System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
            System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|", "CID", "customer name", "phonenumber", "Aadhar", "Address", "cus_bal");
            System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
            while (d.next()) {
              System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|", d.getInt(1), d.getString(2), d.getString(3), d.getString(4), d.getString(5), d.getDouble(6));
              System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
            }
            break;
          }
          case 2: {
            PreparedStatement pg = con.prepareStatement("select * from Customer where cus_bal not in (0)");
            ResultSet d = pg.executeQuery();
            System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
            System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|", "CID", "customer name", "phonenumber", "Aadhar", "Address", "cus_bal");
            System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
//            System.out.printf("%10s%15s%13s%10s%15s%15s", "customer_id", "name", "phonenumber", "aadhar", "adress", "cus_balance");
//            System.out.println();
            while (d.next()) {
              System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|", d.getInt(1), d.getString(2), d.getString(3), d.getString(4), d.getString(5), d.getDouble(6));
              System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
//              System.out.printf("%10s%15s%13s%13s%15s%14s", d.getInt(1), d.getString(2), d.getString(3), d.getString(4), d.getString(5), d.getDouble(6));
//              System.out.println();
            }
            break;
          }
          case 3: {
            // PreparedStatement pg1 = con.prepareStatement("select * from payment ");
            PreparedStatement pg3 = con.prepareStatement("select payment.payment_id,payment.customer_id,Customer.customer_name,Customer.cus_address ,payment.amount,payment.paid_date from Customer,payment where Customer.customer_id=payment.customer_id");
            ResultSet rs = pg3.executeQuery();
//            PreparedStatement pg = con.prepareStatement("select customer_name,cus_address from Customer where customer_id=?");
//            ResultSet d1 = pg1.executeQuery();

//            while (d1.next()) {
//              int cus_id = d1.getInt(2);
//              pg.setInt(1, cus_id);
//              ResultSet d = pg.executeQuery();
            System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(15) + "+" + "-".repeat(13) + "+" + "-".repeat(13) + "+" + "-".repeat(10) + "+" + "-".repeat(14) + "+");
            System.out.format("\n|%10s|%15s|%13s|%13s|%10s|%14s|", "pay_id", "cus_id", "name", "Addresss", "Amount", "paid_date");
            System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(15) + "+" + "-".repeat(13) + "+" + "-".repeat(13) + "+" + "-".repeat(10) + "+" + "-".repeat(14) + "+");
//              System.out.printf("%10s%15s%13s%10s%15s%15s", "payment_id", "customer_id", "name", "Address", "Amount", "Dateofpayment");
//              System.out.println();
            while (rs.next()) {
              System.out.format("\n|%10s|%15s|%13s|%13s|%10s|%14s|", rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
              System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(15) + "+" + "-".repeat(13) + "+" + "-".repeat(13) + "+" + "-".repeat(10) + "+" + "-".repeat(14) + "+");
//                System.out.printf("%10s%15s%13s%13s%10s%14s", d1.getInt(1), cus_id, d.getString(1), d.getString(2), d1.getDouble(3), d1.getDate(4));
//                System.out.println();
              // }
            }
            break;
          }
          case 4: {
            System.out.println("Enter the DATE  (format yyyy-mm-dd");
            Date date = Date.valueOf(input.readLine());

            PreparedStatement pg1 = con.prepareStatement("select * from Orders  where OrderedDate=?");

            PreparedStatement pg = con.prepareStatement("select customer_name,cus_address from Customer where customer_id=?");
            pg1.setDate(1, date);
            ResultSet d1 = pg1.executeQuery();
            System.out.printf("%10s%15s%13s%17s%20s%15s", "Order_id", "customer_id", "name", "Address", "DateofOrder", "Total_Amount");
            while (d1.next()) {
              int cus_id = d1.getInt(2);
              pg.setInt(1, cus_id);
              ResultSet d = pg.executeQuery();

              System.out.println();
              while (d.next()) {
                System.out.printf("%10s%15s%13s%17s%20s%14s", d1.getInt(1), cus_id, d.getString(1), d.getString(2), d1.getDate(3), d1.getDouble(4));
                System.out.println();
              }

            }
            break;
          }
          case 5: {
            System.out.println("Enter stating the DATE  (format yyyy-mm-dd");

            Date date = Date.valueOf(input.readLine());

            System.out.println("Enter stating the DATE  (format yyyy-mm-dd");
            Date date1 = Date.valueOf(input.readLine());
            PreparedStatement pg1 = con.prepareStatement("select * from Orders  where OrderedDate between ? and?");

            PreparedStatement pg = con.prepareStatement("select customer_name,cus_address from Customer where customer_id=?");
            pg1.setDate(1, date);
            pg1.setDate(2, date1);
            ResultSet d1 = pg1.executeQuery();
            System.out.printf("%10s%15s%13s%17s%20s%15s", "Order_id", "customer_id", "name", "Address", "DateofOrder", "Total_Amount");
            while (d1.next()) {
              int cus_id = d1.getInt(2);
              pg.setInt(1, cus_id);
              ResultSet d = pg.executeQuery();

              System.out.println();
              while (d.next()) {
                System.out.printf("%10s%15s%13s%17s%20s%14s", d1.getInt(1), cus_id, d.getString(1), d.getString(2), d1.getDate(3), d1.getDouble(4));
                System.out.println();
              }
            }
            break;
          }
          case 6: {
            sts = false;
            break;
          }
          default: {
            System.err.println("Enter Correct Option");
            break;
          }
        }

      } while (sts);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
  @Override
  public void updateCustomerBalance(Customerr cu) 
{
  
    try {
      PreparedStatement ps = MySqlConnection.createConnection().prepareStatement("update Customer set cus_bal=? where customer_id=?");
      ps.setDouble(1, cu.getCusBal());
      ps.setInt(2, cu.getCusId());
      ps.executeUpdate();
    } catch (SQLException ex) {
    ex.printStackTrace();
    }

}
  @Override
   public Customerr getCusdetails(String phone_no) {
     Customerr cus=null;
     try{
     Connection connection=MySqlConnection.createConnection();
      
      PreparedStatement ps_f = connection.prepareStatement("select * from Customer where customer_phoneno=?");
      ps_f.setString(1, phone_no);
      ResultSet rs = ps_f.executeQuery();
      
      rs.next();
       cus=new Customerr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
     }catch(Exception e){
       e.printStackTrace();
     }
    return cus;
}

  /**
   * @return the mys
   */
  public static MySqlConnection getMys() {
    return mys;
  }

  /**
   * @param aMys the mys to set
   */
  public static void setMys(MySqlConnection aMys) {
    mys = aMys;
  }

}
