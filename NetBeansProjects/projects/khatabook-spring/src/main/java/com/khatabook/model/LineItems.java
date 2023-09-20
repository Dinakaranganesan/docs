/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.model;

/**
 *
 * @author bas200181
 */
public class LineItems {

    private int orderId;
    private int productId;
    private String proName;
    private int quantity;
    private double price;

    public LineItems(int orderId, int productId, String proName, int quantity, double price) {
        this.orderId = orderId;
        this.productId = productId;
        this.proName = proName;
        this.quantity = quantity;
        this.price = price;
    }

    public LineItems() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LineItemss{" + "orderId=" + orderId + ", productId=" + productId + ", proName=" + proName + ", quantity=" + quantity + ", price=" + price + '}';
    }

}
