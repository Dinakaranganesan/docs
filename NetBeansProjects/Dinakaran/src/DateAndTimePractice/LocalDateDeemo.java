/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DateAndTimePractice;

import com.sun.jdi.connect.spi.Connection;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author bas200181
 */
public class LocalDateDeemo {
  public static void main(String[] args) {
    LocalDate ld =LocalDate.now();
    System.out.println(ld);
    System.out.println(ld.getEra());
    System.out.println(ld.getDayOfWeek());
    System.out.println(ld.atTime(LocalTime.MIN));
    System.out.println(ld.atStartOfDay());
    System.out.println(ld.getChronology());
    System.out.println(ld.atTime(1, 50));
    System.out.println(ld.getDayOfMonth());
    System.out.println(ld.isLeapYear());
    System.out.println(ld.getYear());
    System.out.println(ld.getMonthValue());
    System.out.println(ld.hashCode());
    System.out.println(ld.lengthOfMonth());
    System.out.println(ld.lengthOfYear());
   // System.out.println(ld.);
            // System.out.println(ld.);
  }
}
