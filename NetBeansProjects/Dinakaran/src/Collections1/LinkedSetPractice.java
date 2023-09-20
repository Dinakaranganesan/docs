/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collections;

import java.util.LinkedHashSet;

/**
 *
 * @author bas200181
 */
public class LinkedSetPractice {
  public static void main(String[] args) {
    LinkedHashSet lhs = new LinkedHashSet();
    lhs.add(10);
    lhs.add(5);
    lhs.add(67);
    lhs.add(15);
    lhs.add(15);
    System.out.println(lhs);
    LinkedHashSet lhs1 = new LinkedHashSet();
    lhs1.addAll(lhs);
    System.out.println(lhs1);
  }
}
