
public class Shirt {

    final String BRAND;
    final String COLOR;
    private double price;
    String size;

    Shirt() {
        BRAND = "Allen solly";
        COLOR = "black";
        price = 1000.0;
        size = "L";
    }

    Shirt(String brand) {
        this.BRAND = brand;
        COLOR = "black";
        price = 1500.0;
        size = "XL";
    }

    Shirt(String brand, String color) {
        this.BRAND = brand;
        this.COLOR = color;
        price = 2000.0;
        size = "XXL";
    }

    Shirt(String brand, String color, double price) {
        this.BRAND = brand;
        this.COLOR = color;
        this.price = price;
        size = "M";

    }

    Shirt(String brand, String color, double price, String size) {
        this.BRAND = brand;
        this.COLOR = color;
        price = 3000.0;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 500) {
            System.out.println("No Shirts Available with that budget");
        } else {
            this.price = price;
        }
    }

}
