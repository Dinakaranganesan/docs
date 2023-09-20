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
public class ConstructorBasedDemo {

    public static void main(String[] args) {
        ApplicationContext apc = new ClassPathXmlApplicationContext("constructor.xml");
        Mobile m1 = apc.getBean("a", Mobile.class);
        System.out.println(m1);
        Mobile m2 = apc.getBean("b", Mobile.class);
        System.out.println(m2);
        Mobile m3 = apc.getBean("c", Mobile.class);
        System.out.println(m3);
    }

}
