/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

import java.util.Random;

/**
 *
 * @author bas200181
 */
public class RandomNumberGenerate {
  public static void main(String[] args) {
    Random random=new Random();
    while(true)
    {
      int no=random.nextInt(10);
      System.out.println(no);
    }
  }
  
}
