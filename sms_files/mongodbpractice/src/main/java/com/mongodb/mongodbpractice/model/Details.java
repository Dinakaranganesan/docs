/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mongodb.mongodbpractice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author bas200181
 */
@Document("det")
public class Details {

    @Id
    @Field(name = "_id")
    private String id;

    private String city;
    @Field(name = "loc")
    private double[] location;
    private int pop;
    private String state;
    
    public Details() {
    }

    public Details(String id, String city, double[] location, int pop, String state) {
        this.id = id;
        this.city = city;
        this.location = location;
        this.pop = pop;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Details{" + "id=" + id + ", city=" + city + ", location=" + location + ", pop=" + pop + ", state=" + state + '}';
    }

}
