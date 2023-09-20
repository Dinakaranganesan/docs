/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class MethodP {

  public static int add() {
    return 1;

  }
public static int add1()
{
  return 2;
}
  public static int get() {
    return add()+add1();
  }

  public static void main(String[] args) {
    System.out.println(get());
  }
}
