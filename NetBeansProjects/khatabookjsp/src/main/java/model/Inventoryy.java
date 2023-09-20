/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bas200181
 */
public class Inventoryy {

  private int productId;
  private String proName;
  private int quantity;
  private double price;

  public Inventoryy() {

  }

  public Inventoryy(int productId, String proName, int quantity, double price) {
    this.productId = productId;
    this.proName = proName;
    this.quantity = quantity;
    this.price = price;

  }



  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getProName() {
    return proName;
  }

  public void setProName(String proName) {
    this.proName = proName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
