/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring.boot.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bas200181
 */
@Repository
public class UsersRepository {
    
    private JdbcTemplate jdbcTemplate;
    protected BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public UsersRepository(@Autowired DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
    public Customer getSingleCustomer(int a) {
        return jdbcTemplate.queryForObject("select * from Customer where customer_id=" + a, new UserRowMapper());
    }
    public List<Customer> getCustomer() {
        return jdbcTemplate.query("select * from Customer ", new UserRowMapper());
    }
    public int addCustomer(Customer c) {
        return jdbcTemplate.update("insert into Customer values(?,?,?,?,?,?)", c.getCusId(), c.getCusName(), c.getPhoneNo(), c.getCusAadhaar(), c.getCusAddress(), c.getCusBal());
    }
    public int updateCustomer(){
        return jdbcTemplate.update("update Customer set customer_name=?  where customer_id=?", "Ranga",26);
            }
}
