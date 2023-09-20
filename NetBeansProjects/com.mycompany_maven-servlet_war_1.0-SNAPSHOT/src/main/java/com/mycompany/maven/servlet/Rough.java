/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven.servlet;

import dao.mysql.KhataBookDaoImpl;
import idao.KhataBookDao;

/**
 *
 * @author bas200181
 */
public class Rough {
    public static void main(String[] args) {
        KhataBookDao kb=new KhataBookDaoImpl();
        String name="goldberg";
      int id=  kb.getCustomerDaoObj().getCustomerId(name);
        System.out.println(id);
        
    }
    
}
