<%-- 
    Document   : newjsp
    Created on : 16-Feb-2023, 12:16:26 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.io.IOException" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <% 
          
    
      String dbDriver = "com.mysql.jdbc.Driver";
      String url = "jdbc:mysql://bassure.in:3306/dina_b8_db";
      String uname = "dina_07";
      String pass = "dinaBA81";
      

        try {
          Class.forName(dbDriver);
        
        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement ps = con.prepareStatement("select * from Customer");

        ResultSet rs = ps.executeQuery();
        %>
        <table border=1 rules=all>
        <tr>
        <th>CustomerID</th>
        <th>Custname</th>
        <th>cusphoneno</th>
        <th>cusaadhaar</th>
        <th>cusaddress</th>
        <th>cusbal</th>
        </tr>"
       
        <% while (rs.next()) { %>
         
         <tr>
             <td><%= rs.getInt(1) %></td>
             <td><%= rs.getString(2) %></td>
             <td><%= rs.getString(3) %></td>
             <td><%= rs.getString(4) %> </td>
             <td><%= rs.getString(5) %></td>
             <td><%= rs.getDouble(6) %></td>
         </tr>
         <%      }
                  
               } catch (Exception ex) {
                 out.print(ex);
              }
   
        %>

</body>
</html>
