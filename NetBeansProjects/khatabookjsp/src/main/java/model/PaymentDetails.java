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
public class PaymentDetails {
  private int cusId;
  private String cusName;
  private String phoneNo;
    private int paymentId;
  private double amount;
  private Date paidDate;

  public PaymentDetails(int cusId, String cusName, String phoneNo, int paymentId, double amount, Date paidDate) {
    this.cusId = cusId;
    this.cusName = cusName;
    this.phoneNo = phoneNo;
    this.paymentId = paymentId;
    this.amount = amount;
    this.paidDate = paidDate;
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

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public int getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(int paymentId) {
    this.paymentId = paymentId;
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
