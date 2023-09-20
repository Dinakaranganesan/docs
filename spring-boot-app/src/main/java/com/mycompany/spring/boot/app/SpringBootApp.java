/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.spring.boot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author bas200181
 */
@SpringBootApplication
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
    
   

//    @Bean
//    public Employee createEmployee() {
//        return new Employee(0, "siva", 15000);
//    }
//
//    @Bean
//    public CommandLineRunner execute(ApplicationContext actx) {
//        String[] beanNames = actx.getBeanDefinitionNames();
//        for (String x : beanNames) {
//            System.out.println(x);
//        }
//        return null;
//    }
}
