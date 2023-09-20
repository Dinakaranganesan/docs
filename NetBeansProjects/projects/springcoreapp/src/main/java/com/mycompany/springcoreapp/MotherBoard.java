/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

/**
 *
 * @author bas200181
 */
class MotherBoard {

    private String model;
    private String cpu;

    public MotherBoard() {
        super();
    }

    public MotherBoard(String model, String cpu) {
        this.model = model;
        this.cpu = cpu;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "MotherBoard{" + "model=" + model + ", cpu=" + cpu + '}';
    }

}
