//package com.khatabook.listener;
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//import com.khatabook.KhataBook.dao.MySqlKhataBookDao;
//import com.khatabook.cusomerrepository.KhataBookDaoImpl;
//import com.khatabook.idao.KhataBookDao;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletContextEvent;
//import jakarta.servlet.ServletContextListener;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
///**
// *
// * @author bas200181
// */
//public class ApplicationListener  implements ServletContextListener{
//      @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        ServletContextListener.super.contextInitialized(sce);
//        ServletContext context = sce.getServletContext();
//
//        try {
//            DataSource ds = (DataSource) InitialContext.doLookup("java:comp/env/jdbc/myDB");
//           // context.setAttribute("Dbpool", ds);
//            KhataBookDao khataObject = new KhataBookDaoImpl(ds);
//            context.setAttribute("dao", khataObject);
//        } catch (NamingException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        ServletContextListener.super.contextDestroyed(sce);
//        ServletContext context = sce.getServletContext();
//
//        try {
//            DataSource ds = (DataSource) InitialContext.doLookup("java:comp/env/jdbc/myDB");
//
//            context.removeAttribute("Dbpool");
//        } catch (NamingException ex) {
//            ex.printStackTrace();
//        }
//    }
//    
//}
