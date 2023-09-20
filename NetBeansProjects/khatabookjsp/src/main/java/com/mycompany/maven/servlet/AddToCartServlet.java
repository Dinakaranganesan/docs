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
import java.util.List;
import model.Inventoryy;

/**
 *
 * @author bas200181
 */
public class AddToCartServlet extends HttpServlet {

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
        KhataBookDao kbd = new KhataBookDaoImpl();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        List<Inventoryy> viewProduct = kbd.getProductDaoObj().viewAll();
        pw.print(" <h1>Product Details <h1> ");
        pw.print(" <table border=1 rules=all>  ");
        pw.print(" <tr>");
        pw.println(" <th>PRODUCT ID</th> ");
        pw.println(" <th>PRODUCT NAME</th> ");
        pw.println("<th>QUANTITY</th>");
        pw.println(" <th>PRICE</th>");

        pw.println(" </tr>");
        for (Inventoryy inv : viewProduct) {
            pw.println(" <tr> ");
            pw.println(" <td>" + inv.getProductId() + "</td>");
            pw.println(" <td>" + inv.getProName() + "</td>");
            pw.println(" <td>" + inv.getQuantity() + "</td>");
            pw.println(" <td>" + inv.getPrice() + "</td>");
            pw.println(" </tr> ");
        }
        pw.print(" </table >  ");
        pw.print("""
                 
        <!DOCTYPE html><html lang="en"><head>  <meta charset="UTF-8">  <meta name="viewport" content="width=device-width, initial-scale=1.0">  <title>Add Order</title>  <style>    table {
      border-collapse: collapse;
    }
    th, td {
      padding: 0.5rem;
      border: 1px solid #ccc;
    }
    th {
      text-align: left;
    }
    .line-total {
      text-align: right;
    }
    button {
      background-color: #008CBA;
      color: white;
      padding: 0.5rem;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    button:hover {
      background-color: #006F8E;
    }
    .btn{
        height:40px;
    }
  </style> 
    </head>
    <body> 
        <form  action="customerwebservlet?value=2" id="add-order-form" method="post">    
            <br>
            <div>      
                <label for="order-id">Order ID:</label>     
                <input type="text" id="order-id" name="order-id" required>   
            </div>  
            <br>
            <div>     
                <label for="order-date">Order Date:</label>     
                <input type="date" id="order-date" name="order-date" required>    
            </div>   
             
            <h2>Line Items</h2>   
            <table>     
                <thead>       
                    <tr>         
                        <th>Product ID</th>         
                        <th>Quantity</th>        
                    </tr>      
                </thead>
                <td>    
                    <p>ProductID :  
<!--                        <button type="button" class="btn btn-success rounded-3" onclick="addProductid()">ProductID</button>-->
                    </p>
                    <div id="authors" name="productid">
                        
                    </div>
                </td>
               <td>
<!--<p>Quantity</p> -->
                <p>Quantity :  
   
                    </p>
                    <div id="quantity" name="quantity"></div>
                    </td> 
            </table>  
            <button type="button" class="btn" onclick="addQuantity()">
                            Add More</button>
            <input type="submit">
        </form>
    </body>  <script>            let count = 1;
               function addProductid() {
                const holder = document.getElementById("authors");
                const authorElement = document.createElement("input");
                const brk = document.createElement("br");
                authorElement.setAttribute("name", "productid");
                authorElement.setAttribute("placeholder", "enter the " + count++ + " productID");
                authorElement.setAttribute("Style", "margin:10px;");
                holder.appendChild(authorElement);
                holder.appendChild(brk);
                authorElement.focus(); 
              
            }
            let count1 = 1;
            function addQuantity() {
    addProductid();
                const hold = document.getElementById("quantity");
                const mobileElement = document.createElement("input");
                const brk = document.createElement("br");
                mobileElement.setAttribute("name", "quantity");
                mobileElement.setAttribute("placeholder", "enter the " + count1++ + " quantity.");
                mobileElement.setAttribute("Style", "margin:10px;");
                hold.appendChild(mobileElement);
                hold.appendChild(brk);
                mobileElement.focus();
            }
    </script>
</html>
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
