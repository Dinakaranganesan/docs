/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author bas200181
 */
public class Demo {

  public static void main(String[] args) {
    int temp = 0, sum=0;
    int[] a = {22, 47, 13, 15, 78};
    for (int i = 0; i < a.length; i++) {
      temp = a[i];
      while (temp != 0) {
       

        sum += temp % 10;

        temp = temp / 10;
      }
      a[i] = sum;
       sum = 0;
    }
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
   
    
  }
  
  
  
}
