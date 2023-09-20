/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

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

    public List<Customerr> getall() {
        return repository.getCustomer();
    }

}
