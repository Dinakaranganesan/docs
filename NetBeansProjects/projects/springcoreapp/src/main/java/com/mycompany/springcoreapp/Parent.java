/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

/**
 *
 * @author bas200181
 */
public class Parent {

    private String parentName;
    private String parentAge;
    
//    {
//        parentName="annan";
//        parentAge="10000";
//    }

//    private String parentName="dina";
//  private String parentAge="70";
    public Parent() {
    }

    public Parent(String parentName, String parentAge) {
        this.parentName = parentName;
        this.parentAge = parentAge;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentAge() {
        return parentAge;
    }

    public void setParentAge(String parentAge) {
        this.parentAge = parentAge;
    }

    @Override
    public String toString() {
        return "Parent{" + "parentName=" + parentName + ", parentAge=" + parentAge + '}';
    }

}
