/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven.servlet;

import dao.mysql.Statistics;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import model.Customerr;
import model.OrderedDetails;
import model.PaymentDetails;

/**
 *
 * @author bas200181
 */
public class StatisticsServlet extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    PrintWriter pw = response.getWriter();
 Statistics s = ( Statistics)request.getServletContext().getAttribute("stats");    if (this.getServletContext().getInitParameter("Database").equals("mysql")) {
      int opt = Integer.parseInt(request.getParameter("l"));
      switch (opt) {
        case 1: {

          try {
            List<Customerr> ls = s.getPaidCustomer();
            pw.print(" <h1>PAID DETAILS<h1> ");
              pw.print("""
                             <html>
                             <head>
                             <style>
                             .t1{
                             background-color:yellow;
                           
                             }
                             </style>
                             </head>
                             </html>
                             """);
            pw.print(" <table border=1 rules=all>  ");
            pw.print(" <tr class=t1>");
            pw.println(" <th>CUSTOMER ID</th> ");
            pw.println(" <th>CUSTOMER NAME</th> ");
            pw.println("<th>MOBILE</th>");
            pw.println(" <th>ADDRESS</th>");
            pw.println(" <th>ADHAAR NO</th> ");
            pw.println(" <th>CUSTOMER BALANCE</th>");
            pw.println(" </tr>");
            for (Customerr cu : ls) {
              pw.println(" <tr> ");
              pw.println(" <td>" + cu.getCusId() + "</td>");
              pw.println(" <td>" + cu.getCusName() + "</td>");
              pw.println(" <td>" + cu.getPhoneNo() + "</td>");
              pw.println(" <td>" + cu.getCusAddress() + "</td>");
              pw.println(" <td>" + cu.getCusAadhaar() + "</td>");
              pw.println(" <td>" + cu.getCusBal() + "</td>");
              pw.println(" </tr> ");
            }
            pw.print(" </table >  ");
            pw.print("""   
                                 <form action='stats.html'><input type='submit' value='back'></form>                                  """);
          } catch (SQLException ex) {
          }

          break;
        }
        case 2: {
          try {
            List<Customerr> ls = s.getUnPaidCustomer();
            pw.print(" <h1>UNPAID DETAILS<h1> ");
              pw.print("""
                             <html>
                             <head>
                             <style>
                             .t1{
                             background-color:yellow;
                           
                             }
                             </style>
                             </head>
                             </html>
                             """);
            pw.print(" <table border=1 rules=all>  ");
            pw.print(" <tr class=t1>");
            pw.println(" <th>CUSTOMER ID</th> ");
            pw.println(" <th>CUSTOMER NAME</th> ");
            pw.println("<th>MOBILE</th>");
            pw.println(" <th>ADDRESS</th>");
            pw.println(" <th>ADHAAR NO</th> ");
            pw.println(" <th>CUSTOMER BALANCE</th>");
            pw.println(" </tr>");
            for (Customerr cu : ls) {
              pw.println(" <tr> ");
              pw.println(" <td>" + cu.getCusId() + "</td>");
              pw.println(" <td>" + cu.getCusName() + "</td>");
              pw.println(" <td>" + cu.getPhoneNo() + "</td>");
              pw.println(" <td>" + cu.getCusAddress() + "</td>");
              pw.println(" <td>" + cu.getCusAadhaar() + "</td>");
              pw.println(" <td>" + cu.getCusBal() + "</td>");
              pw.println(" </tr> ");
            }
            pw.print(" </table >  ");
            pw.print("""   
                                 <form action='stats.html'><input type='submit' value='back'></form>                                  """);
          } catch (SQLException ex) {
          }

          break;
        }
        case 3: {
          try {
            List<PaymentDetails> ls = s.getPaymentDetails();
            pw.print(" <h1>Payment DETAILS<h1> ");
              pw.print("""
                             <html>
                             <head>
                             <style>
                             .t1{
                             background-color:yellow;
                           
                             }
                             </style>
                             </head>
                             </html>
                             """);
            pw.print(" <table border=1 rules=all>  ");
            pw.print(" <tr class=t1>");
            pw.println(" <th>CUSTOMER ID</th> ");
            pw.println(" <th>CUSTOMER NAME</th> ");
            pw.println("<th>MOBILE</th>");
            pw.println(" <th>PaymentId</th>");
            pw.println(" <th>Amount</th> ");
            pw.println(" <th>PaidDate</th>");
            pw.println(" </tr>");
            for (PaymentDetails cu : ls) {
              pw.println(" <tr> ");
              pw.println(" <td>" + cu.getCusId()+ "</td>");
              pw.println(" <td>" + cu.getCusName() + "</td>");
              pw.println(" <td>" + cu.getPhoneNo() + "</td>");
              pw.println(" <td>" + cu.getPaymentId() + "</td>");
              pw.println(" <td>" + cu.getAmount() + "</td>");
              pw.println(" <td>" + cu.getPaidDate() + "</td>");
              pw.println(" </tr> ");
            }
            pw.print(" </table >  ");
            pw.print("""   
                                 <form action='stats.html'><input type='submit' value='back'></form>                                  """);
          } catch (SQLException ex) {
          }

          break;
        }
          case 4: {
          try {
            Date d=Date.valueOf(request.getParameter("order-date"));
            List<OrderedDetails> ls = s.getOrdersByDate(d);
            pw.print(" <h1> DETAILS<h1> ");
              pw.print("""
                             <html>
                             <head>
                             <style>
                             .t1{
                             background-color:yellow;
                           
                             }
                             </style>
                             </head>
                             </html>
                             """);
            pw.print(" <table border=1 rules=all>  ");
            pw.print(" <tr class=t1>");
            pw.println(" <th>CUSTOMER ID</th> ");
            pw.println(" <th>CUSTOMER NAME</th> ");
            pw.println("<th>MOBILE</th>");
            pw.println(" <th>OrderId</th>");
            pw.println(" <th>Orderedate</th> ");
            pw.println(" <th>Total Amount</th>");
            pw.println(" </tr>");
            for (OrderedDetails cu : ls) {
              pw.println(" <tr> ");
              pw.println(" <td>" + cu.getCusId()+ "</td>");
              pw.println(" <td>" + cu.getCusName() + "</td>");
              pw.println(" <td>" + cu.getPhoneNo() + "</td>");
              pw.println(" <td>" + cu.getOrderId() + "</td>");
              pw.println(" <td>" + cu.getOrderDate() + "</td>");
              pw.println(" <td>" + cu.getTotalAmount()+ "</td>");
              pw.println(" </tr> ");
            }
            pw.print(" </table >  ");
            pw.print("""   
                                 <form action='stats.html'><input type='submit' value='back'></form>                                  """);
          } catch (SQLException ex) {
          }

          break;
        }

case 5: {
          try {
            Date d1=Date.valueOf(request.getParameter("order-date1"));
             Date d2=Date.valueOf(request.getParameter("order-date2"));
            List<OrderedDetails> list = s.getOrdersByRange(d1, d2);
            pw.print(" <h1> DETAILS<h1> ");
              pw.print("""
                             <html>
                             <head>
                             <style>
                             .t1{
                             background-color:yellow;
                           
                             }
                             </style>
                             </head>
                             </html>
                             """);
            pw.print(" <table border=1 rules=all>  ");
            pw.print(" <tr class=t1>");
            pw.println(" <th>CUSTOMER ID</th> ");
            pw.println(" <th>CUSTOMER NAME</th> ");
            pw.println("<th>MOBILE</th>");
            pw.println(" <th>OrderId</th>");
            pw.println(" <th>Orderedate</th> ");
            pw.println(" <th>Total Amount</th>");
            pw.println(" </tr>");
            for (OrderedDetails od : list) {
              pw.println(" <tr> ");
              pw.println(" <td>" + od.getCusId()+ "</td>");
              pw.println(" <td>" + od.getCusName() + "</td>");
              pw.println(" <td>" + od.getPhoneNo() + "</td>");
              pw.println(" <td>" + od.getOrderId() + "</td>");
              pw.println(" <td>" + od.getOrderDate() + "</td>");
              pw.println(" <td>" + od.getTotalAmount()+ "</td>");
              pw.println(" </tr> ");
            }
            pw.print(" </table >  ");
            pw.print("""   
                                 <form action='stats.html'><input type='submit' value='back'></form>                                  """);
          } catch (SQLException ex) {
          }

          break;
        }
      }

    }
  }
}
