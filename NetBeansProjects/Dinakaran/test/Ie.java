/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public interface Ie {
  default void m1() {
    System.out.println("I m There");
  }
 public  static void m2()
  {System.out.println("Is there");
  }
}

class Demo9 implements Ie {
  public static void show()
  {
    System.out.println("Show");
  }
  public  static void m2()
  {System.out.println("Is there");
  }
  
  public static void main(String[] args) {
   Ie d =  new Demo9();
 
    d.m1();
    
    Ie.m2();
m2();
    show();
    Demo9.show();
    
  }
}
