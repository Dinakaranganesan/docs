 package Khatajdbc;


import static Khatajdbc.KhataBook.input;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
//import java.util.Scanner;

public class Inventory {

    static Inventory[] avail_products = new Inventory[0];
    String name;
    int quantity;
    double price;
    int product_Id;
    static int proId;
    static int i = 0;
    //  int index = 0;
    String netweight;
    // static Scanner s = new Scanner(System.in);

    public Inventory() {

    }

//    static {
//
//        avail_products[0] = new Inventory(proId, "Tiger", 150, 10.0, "150g");
//        avail_products[1] = new Inventory(++proId, "Parle g", 350, 5.0, "100");
//        avail_products[2] = new Inventory(++proId, "Icecream", 250, 25.0, "100g");
//        avail_products[3] = new Inventory(++proId, "Chocolate", 150, 20.0, "150g");
//        avail_products[4] = new Inventory(++proId, "lays", 100, 25.0, "100g");
//
//    }
    public static void view_Product() {
        //System.out.println("testing");
        //System.out.println(avail_products.length);
          System.out.print("\n"+"-".repeat(4)+"+"+"-".repeat(15)+"+"+"-".repeat(12)+"+"+"-".repeat(13)+"+"+"-".repeat(25)+"+");
System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|","Id","Product name","price","quantity","weight"); 
System.out.print("\n+"+"-".repeat(4)+"+"+"-".repeat(15)+"+"+"-".repeat(12)+"+"+"-".repeat(13)+"+"+"-".repeat(25)+"+");
        
        
        for (Inventory x : avail_products) {
            System.out.print(x);
             System.out.print("\n+"+"-".repeat(4)+"+"+"-".repeat(15)+"+"+"-".repeat(12)+"+"+"-".repeat(13)+"+"+"-".repeat(25)+"+");
        }
        System.out.println("");
    }

    public Inventory(int proId, String name, int quantity, double price, String netweight) {
        this.product_Id = proId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.netweight = netweight;

        //public static void view()
        // {
//     avail_products=Arrays.copyOf(avail_products,avail_products.length+1); 
        //  System.out.println(avail_products[i]);
        //}
    }

    public static void update_Product() {
        try {//avail_products=Arrays.copyOf(avail_products,avail_products.length+1);
            System.out.println("Enter the product name");
            String name = input.readLine();
            System.out.println("Enter the Quantity");
            int quantity = Integer.parseInt(input.readLine());
            for (int i = 0; i < avail_products.length; i++) {
                if (avail_products[i].name.equalsIgnoreCase(name)) {
                    avail_products[i].quantity += quantity;
                    System.out.println("Successfully added");
                    break;
                } //  ++i;

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void add_Product() {
        try {
        //  System.out.println("Enter Product ID");
            int prod_id=avail_products[avail_products.length-1].product_Id+1;
            System.out.println("Enter the product name");
            String name = input.readLine();
            System.out.println("Enter the price");
            double price = Double.parseDouble(input.readLine());
            System.out.println("Enter the Quantity");
            int quantity = Integer.parseInt(input.readLine());
            System.out.println("Enter the netweight");
            String netweight = input.readLine();

            avail_products = Arrays.copyOf(avail_products, avail_products.length + 1);
            avail_products[avail_products.length - 1] = new Inventory(prod_id, name, quantity, price, netweight);
            System.out.println(" Added Successfully");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void writeInventory() {
        try ( DataOutputStream dos = new DataOutputStream(new FileOutputStream("/home/bas200181/NetBeansProjects/Dinakaran/KhataBookFiles/ProductFiles.txt"))) {
            for (int j = 0; j < avail_products.length; j++) {
                dos.writeInt(avail_products[j].product_Id);
                dos.writeUTF(avail_products[j].name);
                dos.writeInt(avail_products[j].quantity);
                dos.writeDouble(avail_products[j].price);
                dos.writeUTF(avail_products[j].netweight);

            }

        } catch (Exception e) {

        }
    }

    public static void readInventory() {
        try ( DataInputStream dos = new DataInputStream(new FileInputStream("/home/bas200181/NetBeansProjects/Dinakaran/KhataBookFiles/ProductFiles.txt"))) {

            while (true) {
                int id = dos.readInt();
                String name = dos.readUTF();
                int quantity = dos.readInt();
                double price = dos.readDouble();
                String netweight = dos.readUTF();

                avail_products = Arrays.copyOf(avail_products, avail_products.length + 1);
                avail_products[avail_products.length - 1] = new Inventory(id, name, quantity, price, netweight);
            }

        } catch (Exception e) {
            System.out.println("read complete");
            // System.out.println(e);
//            for (Customer x : cus_Details) {
//                System.out.println(""+x.cus_Id+""+x.Aaadhar_No+""+x.cus_name+""+x.cus_Address+""+x.Phone_no);
//
//            }
//for(int i=0;i<cus_Details.length;i++){
//    System.out.println(""+cus_Details[i].cus_Id+""+cus_Details[i].Aaadhar_No+""+cus_Details[i].cus_name+""+cus_Details[i].cus_Address+""+cus_Details[i].Phone_no);
//}
        }
    }

    @Override
    public String toString() {
       
// return "  " + "Product_id:" + product_Id + " " + " name :" + name + " " + "price:" + price + " " + "quantity :" + quantity + " " + "weight :" + netweight;
   
       return String.format("\n|%-4d|%-15s|%12.2f|%-13s|%-25s|",
           this.product_Id, this.name, this.price,this.quantity , this.netweight);}

//    public static void main(String[] args) {
//        writeInventory();
//    }
}

//        public static void main(String[] args) {
//        Inventory i=new Inventory();
//       //i.view();
//        i.add();
//    }
//    
//    
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public short getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(short quantity) {
//        this.quantity = quantity;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public static short getProduct_Id() {
//        return product_Id;
//    }
//
//    public static void setProduct_Id(short product_Id) {
//        Inventory.product_Id = product_Id;
//    }
