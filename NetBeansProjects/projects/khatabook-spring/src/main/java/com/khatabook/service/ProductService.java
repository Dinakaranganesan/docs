/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.service;

import com.khatabook.idao.KhataBookDao;
import com.khatabook.model.Inventory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bas200181
 */
@Service
public class ProductService {

    @Autowired
    KhataBookDao kb;

    public List<Inventory> getAllProducts() {
        return kb.getProductDaoObj().viewAll();
    }

    public int addProduct(Inventory i) {
        return kb.getProductDaoObj().addProduct(i);
    }

    public List<Inventory> viewSingleProduct(int proId) {
        return kb.getProductDaoObj().viewProduct(proId);
    }

    public Inventory getProDetails(int proId) {
        return kb.getProductDaoObj().getProductDetails(proId);
    }

    public int updProduct(Inventory i) {
        return kb.getProductDaoObj().updateProduct(i);

    }
}
