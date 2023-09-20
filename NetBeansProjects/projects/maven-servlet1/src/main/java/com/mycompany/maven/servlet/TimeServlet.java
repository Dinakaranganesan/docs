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
import java.time.LocalDateTime;

/**
 *
 * @author bas200181
 */

public class TimeServlet implements  Servlet{

  @Override
  public void init(ServletConfig sc) throws ServletException {
    System.out.println("#".repeat(5)+" Servlet Initialized");
  }

  @Override
  public ServletConfig getServletConfig() {
   return null;
  }

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
 response.getWriter().print("Its Now :"+LocalDateTime.now());
  }

  @Override
  public String getServletInfo() {
   return "gives time on Server";
  }

  @Override
  public void destroy() {
        System.out.println("#".repeat(5)+" Servlet Destroyed");
  }
  
}