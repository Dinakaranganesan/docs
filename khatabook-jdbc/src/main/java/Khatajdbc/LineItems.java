/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Khatajdbc;

/**
 *
 * @author bas200181
 */
public class LineItems {

    //private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private double price;
    static LineItems[] l = new LineItems[0];

    public LineItems() {
        super();
    }

    public LineItems(int orderId, int productId, int quantity, double price) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    @Override
    public String toString() {
        return "\n" + "order: " + orderId + "\n" + "product id:  "
                + productId + "\n" + "Quantity :" + quantity + "\n" + "price:" + price;
    }
}
