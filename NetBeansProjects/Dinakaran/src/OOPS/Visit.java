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
public class Visit extends Customer{

  
    private Customer customer;
    private LocalDate date;
   private double serviceExpense;
   private double productExpense;

    public Visit(String name, LocalDate date) {
        super(name);
        this.date=date;
    }
      public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }
    public double getTotalExpenses(double a,double b)
    {
        return a+b;
    }
    @Override
    public String toString()
    {
        return ""+this.date;
   
}

    double getTotalExpense(double d, double d1) {
        return d+d1;   }
}