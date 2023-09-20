/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learinghibernate;

import model.Contact;
import model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author bas200181
 */
public class OneToManyDemo {
    public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
         Member m = em.find(Member.class, 1l);
         for(Contact c:m.getContactList()){
             System.out.println(c);
         }
         em.close();
         emf.close();
    }
}
