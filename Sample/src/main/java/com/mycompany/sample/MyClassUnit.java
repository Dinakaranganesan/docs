/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sample;

/**
 *
 * @author bas200181
 */
public class MyClassUnit {

  public int add(int a, int b) {
    return a + b;
  }

  public int sub(int a, int b) {
    return a - b;
  }

  public int multi(int a, int b) {
    return a * b;

  }

  public static void main(String[] args) {
    MyClassUnit mycls = new MyClassUnit();

    int addResult = mycls.add(3, 2);
    int subResult = mycls.sub(3, 2);
    int multiResult = mycls.multi(3, 2);

    System.out.println("Add Result: " + addResult);
    System.out.println("Sub Result: "+ subResult);
    System.out.println("Mulit Result: "+ multiResult);
  }
}
