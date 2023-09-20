/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

/**
 *
 * @author bas200181
 */
public class Child{

    private String childName;
    private String childAge ;
    private String parentName;
    private String parentAge;
    {
        childName="chinrasu";
        childAge="30";
    }
    public Child() {
    }

    public Child(String parentName, String parentAge) {
        this.parentName = parentName;
        this.parentAge = parentAge;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildAge() {
        return childAge;
    }

    public void setChildAge(String childAge) {
        this.childAge = childAge;
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
        return "Child{" + "childName=" + childName + ", childAge=" + childAge + ", parentName=" + parentName + ", parentAge=" + parentAge + '}';
    }
    

    
}
