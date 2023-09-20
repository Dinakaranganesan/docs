/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcConnect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

/**
 *
 * @author bas200181
 */
public class JdbcCon {

  public static void main(String[] args) throws Exception {
    String uname = "dina_07";
    String pass = "dinaBA81";
    String sql="insert into employee values(?,?,?,?)";
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    //String query = "Select * from employee where ROLES="CLERK"
    //Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://bassure.in:3306/dina_b8_db", uname, pass);
    //System.out.println(con.getClass().getName());
    //System.out.println("Connected");
    Statement st=con.createStatement();
    
    PreparedStatement ps = con.prepareStatement(sql);
    System.out.println("Enter the Role_ID");
    int role_id=Integer.parseInt(br.readLine());
    ps.setInt(1,role_id);
    System.out.println("Enter the Roles");
    String roles=br.readLine();
    ps.setString(2, roles);
    System.out.println("Enter the Location");
    String loc=br.readLine();
     ps.setString(3, loc);
     System.out.println("Enter the Salary");
     int sal=Integer.parseInt(br.readLine());
     ps.setInt(4, sal);
    int rs1 = ps.executeUpdate();
    System.out.println(rs1);
    // Statement s=con.createStatement();
//  while(rs1.next()){
//        String employeeId = rs1.getInt(1) + " :" + rs1.getString(2) + ":" + rs1.getString(3) + " :" + rs1.getDouble(4);
////        rs1.getNCharacterStream(query);
//System.out.println(employeeId);
//      }

//   ps.setInt(1,104);"
//   ps.setString(2, "pratheeban");
//   ps.setString(3, "ramnad");
//   ps.setDouble(4, 567278287);
//   int i=ps.executeUpdate();
//    System.out.println("value inserted"+i);
//   
//    ResultSet rs = ps.executeQuery(query);
//    // preparedStatement p=con.prepareStatement()
//    while (rs.next()) {
//      String employeeId = rs.getInt(1) + " :" + rs.getString(2) + ":" + rs.getString(3) + " :" + rs.getDouble(4);
//      System.out.println(employeeId);
//    }
    ps.close();
    con.close();
  }
}
