/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hibernatedemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author bas200181
 */
public class Hibernatedemo {

    public static void main1(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.getTransaction().commit();

        System.out.println("Table created");
    }

    public static void main2(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        Person p = new Person("Raju", "G");
        em.persist(p);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    public static void main3(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.getReference(Person.class, 1L);
        System.out.println(p);

        em.getTransaction().commit();

    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
   Person p = em.createQuery("from Person  where personId=:id",Person.class).setParameter("id", 1l).getSingleResult();
        //   Person p = em.createNativeQuery("select * from person where id=?",Person.class).setParameter(em);
        System.out.println(p);
        em.getTransaction().commit();

    }
}
