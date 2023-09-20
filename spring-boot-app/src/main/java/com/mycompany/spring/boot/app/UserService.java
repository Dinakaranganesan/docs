/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring.boot.app;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bas200181
 */
@Service
public class UserService {

    @Autowired
    UsersRepository repository;

    public List<Customer> getall() {
        return repository.getCustomer();
    }

    public int addCustomer(Customer c) {
        return repository.addCustomer(c);
    }
     public Customer getSingleCustomer(int cusId) {
        return repository.getSingleCustomer(cusId);
    }
}
