/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.maven.servlet;

import dao.mysql.KhataBookDaoImpl;
import idao.KhataBookDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.AddCart;
import model.Customerr;

/**
 *
 * @author bas200181
 */
public class PendingOrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter pw = response.getWriter();
         KhataBookDao kb=new KhataBookDaoImpl();
         List<AddCart> al=kb.getCustomerDaoObj().viewAllPending();
            pw.print(" <i><h1>PendingCustomerOrders <h1></i> ");
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
                    pw.println(" <th>ORDER ID</th> ");
                    pw.println(" <th>CUSTOMER ID</th> ");
                    pw.println("<th>ORDEREDDATE</th>");
                    pw.println(" <th>PRICE</th>");
                    pw.println(" <th>STATUS</th> ");
                    pw.println(" </tr>");
                    for (AddCart cu : al) {
                        pw.println(" <tr1> ");
                        pw.println(" <td>" + cu.getCustomerId() + "</td>");
                        pw.println(" <td>" + cu.getOrderId()+ "</td>");
                        pw.println(" <td>" + cu.getDate() + "</td>");
                        pw.println(" <td>" + cu.getPrice() + "</td>");
                        pw.println(" <td>" + cu.getStatus() + "</td>");
                        pw.println(" </tr1> ");
                    }
                    pw.print(" </table >  ");
                    pw.print("""
                           <h3> Enter the OrderId  to confirm order</h3><input type="text" name="orderid">
                            <a href="inscus?s=9" method="post"> <button>Confirm</button></a>
                             """);

      
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
