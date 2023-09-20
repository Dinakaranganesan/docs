/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JdbcConnect;

import static JdbcConnect.Jdbcc.br;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bas200181
 */
public class CRUDOP {

  public void ins(Connection con) throws SQLException, IOException {
   String insQuery = "insert into people values(?,?)";
    PreparedStatement ps = con.prepareStatement(insQuery);
    System.out.println("Enter the people_id");
    int people_id = Integer.parseInt(br.readLine());
    System.out.println("Enter the  Name");
    String p_name = br.readLine();
    ps.setInt(1, people_id);
    ps.setString(2, p_name);
    ps.executeUpdate();
  }
  public void update(Connection con) throws SQLException, IOException {
    String upQuery = "update Customer set cus_address=? where customer_id=?";
    PreparedStatement upp = con.prepareStatement(upQuery);
    System.out.println("Enter the cus_id");
    int id = Integer.parseInt(br.readLine());
    System.out.println("Enter the New Address");
    String addd = br.readLine();
    upp.setString(1, addd);
    upp.setInt(2, id);
    int aff = upp.executeUpdate();
    System.out.println("" + aff + " row affected");

  }
}
