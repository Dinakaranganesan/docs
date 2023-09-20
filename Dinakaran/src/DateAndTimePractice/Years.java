/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DateAndTimePractice;

import java.time.LocalDate;

/**
 *
 * @author bas200181
 */
public class Years {

  private Years() {
  }

  static Years now() {
    return new Years();
  }

  void now1() {
    System.out.println(LocalDate.now());
  }

}
