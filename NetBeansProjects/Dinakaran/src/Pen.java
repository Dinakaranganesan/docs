
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
public class Pen implements Comparable {
  public static String category;
  String brand;
  String color;
  private double price;
  public final LocalDateTime MFG_DATE;
  {
    MFG_DATE = LocalDateTime.now();
  }
  static {
    category = "Writing Instruments";
  }
  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    if (price < 5.0) {
      throw new IllegalArgumentException();
    } else {
      this.price = price;
    }
  }
  Pen() {
    this("cello");
    //color = "black";
    //price = 10.0;
  }
  Pen(String brand) {
    this(brand, "Black");
    //this.brand = brand;
    // color = "black";
    //price = 10.0;
  }
  Pen(String brand, String color) {
    this(brand, color, 10);
//        this.brand = brand;
//        this.color = color;
//        price = 10.0;
  }
  Pen(String brand, String color, double price) {
    this.brand = brand;
    this.color = color;
    this.price = price;
  }
  @Override
  public int compareTo(Object pa) {
    if (pa instanceof Pen that) {
      if (this.price == that.price) {
        return 0;
      } else if (this.getPrice() > that.getPrice()) {
        return 1;
      }
    }
    return -1;
  }
  @Override
  public String toString() {
    return "Pen{" + "brand=" + brand + ", color=" + color + ", price=" + price + ", MFG_DATE=" + MFG_DATE + '}';
  }
}
