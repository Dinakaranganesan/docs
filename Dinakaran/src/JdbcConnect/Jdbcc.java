/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcConnect;

import java.sql.Connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.*;

//public class Jdbcc {
//
//  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//  static CRUDOP crud = new CRUDOP();
//
//  public static void main(String[] args) throws IOException, SQLException {
//    String url = "jdbc:mysql://bassure.in:3306/dina_b8_db";
//    String uname = "dina_07";
//    String pass = "dinaBA81";
//
//    boolean exit = true;
//    Connection con = DriverManager.getConnection(url, uname, pass);
//    System.out.println("connected.....");
//    System.out.println("1.Insert Customer");
//    System.out.println("2.Update Customer");
//    System.out.println("3.Exit");
//    while (exit) {
//      int sel = Integer.parseInt(br.readLine());
//      switch (sel) {
//        case 1:
//          crud.ins(con);
//          break;
//        case 2:
//          crud.update(con);
//          break;
//        case 3:
//          exit = false;
//          break;
//      }
//    }
//  }
//
//}
public class Jdbcc {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static CRUDOP crud = new CRUDOP();

  public static void main(String[] args) throws IOException, SQLException {
    String url = "jdbc:mysql://bassure.in:3306/dina_b8_db";
    String uname = "dina_07";
    String pass = "dinaBA81";

    boolean exit = true;
    Connection con = DriverManager.getConnection(url, uname, pass);
    System.out.println("connected.....");
    System.out.println("1.Insert Customer");
    System.out.println("2.Update Customer");
    System.out.println("3.Exit");
    while (exit) {
      int sel = Integer.parseInt(br.readLine());
      switch (sel) {
        case 1:
          crud.ins(con);
          break;
        case 2:
          crud.update(con);
          break;
        case 3:
          exit = false;
          break;
      }
    }
  }
}
