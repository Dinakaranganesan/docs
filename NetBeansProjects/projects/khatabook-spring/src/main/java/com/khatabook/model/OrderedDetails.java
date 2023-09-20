/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.model;

import java.sql.Date;

/**
 *
 * @author bas200181
 */
public class OrderedDetails {

  private int cusId;
  private String cusName;
  private String phoneNo;

  public OrderedDetails(int cusId, String cusName, String phoneNo, int orderId, Date orderDate, double totalAmount) {
    this.cusId = cusId;
    this.cusName = cusName;
    this.phoneNo = phoneNo;
    this.orderId = orderId;
    this.orderDate = orderDate;
    this.totalAmount = totalAmount;
  }
  private int orderId;
  private Date orderDate;
  private double totalAmount;

  public OrderedDetails(int cusId, String cusName, int orderId, Date orderDate, double totalAmount) {
    this.cusId = cusId;
    this.cusName = cusName;
    this.orderId = orderId;
    this.orderDate = orderDate;
    this.totalAmount = totalAmount;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public int getCusId() {
    return cusId;
  }

  public void setCusId(int cusId) {
    this.cusId = cusId;
  }

  public String getCusName() {
    return cusName;
  }

  public void setCusName(String cusName) {
    this.cusName = cusName;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }

  @Override
  public String toString() {
    return "OrderedDetails{" + "cusId=" + cusId + ", cusName=" + cusName + ", orderId=" + orderId + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + '}';
  }

}
