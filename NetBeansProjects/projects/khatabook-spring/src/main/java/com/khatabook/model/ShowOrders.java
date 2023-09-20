/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.model;

import java.util.List;

/**
 *
 * @author bas200181
 */
public class ShowOrders {

    List<Orders> order;
    List<LineItems> line;

    public ShowOrders() {
    }

    public ShowOrders(List<Orders> order, List<LineItems> line) {
        this.order = order;
        this.line = line;
    }

    public List<Orders> getOrder() {
        return order;
    }

    public void setOrder(List<Orders> order) {
        this.order = order;
    }

    public List<LineItems> getLine() {
        return line;
    }

    public void setLine(List<LineItems> line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "ShowOrders{" + "order=" + order + ", line=" + line + '}';
    }

}
