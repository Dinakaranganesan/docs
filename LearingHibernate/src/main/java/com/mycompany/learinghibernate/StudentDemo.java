/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learinghibernate;

import model.Student;
import model.Subjects;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.Serializable;

/**
 *
 * @author bas200181
 */
public class StudentDemo implements Serializable {

    public static void main(String[] args) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-jpa");
        EntityManager em = emf.createEntityManager();
        Student s=new Student();
        s.setRollNo(1);
        s.setStudentName("pratheeban");
        s.setScores("75");
        Subjects s2=new Subjects();
        s2.setSubject1("Tamil");
        s2.setSubject2("English");
        s2.setSubject3("Maths");
        s.setSub(s2);
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
