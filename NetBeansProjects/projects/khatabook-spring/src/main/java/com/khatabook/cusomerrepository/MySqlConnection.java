/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.cusomerrepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bas200181
 */
public class MySqlConnection {

  public static  Connection createConnection() throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    String url = "jdbc:mysql://bassure.in:3306/dina_b8_db";
    String uname = "dina_07";
    String pass = "dinaBA81";
    return DriverManager.getConnection(url, uname, pass);
  }
}
