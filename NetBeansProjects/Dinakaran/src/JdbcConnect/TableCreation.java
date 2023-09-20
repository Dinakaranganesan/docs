/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
public class TableCreation {
  public static void main(String[] args) throws SQLException {
    //DatabaseConnection 
   // DatabaseConnection connectNow = new DatabaseConnection();
   
     String url = "jdbc:mysql://bassure.in:3306/dina_b8_db";
    String uname = "dina_07";
    String pass = "dinaBA81";

        Connection connectDb = DriverManager.getConnection(url, uname, pass);
        //String tableName = "";
        try {
            String createTable = "CREATE TABLE  dummy (firstname varchar(30), lastname varchar(30))";
            PreparedStatement myStmt = connectDb.prepareStatement(createTable);
            //myStmt.setString(1, "dummy");
            myStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            //e.getCause();
        }
    }
  }

