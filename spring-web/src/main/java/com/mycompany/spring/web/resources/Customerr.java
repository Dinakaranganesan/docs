/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring.web.resources;

/**
 *
 * @author bas200181
 */
public class Customerr {

  private int cusId;
  private String cusName;
  private String phoneNo;
  private String cusAddress;
  private String cusAadhaar;

  public Customerr() {
  
  }

  public String getCusAadhaar() {
    return cusAadhaar;
  }

  public void setCusAadhaar(String cusAadhaar) {
    this.cusAadhaar = cusAadhaar;
  }
  private double cusBal;

  public Customerr(int cusId, String cusName, String phoneNo, String cusAadhaar, String cusAddress, double cusBal) {
    this.cusId = cusId;
    this.cusName = cusName;
    this.phoneNo = phoneNo;
    this.cusAddress = cusAddress;
    this.cusAadhaar = cusAadhaar;
    this.cusBal = cusBal;
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

  public String getCusAddress() {
    return cusAddress;
  }

  public void setCusAddress(String cusAddress) {
    this.cusAddress = cusAddress;
  }

  public double getCusBal() {
    return cusBal;
  }

  @Override
  public String toString() {
    return "Customerr{" + "cusId=" + cusId + ", cusName=" + cusName + ", phoneNo=" + phoneNo + ", cusAddress=" + cusAddress + ", cusAadhaar=" + cusAadhaar + ", cusBal=" + cusBal + '}';
  }

 

  public void setCusBal(double cusBal) {
    this.cusBal = cusBal;
  }

}
