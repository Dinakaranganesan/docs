/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Khatajdbc;

import static Khatajdbc.Inventory.avail_products;
import static Khatajdbc.KhataBook.input;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 *
 * @author bas200181
 */
public class Customer {

    String ent_mob;
    int quan;
    String cus_name;
    String Phone_no;
    String cus_Address;
    String Aaadhar_No;
    double cus_balance;
    //static Scanner s = new Scanner(System.in);
    static int i = 0;
    static Customer cus_Details[] = new Customer[0];
    short cus_Id = 1;
    static Inventory temp = new Inventory();
//static Order[]o=new Order[0];

    public Customer() {
    }

    public Customer(short cus_Id, String cus_name, String Phone_no, String cus_Address, String Aaadhar_No,double cus_balance) {
        this.cus_Id = cus_Id;
        this.cus_name = cus_name;
        this.Phone_no = Phone_no;
        this.Aaadhar_No = Aaadhar_No;
        this.cus_Address = cus_Address;
        this.cus_balance=cus_balance;
    }

    public void add() {
        try {
            //readCus();
            boolean check = false;

            System.out.println("Enter the Customer Name");
            String cus_Name = input.readLine();
            System.out.println("Enter the Mobile Number");
            String Phone_no = "";
            while (!check) {
                Phone_no = input.readLine();
                if ((Phone_no.length() > 4) && (Phone_no.chars().filter(Character::isDigit).count() == Phone_no.length())) {
                    check = true;
                } else {
                    System.err.println("\u26A0 Enter a Phone Number");
                }
            }
            System.out.println("Enter the Address ");
            String cus_Address = input.readLine();
            System.out.println("Enter the Aaadhar Number");
            String Aaadhar_No = input.readLine();
            double cus_balance=0;
            if (cus_Details.length > 0) {
                cus_Id = (short) (cus_Details[cus_Details.length - 1].cus_Id + 1);
            }

            cus_Details = Arrays.copyOf(cus_Details, cus_Details.length + 1);
            cus_Details[cus_Details.length - 1] = new Customer(cus_Id, cus_Name, Phone_no, cus_Address, Aaadhar_No,cus_balance);
            System.out.println("Successfully added");
            i++;
            //cus_Id++;
            //writeCus();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void view() {
        try {
            System.out.println("Enter the MobileNumber:");
            String view_Mob = input.readLine();
            for (int i = 0; i < cus_Details.length; i++) {

                if (view_Mob.equals(cus_Details[i].Phone_no)) {
                    System.out.println(cus_Details[i]);
                    break;
                } else if (i == cus_Details.length - 1) {
                    System.out.println("not found");
                }

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void update() {
        try {
            System.out.println("Enter the Old MobileNumber:");
            String old_Mob = input.readLine();

            for (int i = 0; i < cus_Details.length; i++) {
                if (old_Mob.equals(cus_Details[i].Phone_no)) {
                    System.out.println("Mobile Number is matched");
                    System.out.println("Enter the New Mobile Number");
                    String new_Mob = input.readLine();
                    cus_Details[i].Phone_no = new_Mob;
                    System.out.println("Mobile NUmber Updated");
                    break;
                } else if (i == cus_Details.length - 1) {
                    System.out.println("not found");
                }

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void viewAll() {
        // readCus();
        //|%-4d|%-15s|%-12s|%-13s|%-25s|%9.2f|",
        System.out.print("\n+"+"-".repeat(4)+"+"+"-".repeat(15)+"+"+"-".repeat(12)+"+"+"-".repeat(13)+"+"+"-".repeat(25)+"+"+"-".repeat(9)+"+");
System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|","Id","customer name","phonenumber","Aadhar Number","Address","Balance"); 
System.out.print("\n+"+"-".repeat(4)+"+"+"-".repeat(15)+"+"+"-".repeat(12)+"+"+"-".repeat(13)+"+"+"-".repeat(25)+"+"+"-".repeat(9)+"+");
        
        for (Customer x : cus_Details) {
            System.out.print(x);
             System.out.print("\n+"+"-".repeat(4)+"+"+"-".repeat(15)+"+"+"-".repeat(12)+"+"+"-".repeat(13)+"+"+"-".repeat(25)+"+"+"-".repeat(9)+"+");
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        //System.out.println("======================================================================================================================================================================================================");
       /// return " " + "Customer_ID :" + this.cus_Id + "  " + "Mobile Number :" + this.Phone_no + " " + "Customer Name: " + this.cus_name + " " + "Aaadhar Number: " + this.Aaadhar_No + " " + "Customer Address :" + this.cus_Address+" "+"Customer Balance:"+cus_balance;
   return String.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|",
           this.cus_Id, this.cus_name, this.Phone_no,this.Aaadhar_No , this.cus_Address, cus_balance);



   
    }

    public void place_Order() {
        try {
            System.out.println("Enter the Mobile Number");
            ent_mob = input.readLine();
            for (int i = 0; i < cus_Details.length; i++) {
                if (ent_mob.equals(cus_Details[i].Phone_no)) {
//                cus_Details[i].Phone_no
                    temp.view_Product();
                    System.out.println("Enter the Product_Id");
                    int pro_Id = Integer.parseInt(input.readLine());
                    for (int j = 0; j < avail_products.length; j++) {
                        // System.out.println("hdasjx");
                        if (avail_products[j].product_Id == pro_Id) {
                            System.out.println("Enter the Quantity");
                            quan = Integer.parseInt(input.readLine());
                            if (quan > 0) {

                                avail_products[j].quantity -= quan;

                            }

                        }

                    }
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void writeCus() {
        try ( DataOutputStream dos = new DataOutputStream(new FileOutputStream("/home/bas200181/NetBeansProjects/Dinakaran/KhataBookFiles/CustomerFile.txt"))) {
            for (Customer x : cus_Details) {
                dos.writeShort(x.cus_Id);
                dos.writeUTF(x.cus_name);
                dos.writeUTF(x.Phone_no);
                dos.writeUTF(x.cus_Address);
                dos.writeUTF(x.Aaadhar_No);
                dos.writeDouble(x.cus_balance);

            }

        } catch (Exception e) {

        }
    }

    public static void readCus() {
        try ( DataInputStream dos = new DataInputStream(new FileInputStream("/home/bas200181/NetBeansProjects/Dinakaran/KhataBookFiles/CustomerFile.txt"))) {

            while (dos.available()>0) {
                short id = dos.readShort();
                String name = dos.readUTF();
                String phone = dos.readUTF();
                String address = dos.readUTF();
                String aadhar = dos.readUTF();
                double cus_balance=dos.readDouble();

                cus_Details = Arrays.copyOf(cus_Details, cus_Details.length + 1);
                cus_Details[cus_Details.length - 1] = new Customer(id, name, phone, address, aadhar,cus_balance);
            }

        } catch (Exception e) {
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

    public static void check() {
        try ( DataInputStream dos = new DataInputStream(new FileInputStream("/home/bas200181/Customerfiles/ddd.txt"))) {
            int i;
            while ((i = dos.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
        }
    }

//    public static void main(String[] args) {
//        //  readCus();
//        //check();
//    }
}
