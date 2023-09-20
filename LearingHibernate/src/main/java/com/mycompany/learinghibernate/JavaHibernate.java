/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learinghibernate;

import model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author bas200181
 */
public class JavaHibernate {
 
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        try {
            emf = Persistence.createEntityManagerFactory("hibernate-jpa");
            em = emf.createEntityManager();
        } finally {
            em.close();
            emf.close();

        }
    }

    public static void main6(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        Member m = (Member) em.createNativeQuery("select * from members where member_id=1", Member.class).getSingleResult();
        System.out.println(m);
        em.close();
        emf.close();
    }

    public static void main5(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        String name = em.createQuery("select m.name from Member m where m.memberId=?1", String.class).setParameter(1, 1l).getSingleResult();
        System.out.println("*".repeat(10) + name + "*".repeat(10));
        em.close();
        emf.close();
    }

    public static void main4(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        Member m = em.find(Member.class, 2l);
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
        em.close();
        emf.close();
        main1(null);

    }

    public static void main3(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        Member m = em.find(Member.class, 2l);
        em.getTransaction().begin();
        m.setName("Dina");
        em.getTransaction().commit();
        em.close();
        emf.close();
        main1(null);

    }

    public static void main2(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        Member temp = new Member(0, "Dinesh", "9962931336");
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(temp);
        et.commit();
        em.close();
        emf.close();
        main1(null);

    }

    public static void main1(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        List<Member> allMem = em.createQuery("select m from Member m", Member.class).getResultList();
        for (Member m : allMem) {
            System.out.println(m);
        }
        em.close();
        emf.close();
    }
}
