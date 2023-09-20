/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPS;

import java.time.LocalDate;

/**
 *
 * @author bas200181
 */
public class DiscountRate {
    private static double serviceDiscountPremium=0.2;
    private static double serviceDiscountGold=0.15;
    private static double serviceDiscountSilver=0.1;
    private static double productDiscountPremium=0.1;
    private static double productDiscountGold=0.1;
    private static double productDiscountSilver=0.1;
     
    public static double getServiceDiscount(String type)
    {
        if(type=="premium")
            return serviceDiscountPremium;
        else if(type=="gold")
            return serviceDiscountGold;
        else if(type=="silver")
            return serviceDiscountSilver;
        else
            return 0;
    }
     public static double getProductDiscount(String type){
         if(type=="premium")
               return productDiscountPremium;
         else if(type=="gold")
               return productDiscountGold;
         else if(type=="silver")
             return productDiscountSilver;
         else
             return 0.1;
     }
     public static void main(String[] args) {
         //System.out.println("hii");
         Visit v1=new Visit("Dinesh",LocalDate.now());
         v1.setMember(true);
         v1.setMemberType("gold");
         String result=v1.getMemberType();
         double sd=DiscountRate.getServiceDiscount(result);
         System.out.println(sd);
         double pd= DiscountRate.getProductDiscount(result);
         System.out.println(pd);
          v1.setServiceExpense(300);
         v1.setProductExpense(200);
         //System.out.println(v1.getProductExpense());
         double f=pd*v1.getProductExpense();
         double d=sd*v1.getServiceExpense();
         System.out.println(f+""+d);
         double c=v1.getTotalExpenses(f,d);
         System.out.println(c);
         
     }
     }
    
