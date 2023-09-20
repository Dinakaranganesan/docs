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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import model.AddCart;
import model.Customerr;
import model.Inventoryy;
import model.LineItemss;

/**
 *
 * @author bas200181
 */
public class CustomerWebServlet extends HttpServlet {

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
        KhataBookDao kbd = (KhataBookDaoImpl)request.getServletContext().getAttribute("khataBookObject");
        PrintWriter out = response.getWriter();
        HttpSession hs = request.getSession();
        String userName = (String) hs.getAttribute("name");
        int id = (int) hs.getAttribute("cusid");
        int switchOptions = Integer.parseInt(request.getParameter("value"));
        switch (switchOptions) {
            case 1: {
                Customerr cus = kbd.getCustomerDaoObj().viewCustomerWeb(id);
                out.print(" <h1>Customer Details <h1> ");
                  out.print("""
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
                out.print(" <table border=1 rules=all>  ");
                out.print(" <tr class=t1>");
                out.println(" <th>CUSTOMER ID</th> ");
                out.println(" <th>CUSTOMER NAME</th> ");
                out.println("<th>MOBILE</th>");
                out.println(" <th>ADDRESS</th>");
                out.println(" <th>ADHAAR NO</th> ");
                out.println(" <th>CUSTOMER BALANCE</th>");
                out.println(" </tr>");
                out.println(" <tr> ");
                out.println(" <td>" + cus.getCusId() + "</td>");
                out.println(" <td>" + cus.getCusName() + "</td>");
                out.println(" <td>" + cus.getPhoneNo() + "</td>");
                out.println(" <td>" + cus.getCusAddress() + "</td>");
                out.println(" <td>" + cus.getCusAadhaar() + "</td>");
                out.println(" <td>" + cus.getCusBal() + "</td>");
                out.println(" </tr> ");

                out.print(" </table >  ");
                out.print("""   
                                 <form action='customerweb.html'><input type='submit' value='back'></form>                                  """);

            }
            break;
            case 2: {
                boolean d = false;
                int b = 0;
                int orderid = Integer.parseInt(request.getParameter("order-id"));
                String[] proid = request.getParameterValues("productid");
                String[] quantity1 = request.getParameterValues("quantity");
                AddCart or = new AddCart();
                LineItemss[] lim = new LineItemss[proid.length];
                //String phone_no = phone
                int order_id = orderid;
                Date l = Date.valueOf(LocalDate.now());
                or.setCustomerId(id);
                or.setOrderId(order_id);
                double sum = 0;
                boolean add = true;

                for (int j = 0; j < proid.length; j++) {

                    int productId = Integer.parseInt(proid[j]);
                    Inventoryy inv1 = kbd.getProductDaoObj().getProductDetails(productId);
                    int quantity = Integer.parseInt(quantity1[j]);
                    double buyPrice = quantity * inv1.getPrice();
                    sum += buyPrice;
                    lim[j] = new LineItemss(order_id, productId, inv1.getProName(), quantity, buyPrice);
                    int a1 = inv1.getQuantity() - quantity;

                }

                or.setPrice(sum);
                d = kbd.getOrderDaoObj().addCartItems(or, lim);

                if (d ) {
                    out.print("""
                            List Added to cart
                                 """);
                } else {
                    out.print("not done");

                }
            }
            break;
            case 3: {
                String phone = request.getParameter("phone");
                int update = kbd.getCustomerDaoObj().updateCustomerMobile(phone, id);
                response.sendRedirect("customersuccesspage.html");
            }
            break;
              case 4: {
                String getaddress = request.getParameter("address");
                int update = kbd.getCustomerDaoObj().updateCustomerAddress(getaddress, id);
                response.sendRedirect("customersuccesspage.html");
            }
            break;
        
        }
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
