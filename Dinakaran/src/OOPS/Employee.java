/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPS;

/**
 *
 * @author bas200181
 */
public class Employee extends Members {
    String Specialization;
    String Department;
    public static void main(String[] args) {
        Employee e=new Employee();
        e.Name="Raju";
        e.Phonenumber="8428278428";
        e.setSalary(15000);
        e.age=25;
        e.address="NETAJI STREET SUBRAMANI NAGAR";
        System.out.println(e.Name);
        System.out.println(e.Phonenumber);
        System.out.println(e.getSalary());
        System.out.println(e.address);
        System.out.println(e.age);
    }
    
}
