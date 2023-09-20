/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

import java.io.Serializable;

/**
 *
 * @author bas200181
 */
public class Engine implements Serializable {
  private String brand;
  private String type;
  private double price;

  public String getBrand() {
    return brand;
  }

  @Override
  public String toString() {
    return "Engine{" + "brand=" + brand + ", type=" + type + ", price=" + price + '}';
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Engine(String brand, String type, double price) {
    this.brand = brand;
    this.type = type;
    this.price = price;
  }
  public static void main(String[] args) {
    System.out.println("kannan dinakaran,asif ,vijay");
  }
  
}
