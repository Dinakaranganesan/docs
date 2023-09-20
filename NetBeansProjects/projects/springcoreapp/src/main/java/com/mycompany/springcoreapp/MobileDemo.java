/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author bas200181
 */
public class MobileDemo {
    public static void main(String[] args) {
        ApplicationContext apc=new ClassPathXmlApplicationContext("spring-car.xml");
        Mobile m=apc.getBean("a",Mobile.class);
        System.out.println(m);
        
        
    }
         
    
}
