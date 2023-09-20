/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven.servlet;

import dao.mysql.KhataBookDaoImpl;
import idao.KhataBookDao;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Inventoryy;

/**
 *
 * @author bas200181
 */
public class InventoryServlet extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        KhataBookDao kbd = new KhataBookDaoImpl();
        PrintWriter pw = response.getWriter();
        if (this.getServletContext().getInitParameter("Database").equals("mysql")) {
//  pw.print(request.getParameter("s"));
            int i = Integer.parseInt(request.getParameter("k"));
            switch (i) {
                case 1 -> {
                    Inventoryy inv = new Inventoryy();
                    int proId = Integer.parseInt(request.getParameter("productid"));
                    inv.setProductId(proId);
                    inv.setProName(request.getParameter("proname"));
                    int quan = Integer.parseInt(request.getParameter("quantity"));
                    double price = Double.parseDouble(request.getParameter("price"));
                    inv.setQuantity(quan);
                    inv.setPrice(price);
                    int k = kbd.getProductDaoObj().addProduct(inv);
                    if (k != 0) {
                        pw.print("<h1>product added successfully</h1>");
                    } else {
                        pw.print("<h1>product not added successfully</h1>");
                    }
                }
                case 2 -> {

                    List<Inventoryy> viewProducts = kbd.getProductDaoObj().viewAll();
                    request.setAttribute("productlist", viewProducts);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/jspfiles/viewproduct.jsp").forward(request, response);
//          pw.print(" <h1>Product Details <h1> ");
//            pw.print("""
//                             <html>
//                             <head>
//                             <style>
//                             .t1{
//                             background-color:yellow;
//                           
//                             }
//                             </style>
//                             </head>
//                             </html>
//                             """);
//          pw.print(" <table border=1 rules=all>  ");
//          pw.print(" <tr class=t1>");
//          pw.println(" <th>PRODUCT ID</th> ");
//          pw.println(" <th>PRODUCT NAME</th> ");
//          pw.println("<th>QUANTITY</th>");
//          pw.println(" <th>PRICE</th>");
//
//          pw.println(" </tr>");
//          for (Inventoryy inv : viewProduct) {
//            pw.println(" <tr> ");
//            pw.println(" <td>" + inv.getProductId() + "</td>");
//            pw.println(" <td>" + inv.getProName() + "</td>");
//            pw.println(" <td>" + inv.getQuantity() + "</td>");
//            pw.println(" <td>" + inv.getPrice() + "</td>");
//            pw.println(" </tr> ");
//          }
//          pw.print(" </table >  ");
//          pw.print("""   
//                                 <form action='inventorymenu.html'><input type='submit' value='back'></form>                                  """);
                }
                case 3 -> {
                    // pw.print(request.getParameter("getpd"));
                    List<Inventoryy> viewParInventoryy = kbd.getProductDaoObj().viewProduct(Integer.parseInt(request.getParameter("getpd")));
                    request.setAttribute("productlist", viewParInventoryy);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/jspfiles/viewproduct.jsp").forward(request, response);
                }
                case 4 -> {
//          pw.print(request.getParameter("pid"));
//          pw.print(request.getParameter("quantity"));
                    Inventoryy inventoryy = new Inventoryy();
                    inventoryy.setProductId(Integer.parseInt(request.getParameter("pid")));
                    inventoryy.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                    int update = kbd.getProductDaoObj().updateProduct(inventoryy);
                    if (update != 0) {
                        pw.print("<h1>Data updated Successfully</h1>");
                    } else {
                        pw.print("<h1>Not updated</h1>");
                    }

                }

            }
        }
    }

}
