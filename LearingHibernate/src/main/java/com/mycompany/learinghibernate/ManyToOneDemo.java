/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learinghibernate;

import model.Contact1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author bas200181
 */
public class ManyToOneDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em= emf.createEntityManager();
        Contact1 c=em.find(Contact1.class, 100l);
        System.out.println(c);
        em.close();
        emf.close();
    }
    
}
