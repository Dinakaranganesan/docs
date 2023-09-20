/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

/**
 *
 * @author bas200181
 */
public class Mobile {

    private String brand;
    private String color;
    private String model;
    private String specs;
    private double price;
    private MotherBoard motherboard;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Mobile() {

    }

    public String getSpecs() {
        return specs;
    }

    public String getBrand() {
        return brand;
    }

    public Mobile(String brand, String color, String model, String specs, double price, MotherBoard motherboard) {
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.specs = specs;
        this.price = price;
        this.motherboard = motherboard;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public MotherBoard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(MotherBoard motherboard) {
        this.motherboard = motherboard;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Override
    public String toString() {
        return "Mobile{" + "brand=" + brand + ", color=" + color + ", model=" + model + ", specs=" + specs + ", price=" + price + ", motherboard=" + motherboard + '}';
    }

}
