///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.spring.boot.app;
//
//import javax.sql.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityFilter1 {
//
////    @Bean
////    public PasswordEncoder pwdEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//   @Bean
//   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
// 
//
//        http.authorizeHttpRequests(c
//                -> c.requestMatchers(HttpMethod.GET, "getcus").hasRole("OWNER")
//                  
//        );
//
// 
//
//        //use HTTP authentication
//        http.httpBasic(Customizer.withDefaults());
//
// 
//
//        /// it is a security disable know more see the java documentation notes has links
////        http.csrf().disable();
//        http.csrf(c -> c.disable());
//
// 
//
//        return http.build();
//    } 
//   @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//
// 
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
// 
//
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_name,roles from khatabook_user_roles where user_name=?");
//        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_name,password,status from khatabook_users where user_name=?");
//
//
// 
//
//        return jdbcUserDetailsManager;
//    }
//}
