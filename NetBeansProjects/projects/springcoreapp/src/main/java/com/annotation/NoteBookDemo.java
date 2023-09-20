/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author bas200181
 */
public class NoteBookDemo {
    public static void main(String[] args) {
        
        ApplicationContext apc = new ClassPathXmlApplicationContext("data.xml");
        NoteBook n = apc.getBean("nb", NoteBook.class);
        n.getNoteBook();
        
    }
}
