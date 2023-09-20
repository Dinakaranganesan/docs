/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bas200181
 */
public class MyClassUnitTest {

  public MyClassUnitTest() {
  }

  /**
   * Test of add method, of class MyClassUnit.
   */
  @Test
  public void testAdd() {
    MyClassUnit my = new MyClassUnit();
    int result1 = my.add(3, 2);
    Assertions.assertEquals(5, result1);
    System.out.println("Addition Test..........");
  }

  /**
   * Test of sub method, of class MyClassUnit.
   */
  @Test
  public void testSub() {
    MyClassUnit my = new MyClassUnit();

    int result2 = my.sub(3, 2);
    assertEquals(1, result2);
    System.out.println("Subtraction test.........");
  }

  /**
   * Test of multi method, of class MyClassUnit.
   */
  @Test
  public void testMulti() {
    MyClassUnit my = new MyClassUnit();
    int result3 = my.multi(3, 2);
    assertTrue(result3<5);
    //assertEquals(6, result3);
    System.out.println("Multiplication Test.....");

  }

  /**
   * Test of main method, of class MyClassUnit.
   */
}
