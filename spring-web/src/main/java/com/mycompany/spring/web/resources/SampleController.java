package com.mycompany.spring.web.resources;

import jakarta.ws.rs.core.MediaType;
import java.util.Objects;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
@Controller
public class SampleController {

    @GetMapping("/hi")
    @ResponseBody
    public String sayHello(@RequestParam(name = "un", required = false) String name) {
        if (Objects.nonNull(name) && !name.isEmpty()) {
            return "hello";
        } else {
            return "not";
        }
    }

    @GetMapping("/hi/{userId}")
    @ResponseBody
    public String sayHello(@RequestParam(name = "un", required = false) String name, @PathVariable(name = "userId", required = false) Integer userId) {
        if (Objects.nonNull(name) && !name.isEmpty()) {
            if (Objects.nonNull(userId) && !name.isEmpty()) {
                return "hello" + name;
            } else {
                return "not";
            }
        } else {
            return "noo";
        }
    }

    @GetMapping("/user")
   // @ResponseBody
    public String getCustomer(ModelMap data) {
        data.addAttribute("user" ,new Customerr(70, "Jithesh", "89899900", "6683727832", "tirunelveli", 0));
 
    return "newUser"
            ;}

    @GetMapping(path = "/new", produces = MediaType.APPLICATION_XML)
    @ResponseBody
    public Customerr xmlView() {
        return new Customerr(70, "Jithesh", "89899900", "6683727832", "tirunelveli", 0);
    }

    @GetMapping(path = "/new2", produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public Customerr jsonView() {
        return new Customerr(70, "Jithesh", "89899900", "6683727832", "tirunelveli", 0);

    }
   

}
