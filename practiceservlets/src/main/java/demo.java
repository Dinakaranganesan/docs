/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class demo {
    public static void main(String[] args) {
        
   Name firstName=new Name("kannan");
   Name secondName=firstName;
        System.out.println(firstName);
        System.out.println(secondName);
        firstName.name="Dina";
        System.out.println(secondName);
    }
    
}
