/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mongodb.mongodbpractice.detcontroller;

import com.mongodb.mongodbpractice.Drepo.Drepo;
import com.mongodb.mongodbpractice.model.Details;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bas200181
 */
@RestController
public class DController {
    @Autowired
    Drepo dr;

    @GetMapping("/findAllDet")
    public List<Details> getBooks() {
        System.out.println(dr.findAll());
        return dr.findAll();
    }
@PostMapping("/adddet")
public String addDetail(@RequestBody Details det)
{
    dr.save(det);
    return "Details added Successfully";
}       
@GetMapping("/findone/{id}")
public Optional<Details> getDetails(@PathVariable String id){
    return dr.findById(id);
  
}

}
