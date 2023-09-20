package KhataBook;

//import static KhataBook.Customer.writeCus;
import static KhataBook.KhataBook.input;
//import static KhataBook.rough.in;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Scanner;
import java.sql.SQLException;

public class Inventory {

  public Inventory() {

  }

  public static void view_Product(Connection con) {
    try {
      String viewQuery = "select * from product where product_id=?";
      PreparedStatement ps_e = con.prepareStatement(viewQuery);
      System.out.println("Enter the Product_id");
      int temp_id = Integer.parseInt(input.readLine());
      ps_e.setInt(1, temp_id);
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
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static void viewAll(Connection con) {
    try {
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

  public static void update_Product(Connection con) {
    ResultSet r;
    try {
      String updQuery = "Select * from product where product_id=?";
      PreparedStatement ps_c = con.prepareStatement(updQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      System.out.println("Enter the Product id");
      int product_id = Integer.parseInt(input.readLine());
      ps_c.setInt(1, product_id);
      r = ps_c.executeQuery();
      System.out.println("updated");
      System.out.println("Enter the Quantity");
      int quan = Integer.parseInt(input.readLine());
      r.absolute(1);
      r.updateInt(3, quan);
      r.updateRow();

    } catch (SQLException sqe) {
      sqe.printStackTrace();
      System.err.println(sqe);
    } catch (IOException ioe) {
      ioe.printStackTrace();
      System.out.println(ioe);
    }
  }

  public static void add_Product(Connection con) {
    try {
      String addProd = "insert into product values(?,?,?,?)";
      PreparedStatement ps_d = con.prepareStatement(addProd);
      System.out.println("Enter Product ID");
      int prod_id = Integer.parseInt(input.readLine());
      System.out.println("Enter the product name");
      String name = input.readLine();
      System.out.println("Enter the price");
      double price = Double.parseDouble(input.readLine());
      System.out.println("Enter the Quantity");
      int quantity = Integer.parseInt(input.readLine());
      ps_d.setInt(1, prod_id);
      ps_d.setString(2, name);
      ps_d.setInt(3, quantity);
      ps_d.setDouble(4, price);
      System.out.println(" Added Successfully");
      ps_d.executeUpdate();
    } catch (SQLException sqe) {
      sqe.printStackTrace();
    } catch (IOException e) {

      System.out.println(e);
      e.printStackTrace();
    }
  }

}
