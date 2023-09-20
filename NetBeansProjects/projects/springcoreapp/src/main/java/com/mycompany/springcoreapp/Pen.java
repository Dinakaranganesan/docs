/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

/**
 *
 * @author bas200181
 */
public class Pen {

    private double price;
    private String color;
    private String brand;

    public Pen() {
        System.out.println("pen constructor called >>>>>>>>>>>>>>>>>>");
    }

    public Pen(double price, String color, String brand) {
        this.price = price;
        this.color = color;
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//    @Override
//    public String toString() {
//        return "Pen{" + "price=" + price + ", color=" + color + ", brand=" + brand + '}';
//    }
}
