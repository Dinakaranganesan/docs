/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPS;

/**
 *
 * @author bas200181
 */
public class Manager extends Members{
     String Specialization;
    String Department;
     public static void main(String[] args) {
        Manager m=new Manager();
        m.Name="Gopal";
        m.Phonenumber="8428268428";
       m.setSalary(45000);
        m.age=35;
        m.address="AMBEDKAR STREET GANDHI NAGAR";
        System.out.println(m.Name);
        System.out.println(m.Phonenumber);
         System.out.println(m.getSalary());
        System.out.println(m.address);
        System.out.println(m.age);
      
    }
    
}
    

