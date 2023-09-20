/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */import java.util.Scanner;
public class OrderCheck{
    
   boolean isInOrder(String a){
       boolean flag=true;
       for (int i = 0; i < a.length()-1; i++) {
           if((a.charAt(i+1)-a.charAt(i))<=0){
               flag=false;
           }
        }return flag;
   }
    public static void main(String[] args) {
        OrderCheck o=new OrderCheck();
        Scanner scn=new Scanner(System.in);
        System.out.println("enter the string");
        String str=scn.next();
        boolean t=o.isInOrder(str);
        System.out.println(t);
    }
}

