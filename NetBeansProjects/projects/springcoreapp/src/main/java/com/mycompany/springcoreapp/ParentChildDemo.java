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
public class ParentChildDemo {

    public static void main(String[] args) {
        ApplicationContext apc = new ClassPathXmlApplicationContext("parent-child.xml");
        Parent p = apc.getBean("parent", Parent.class);
        System.out.println(p.getParentAge());
        System.out.println(p.getParentName());
        
        Child c = apc.getBean("child", Child.class);
        
        System.out.println(c.getChildAge());
        System.out.println(c.getChildName());
        System.out.println(c.getParentName());
        System.out.println(c.getParentAge());

    }
}
