/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KhataBook;

import java.time.LocalDate;

import static KhataBook.KhataBook.input;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import java.util.Date;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
// * @author bas200181

public class Orders {

  public void addOrders(Connection con) {
    try {
      System.out.println("Enter the Phone Number");
      String phone_no = input.readLine();

      PreparedStatement ps_cb = con.prepareStatement("update Customer set cus_bal=? where customer_id=?");
      PreparedStatement ps_i = con.prepareStatement("update Orders set total_amount=? where order_id=?");
      PreparedStatement ps_h = con.prepareStatement("update product set quantity=? where product_id=?");
      PreparedStatement ps_f = con.prepareStatement("select customer_id,cus_bal from Customer where customer_phoneno=?");
      ps_f.setString(1, phone_no);
      ResultSet rs = ps_f.executeQuery();
      int getCusid = 0;
      double cus_bal = 0;
      if (rs.next()) {
        getCusid = rs.getInt(1);
        cus_bal = rs.getDouble(2);
        PreparedStatement ps_j = con.prepareStatement("insert into Orders values(?,?,?,?)");

        System.out.println("Enter the OrderID");
        int order_id = Integer.parseInt(input.readLine());
//        System.out.println("Enter the Customer_id");
//        int customer_id = Integer.parseInt(input.readLine());
        System.out.println("Enter the date");
        Date l = Date.valueOf(LocalDate.now());
        ps_j.setInt(1, order_id);
        ps_j.setInt(2, getCusid);
        ps_j.setDate(3, l);
        ps_j.setDouble(4, 0);
        ps_j.executeUpdate();

        Inventory.viewAll(con);
        double sum = 0;
        boolean add = true;

        while (add) {
          System.out.println("Enter the Product ID");

          int productId = Integer.parseInt(input.readLine());
          String prodQuery = "select * from product where product_id=" + productId;
          try (PreparedStatement ps_g = con.prepareStatement(prodQuery)) {
            ResultSet rs_a = ps_g.executeQuery();
            if (rs_a.next()) {
              String name = getName(con, productId);
              System.out.println("Enter the quantity");
              int quantity = Integer.parseInt(input.readLine());
              double price = getPrice(con, productId);
              double buyPrice = quantity * price;
              sum += buyPrice;
              PreparedStatement ps_1 = con.prepareStatement("insert into line_item values(?,?,?,?,?)");
              ps_1.setInt(1, order_id);
              ps_1.setInt(2, productId);
              ps_1.setString(3, name);
              ps_1.setInt(4, quantity);
              ps_1.setDouble(5, buyPrice);
              ps_1.executeUpdate();
              // System.out.println(+row_a + "");
              int a1 = getStack(con, productId) - quantity;
              ps_h.setInt(1, a1);
              ps_h.setInt(2, productId);
              ps_h.executeUpdate();
            } else {
              System.out.println("Please enter the valid product Id");
            }
            System.out.println("1.To Add more");
            System.out.println("2.Exit");
            System.out.println("enter the option");
            int op = Integer.parseInt(input.readLine());
            switch (op) {
              case 1:
                add = true;
                break;
              case 2:

                add = false;
                break;
            }
          }
        }
        ps_i.setDouble(1, sum);
        ps_i.setInt(2, order_id);
        ps_i.executeUpdate();
        double c_balance = sum + cus_bal;
        ps_cb.setDouble(1, c_balance);
        ps_cb.setInt(2, getCusid);
        int a = ps_cb.executeUpdate();
        System.out.println(a + "row updated");
      }
    } catch (SQLException sqe) {
      sqe.printStackTrace();
      System.err.println(sqe);
    } catch (IOException ioe) {
      ioe.printStackTrace();
      System.out.println(ioe);
    }

  }

  public void show(Connection con) {
    boolean sel_a = true;
    try {
      PreparedStatement ps_j = con.prepareStatement("select Customer.customer_id,Customer.customer_name,Customer.customer_phoneno,Customer.customer_aadhar,Customer.cus_address,Customer.cus_bal ,Orders.order_id,Orders.OrderedDate from Customer,Orders where Customer.customer_id=Orders.customer_id");
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+" + "-".repeat(10) + "+" + "-".repeat(25) + "+");
      System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|%-10s|%25s|", "Id", "customer name", "phonenumber", "Aadhar Number", "Address", "Balance", "order_id", "OrderedDate");
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+" + "-".repeat(10) + "+" + "-".repeat(25) + "+");
      ResultSet rs = ps_j.executeQuery();
      while (rs.next()) {
        System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|%-10s|%25s|", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8));
        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+" + "-".repeat(10) + "+" + "-".repeat(25) + "+");

        // System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|%-4d|%-15s" |, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8));
      }
    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }

  public static void pay(Connection con) throws IOException, SQLException {
    try {
      System.out.println("Enter  customer phonenumber to pay amount");
      String phone = input.readLine();
      view2(con, phone);
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
      int payment = Integer.parseInt(input.readLine());
      double balance = amount - price;
      PreparedStatement ps_aa = con.prepareStatement("update Customer set cus_bal=? where customer_id=?");
      PreparedStatement ps_bb = con.prepareStatement("insert into payment values(?,?,?,default)");
      ps_aa.setDouble(1, balance);
      ps_aa.setInt(2, cus_id);
      ps_aa.executeUpdate();
      ps_bb.setInt(1, payment);
      ps_bb.setInt(2, cus_id);
      ps_bb.setDouble(3, price);
      int q = ps_bb.executeUpdate();
      System.out.println(q + "inserted");
    } catch (SQLException sqe) {
      sqe.printStackTrace();
      System.err.println(sqe);
    } catch (IOException ioe) {
      ioe.printStackTrace();
      System.out.println(ioe);
    }
  }

  public static void view2(Connection con, String view_Mob) throws SQLException {
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

  public void sell(Connection con) throws IOException, SQLException {
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
                System.out.format("\n|%10s|%15s|%13s|%13s|%10s|%14s|", rs.getInt(1), rs.getInt(2) ,rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
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
                break;
              }
            }
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

  public static void productSold(Connection con, int pro_id, int quantity) {
    try (PreparedStatement po1 = con.prepareStatement("select no_of_products from soldproducts where product_id=?"); PreparedStatement po = con.prepareStatement("update product_sold set no_of_product_sold=? where product_id=?")) {
      po1.setInt(1, pro_id);
      ResultSet sd = po1.executeQuery();
      int stack = 0;
      while (sd.next()) {
        stack = sd.getInt(1);
      }
      int sold_stack = stack + quantity;
      po.setFloat(1, sold_stack);
      po.setInt(2, pro_id);
      System.out.println(po.execute());
    } catch (SQLException e) {
      System.out.println(e);
    } catch (Exception s) {
      s.printStackTrace();
    }
  }
}
