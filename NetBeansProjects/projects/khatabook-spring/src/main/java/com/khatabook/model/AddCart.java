/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.model;

import java.sql.Date;

/**
 *
 * @author bas200181
 */
public class AddCart {

    public AddCart() {
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private int customerId;
    private int orderId;
    private Date date;
    private double price;
    private String status;

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AddCart(int customerId, int orderId, Date date, double price, String status) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "AddCart{" + "customerId=" + customerId + ", orderId=" + orderId + ", date=" + date + ", price=" + price + ", status=" + status + '}';
    }
    
}
