/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring.boot.app;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bas200181
 */
@Repository
public class UserRepository {
      private JdbcTemplate jdbcTemplate;
          public UserRepository(@Autowired DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
          public int addd(User u){
              return jdbcTemplate.update("insert into user values(?,?)", u.getUserName(),u.getPassword());
          }
}
