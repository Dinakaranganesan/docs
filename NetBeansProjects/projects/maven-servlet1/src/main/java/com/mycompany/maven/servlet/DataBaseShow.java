/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bas200181
 */
public class DataBaseShow implements Servlet {

  @Override
  public void init(ServletConfig sc) throws ServletException {

  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    String userName = "dina07@bassure.in";
    String passw = "dinaBA81";
    if (userName.equals(req.getParameter("username")) && passw.equals(req.getParameter("password"))) {
      String dbDriver = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://bassure.in:3306/dina_b8_db";
      String uname = "dina_07";
      String pass = "dinaBA81";
      try {

        try {
          Class.forName(dbDriver);
        } catch (ClassNotFoundException ex) {
          
        }
        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement ps = con.prepareStatement("select * from Customer");
//      res.getWriter().print("Connected");
        ResultSet rs = ps.executeQuery();
        // PrintWriter out=res.getWriter();
        res.getWriter().println("<html><body ><table border=1 rules=all><tr><th>CustomerID</th<th>Custname</th><th>cusphoneno</th><th>cusaadhaar</th><th>cusaddress</th><th>cusbal</th></tr>");
        while (rs.next()) {
          //res.getWriter().println(rs.getInt(1)+" "+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getDouble(6));
          res.getWriter().println("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getDouble(6) + "</td></tr>");
        }
        res.getWriter().println("</table></body></html>");
      } catch (SQLException ex) {
        res.getWriter().print(ex);
      }
    } else {
      res.getWriter().print("<h1><b>Invalid Credentials<b></h1>");
    }
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {
  }

}
