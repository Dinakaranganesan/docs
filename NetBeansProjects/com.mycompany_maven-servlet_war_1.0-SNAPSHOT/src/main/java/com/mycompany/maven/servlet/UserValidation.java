//wpackage com.mycompany.maven.servlet;
//
//import jakarta.servlet.GenericServlet;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.swing.UIClientPropertyKey;
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
///**
// *
// * @author bas200181
// */
//public class UserValidation extends GenericServlet {
//
//  @Override
//  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//    String dbDriver = "com.mysql.jdbc.Driver";
//    String url = "jdbc:mysql://bassure.in:3306/dina_b8_db";
//    String uname = "dina_07";
//    String pass = "dinaBA81";
//    PrintWriter pw=response.getWriter();
////    try {
//    try {
//      Class.forName(dbDriver);
//
//    } catch (ClassNotFoundException ex) {
////      pw.println("connected");
//      pw.println(ex);
//      ex.getMessage();
//    }
//    pw.println("<br>");
//    try (Connection con = DriverManager.getConnection(url, uname, pass);) {
//  
//      PreparedStatement ps = con.prepareStatement("select * from login where username = ? and password = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//      ps.setString(1, request.getParameter("username"));
//      ps.setString(2, request.getParameter("password"));
//      ResultSet rs = ps.executeQuery();
//      if (rs.absolute(1)) {
//        
//        response.getWriter().print("<html><body>Login in done<form action='homepage.html'><input type='submit' value='return to homepage'></form></body></html>");
//      
//      } else {
//        response.getWriter().print("invalid credentials");
//      }
////      boolean flag = false;
////      dina:
////      while (rs.next()) {
////
////        if (rs.getString("username").equals(request.getParameter("username")) && rs.getString("password").equals("password")) {
////          response.getWriter().print("<html><body><a href='custmenu.html'>1.Customer</body></html>");
////          flag = true;
////        } else {
////          response.getWriter().print("invalid credentials");
////        }
////        if (flag == true) {
////          break dina;
////        }
////
////      }
//    } catch (Exception sqe) {
//      response.getWriter().println(sqe);
//      sqe.getMessage();
//    }
//  }
//}
