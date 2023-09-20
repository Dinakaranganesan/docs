/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcConnect;

import java.sql.*;
//import java.sql.ResultSet;

/**
 *
 * @author bas200181
 */
public class CallableStatements {

  public static void main(String[] args) throws Exception {
    String uname = "dina_07";
    String pass = "dinaBA81";
    String sql = "insert into employee values(?,?,?,?)";
    //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String query = "{call getemployeelocation(?)}";

    //String query = "Select * from employee where ROLES="CLERK"
    //Class.forName("com.mysql.cj.jdbc.Driver");
    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://bassure.in:3306/dina_b8_db", uname, pass);
    CallableStatement preparepCall = con.prepareCall(query);
    preparepCall.setString("newdes", "neyveli");
    ResultSet rs = preparepCall.executeQuery();
    while (rs.next()) {
      System.out.println(rs.getInt(1));
      System.out.println(rs.getString(2));
      System.out.println(rs.getString(3));
      System.out.println(rs.getString(4));

      //System.out.println(con.getClass().getName());
      //System.out.println("Connected");
//    Statement st=con.createStatement();
    }

    con.close();
  }

}
