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
public class Car implements Serializable{
  private String model;
  private double price;
  private transient String color;
  private Engine engine;

  @Override
  public String toString() {
    return "Car{" + "model=" + model + ", price=" + price + ", color=" + color + ", engine=" + engine + '}';
  }

  public Car(String model, double price, String color, Engine engine) {
    this.model = model;
    this.price = price;
    this.color = color;
    this.engine = engine;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

}
