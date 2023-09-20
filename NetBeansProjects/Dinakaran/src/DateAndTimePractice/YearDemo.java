/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DateAndTimePractice;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

/**
 *
 * @author bas200181
 */
public class YearDemo {
  public static void main(String[] args) {
    LocalDate l=LocalDate.now();
    Year y=Year.now();
   // Month m=new Month();
    System.out.println(y);
    System.out.println(l.getDayOfMonth());
    System.out.println(l.plusDays(365));
    System.out.println(y.atDay(365)+" 365 days");
    System.out.println(y.atMonth(Month.JULY));
    System.out.println(y.atMonth(12));
    //System.out.println(y.isSupported(field));
    System.out.println(y.getValue());
    //System.out.println(y.isBefore;
    
//    Years s=Years.now();
//    s.now1();
    
   
  }
  
}
