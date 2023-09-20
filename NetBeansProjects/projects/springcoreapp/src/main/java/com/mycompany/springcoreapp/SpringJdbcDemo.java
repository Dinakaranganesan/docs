/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

import java.io.IOException;
import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author bas200181
 */
public class SpringJdbcDemo {

    public static void main1(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        UsersRepository usersComponent = ac.getBean(UsersRepository.class);
        List<Customerr> ls = usersComponent.getCustomer();
        ls.stream().forEach(System.out::println);

        ac.registerShutdownHook();
    }
//    JdbcTemplate jdbcTemplate;
//
//    public SpringJdbcDemo(DataSource ds) {
//this.jdbcTemplate=new JdbcTemplate(ds);
//    }
//    public static void main(String[] args) {
//        SpringJdbcDemo sp=new SpringJdbcDemo(ds);
//
//    }

    public static void main3(String[] args) throws IOException {
        AbstractApplicationContext aac = new ClassPathXmlApplicationContext("spring-config.xml");
        UsersRepository usersComponent = aac.getBean(UsersRepository.class);
        int a = usersComponent.addCustomer();
        System.out.println(a);
        aac.registerShutdownHook();
    }

    public static void main2(String[] args) throws IOException {
        AbstractApplicationContext aac = new ClassPathXmlApplicationContext("spring-config.xml");
        UsersRepository usersComponent = aac.getBean(UsersRepository.class);
        Customerr c = usersComponent.getSingleCustomer();
        System.out.println(c);
    }

    public static void main(String[] args) {
        AbstractApplicationContext aac = new ClassPathXmlApplicationContext("spring-config.xml");
//              aac.registerShutdownHook();

        UsersRepository usersComponent = aac.getBean(UsersRepository.class);
        int a = usersComponent.updateCustomer();
        System.out.println(a);
        aac.close();

    }
}
