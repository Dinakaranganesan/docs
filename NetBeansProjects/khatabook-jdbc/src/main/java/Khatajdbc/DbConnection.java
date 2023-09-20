/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Khatajdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bas200181
 */
public class DbConnection {
  public static void main(String[] args) {
    Customer c=new Customer();
    try{
          String url = "jdbc:mysql://bassure.in:3306/dina_b8_db";
    String uname = "dina_07";
    String pass = "dinaBA81";
    Connection connect = DriverManager.getConnection(url, uname, pass);
    //c.add(connect);
      
    }
    catch(Exception e)
    {
      //System.out.println(printStackTrace(e));
    }
    
    
    
  }
  
}
