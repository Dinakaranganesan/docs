/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring.boot.app;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author bas200181
 */
@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder pwdEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configSecuriiy(HttpSecurity http) throws Exception {

        http
                //                        .securityMatcher("all-authenticated/**")
                .authorizeHttpRequests(authorize
                        -> authorize.requestMatchers("/all-authenticated/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
                        .requestMatchers("/WEB-INF/pages/").permitAll()
                        .requestMatchers("/getcus").hasAuthority("ROLE_ADMIN")
//                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsManager userDetails(DataSource ds) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(ds);
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_name,roles from khatabook_user_roles where user_name=?");
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_name,password,status from khatabook_users where user_name=?");
        return jdbcUserDetailsManager;
    }
}
