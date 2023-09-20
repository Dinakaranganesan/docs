/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KhataBook;

//import static KhataBook.Inventory.avail_products;
import static KhataBook.KhataBook.input;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
//import java.util.Scanner;

/**
 *
 * @author bas200181
 */
public class Customer {
  private int cus_id;
  

  public Customer() {
  }

  public void add(Connection con) {
    try {
      //readCus();
      String addCust = "insert into Customer values(?,?,?,?,?,?)";
      boolean check = false;

      PreparedStatement ps_a = con.prepareStatement(addCust);
      
      System.out.println("Enter the CustomerId");
      int cus_id = Integer.parseInt(input.readLine());
      System.out.println("Enter the Customer Name");
      String cus_Name = input.readLine();
      System.out.println("Enter the Mobile Number");
      String Phone_no = "";
      while (!check) {
        Phone_no = input.readLine();
        if ((Phone_no.length() > 4) && (Phone_no.chars().filter(Character::isDigit).count() == Phone_no.length())) {
          check = true;
        } else {
          System.err.println("\u26A0 Enter a Phone Number");
        }
      }
      System.out.println("Enter the Address ");
      String cus_Address = input.readLine();
      System.out.println("Enter the Aaadhar Number");
      String Aaadhar_No = input.readLine();
      double cus_balance = 0;
      ps_a.setInt(1, cus_id);
      ps_a.setString(2, cus_Name);
      ps_a.setString(3, Phone_no);
      ps_a.setString(4, Aaadhar_No);
      ps_a.setString(5, cus_Address);
      ps_a.setDouble(6, cus_balance);
      int row = ps_a.executeUpdate();

      System.out.println(+row + "affected");
//     
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void view(Connection con) {

    try {
      String viewQuery = "select * from Customer where customer_phoneno=?";
      PreparedStatement ps_b = con.prepareStatement(viewQuery);
      System.out.println("Enter the MobileNumber:");
      String view_Mob = input.readLine();
      ps_b.setString(1, view_Mob);
      ResultSet rs = ps_b.executeQuery();
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
      System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|", "Id", "customer name", "phonenumber", "Aadhar Number", "Address", "Balance");
      System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
      while (rs.next()) {
        System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
      }

    } catch (IOException ioe) {
      System.err.println(ioe);
    } catch (SQLException sqe) {
      sqe.printStackTrace();
    }
  }

  public void update(Connection con) {
    ResultSet r;
    try {
      String updQuery = "Select * from Customer where customer_phoneno=?";
      PreparedStatement ps_c = con.prepareStatement(updQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      System.out.println("Enter the Mobile Number");
      String old_Mob = input.readLine();
      ps_c.setString(1, old_Mob);
      r = ps_c.executeQuery();
      System.out.println("excuted");
      System.out.println("Enter the NewAddress");
      String new_add = input.readLine();
      r.absolute(1);
      r.updateString(5, new_add);
      r.updateRow();

    } catch (IOException ioe) {
      System.err.println(ioe);
    } catch (SQLException sqe) {
      sqe.printStackTrace();
    }
  }

  public static void viewAll(Connection con) {
    try {
      String view_all = "Select * from Customer";
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
}
