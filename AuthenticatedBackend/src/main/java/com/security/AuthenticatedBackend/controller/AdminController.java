/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.security.AuthenticatedBackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bas200181
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @GetMapping("/")
    public String getAdminLevel() {
        return "Admin level Access";
    }
}
