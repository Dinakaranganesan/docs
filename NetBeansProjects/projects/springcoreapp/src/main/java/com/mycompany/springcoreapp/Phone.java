/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

/**
 *
 * @author bas200181
 */
public class Phone {    
    private Sim sim;

    public void setSim(Sim sim) {
        this.sim = sim;
    }
    public void calling(){
       sim.insertsim();
    }
    
}
