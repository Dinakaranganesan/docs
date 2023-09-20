/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.sql.DataSource;
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

    public UsersRepository(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public Customerr getSingleCustomer() throws IOException {
        System.out.println("Enter the Customer id");
        int a = Integer.parseInt(br.readLine());
        return jdbcTemplate.queryForObject("select * from Customer where customer_id=" + a, new UserRowMapper());
    }

    public List<Customerr> getCustomer() {

        return jdbcTemplate.query("select * from Customer ", new UserRowMapper());
    }

    public int addCustomer() throws IOException {
        System.out.println("Enter the CustomerId");
        int id = Integer.parseInt(br.readLine());
        System.out.println("Enter the Customer Name");
        String name = br.readLine();
        System.out.println("Enter the mobile"); 
        String phone = br.readLine();
        System.out.println("Enter the aadhaar");
        String adhaar = br.readLine();
        System.out.println("Enter the address");
        String addr = br.readLine();
        System.out.println("Enter the balance");
        double bal = Double.parseDouble(br.readLine());
        Customerr c = new Customerr(id, name, phone, adhaar, addr, bal);
        return jdbcTemplate.update("insert into Customer values(?,?,?,?,?,?)", c.getCusId(), c.getCusName(), c.getPhoneNo(), c.getCusAadhaar(), c.getCusAddress(), c.getCusBal());
    }
    public int updateCustomer(){
        return jdbcTemplate.update("update Customer set customer_name=?  where customer_id=?", "Ranga",26);
            }
}
