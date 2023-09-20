/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author bas200181
 */
public class ApplicationListener1 implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
           try {
            ServletContext sc= sce.getServletContext();
            DataSource ds=(DataSource)InitialContext.doLookup("java:comp/env/jdbc/myDB");
            sc.removeAttribute("dbPool");
        } catch (NamingException ex) {
           
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServletContext sc= sce.getServletContext();
            DataSource ds=(DataSource)InitialContext.doLookup("java:comp/env/jdbc/myDB");
            sc.setAttribute("dbPool", ds);
        } catch (NamingException ex) {
           
        }
      
    }
    
}
