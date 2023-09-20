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
public class Payment {
private int cusId;
  private int paymentId;
  
  private double amount;
  private Date paidDate;

  public Payment() {

  }

  public Payment(int paymentId, int cusId, double amount, Date paidDate) {
    this.paymentId = paymentId;
    this.cusId = cusId;
    this.amount = amount;
    this.paidDate = paidDate;
  }

  public int getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(int paymentId) {
    this.paymentId = paymentId;
  }

  public int getCusId() {
    return cusId;
  }

  public void setCusId(int cusId) {
    this.cusId = cusId;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Date getPaidDate() {
    return paidDate;
  }

  public void setPaidDate(Date paidDate) {
    this.paidDate = paidDate;
  }

}
