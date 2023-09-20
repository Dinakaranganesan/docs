/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

import java.time.LocalDate;

/**
 *
 * @author bas200181
 */
public class DateDemo {
  public static void main(String[] args) {
    LocalDate t=LocalDate.now();
    System.out.println(t);
    LocalDate tPlus10=t.plusDays(10);
    System.out.println(tPlus10);
   // LocalDate.
    
  }
  
}
