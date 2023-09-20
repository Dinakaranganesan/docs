/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author bas200181
 */
public class Demo1 {

  public static void main(String[] args) {
    int[] a = {10, 7, 6, 2, 5, 18};
    int temp = 0;
//    for (int i = 0; i < a.length-1; i++) {
//      for (int j = 0; j < a.length-1; j++) {
//        
//      
//      if (a[j]>a[j+1]) {
//        temp = a[j];
//        a[j] = a[j + 1];
//        a[j + 1] = temp;
//        
//      }
//    }
//    }
//    
    for (int i = 1; i < a.length; i++) {
      if (a[i] < a[i - 1]) {
        temp=a[i];
       a[i]=a[i-1];
       a[i-1]=temp;
       i=0;
      }
      
    }
    
    for (int x : a) {
      System.out.println(x);
    }
  }
}
