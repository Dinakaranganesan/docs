package com.mycompany.maven.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class CustomerMenu  extends GenericServlet{

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    response.getWriter().print("");
    
  }
  
}
