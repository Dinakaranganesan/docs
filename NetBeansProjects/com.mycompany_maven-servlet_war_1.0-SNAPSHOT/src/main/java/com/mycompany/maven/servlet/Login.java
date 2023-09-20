/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.maven.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author bas200181
 */
public class Login extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
       
        out.println("""
                             <!<html>
                                 <head>
                                     <title>khatabook</title>
                                     <style>
                                         .login
                                         {
                                             border: 1px solid black;
                                             position: relative;
                                             display: inline-block;
                                             background-color: #FFB6C1;
                                             padding: 30px;
                                            
                             
                                         }
                                         body{
                             
                                             height:100vh;
                                             display:flex;
                                             justify-content: center;
                                             align-items: center;
                                         }
                                         .loginb{
                                             display: block;
                                             width: 100px;
                                         }
                                         .signupb{
                                             display: block;
                                             width:100px;
                                             
                                             
                                         }
                                        
                                         </style>
                             
                                     </head>
                             
                                     <body bgcolor=#FFF0F5 >
                                         <div class="login" >
                                             <form action="j_security_check" method="post">
                                                 <!--<b>Welcome to khatabook's login</b>-->
                                                 <input type="text"name="j_username" placeholder="USERNAME"required> <br><br>
                                                 <input type="password" name="j_password" placeholder="PASSWORD"required><br><br>
                                       
                                                 <button type="submit"class="loginb">login</button>
                                             </form>
                             
                             
                                             <form action="signup.html">
                                                 <button type="submit"class="signupb">signup</button>
                             
                                             </form>
                             
                                         </div>
                                     </body>
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