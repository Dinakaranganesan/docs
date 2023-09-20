/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.maven.servlet;

import static dao.mysql.CustomerDaoImpl.getMys;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customerr;

/**
 *
 * @author bas200181
 */
@WebServlet(name = "viewservlet", urlPatterns = {"/viewservlet"})
public class ViewServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
            List<Customerr> al = new ArrayList<>();
            String view_all = "Select * from Customer";
            try (Connection con = getMys().createConnection(); PreparedStatement ps_c = con.prepareStatement(view_all)) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                PreparedStatement ps_d = con.prepareStatement(view_all);
                ResultSet rs1 = ps_d.executeQuery();
                while (rs1.next()) {
                    al.add(new Customerr(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getDouble(6)));
                }
//                pw.print(" <h1>Customer Details <h1> ");
//                pw.print(" <table border=1 rules=all>  ");
//                pw.print(" <tr>");
//                pw.println(" <th>CUSTOMER ID</th> ");
//                pw.println(" <th>CUSTOMER NAME</th> ");
//                pw.println("<th>MOBILE</th>");
//                pw.println(" <th>ADDRESS</th>");
//                pw.println(" <th>ADHAAR NO</th> ");
//                pw.println(" <th>CUSTOMER BALANCE</th>");
//                pw.println(" </tr>");
//                for (Customerr cu : al) {
//                    pw.println(" <tr> ");
//                    pw.println(" <td>" + cu.getCusId() + "</td>");
//                    pw.println(" <td>" + cu.getCusName() + "</td>");
//                    pw.println(" <td>" + cu.getPhoneNo() + "</td>");
//                    pw.println(" <td>" + cu.getCusAddress() + "</td>");
//                    pw.println(" <td>" + cu.getCusAadhaar() + "</td>");
//                    pw.println(" <td>" + cu.getCusBal() + "</td>");
//                    pw.println(" </tr> ");
//                }
//                pw.print(" </table >  ");
//
                request.setAttribute("customerlist", al);
            } catch (SQLException sqe) {
                sqe.printStackTrace();
            }
            this.getServletContext().getRequestDispatcher("/viewUsers2.jsp").forward(request, response);

        
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
        }
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
