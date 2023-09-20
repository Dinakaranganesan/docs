/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.controller;

import com.khatabook.model.Inventory;
import com.khatabook.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bas200181
 */
@Controller
public class ProductController {

    @Autowired
    ProductService ps;
//
//    @GetMapping("/view")
//    @ResponseBody
//    public String showAll() {
//        return cs.getAll().toString();
//    }

    @GetMapping("/products")
    // @ResponseBody
    public String getProducts(ModelMap data) {
        List<Inventory> list = ps.getAllProducts();
        data.addAttribute("product", list);
        return "/product/viewAllProducts";
    }

    @GetMapping("/addproduct")
    // @ResponseBody
    public String addProduct() {
        return "/product/addProduct";
    }

    @PostMapping("/addp")
    @ResponseBody
    public Boolean addCus(@RequestParam(name = "productid") Integer proId, @RequestParam(name = "proname") String name,
            @RequestParam(name = "quantity") int quantity,
            @RequestParam(name = "price") double price) {
        return ps.addProduct(new Inventory(proId, name, quantity, price)) > 0;
    }

    @GetMapping("/viewsinglepro")
    // @ResponseBody
    public String jspProdcut() {
        return "/product/viewParticularProduct";
    }

    @PostMapping("/viewsingle")
    public String getSingleProduct(ModelMap data, @RequestParam(name = "getpd") int proid) {
        List<Inventory> inventoryList = ps.viewSingleProduct(proid);
        data.addAttribute("product", inventoryList);
        return "/product/viewAllProducts";
    }

    @GetMapping("/productform")
    // @ResponseBody
    public String uf(ModelMap data, @RequestParam(name = "id") int prodId) {
        data.addAttribute("product", ps.viewSingleProduct(prodId).get(0));
        System.out.println(ps.viewSingleProduct(prodId).get(0));

        return "/product/updateProductForm";
    }

    @PostMapping("/proupd")
    @ResponseBody
    public int updProduct(@RequestParam(name = "id") int proId, @RequestParam(name = "proname") String proname, @RequestParam(name = "quantity") int quantity, @RequestParam(name = "price") double price) {
        return ps.updProduct(new Inventory(proId, proname, quantity, price));
    }
}
