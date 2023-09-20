/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author bas200181
 */
public class Orderrs {

  private int orderID;
  private int cusId;
  private Date date;
  private double totalprice;

  public Orderrs(int orderID, int cusId, Date date, double totalprice) {
    this.orderID = orderID;
    this.cusId = cusId;
    this.date = date;
    this.totalprice = totalprice;
  }

  public Orderrs() {
     }

  public int getOrderID() {
    return orderID;
  }

  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }

  public int getCusId() {
    return cusId;
  }

  public void setCusId(int cusId) {
    this.cusId = cusId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getTotalprice() {
    return totalprice;
  }

  public void setTotalprice(double totalprice) {
    this.totalprice = totalprice;
  }

}
