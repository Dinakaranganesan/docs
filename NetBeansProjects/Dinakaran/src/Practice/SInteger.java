/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author bas200181
 */
public class SInteger {

  public static void main1(String[] args) {
    int[] a = {123, 456, 789, 100, 101};
    String b = "Singam Suriy@07~";
    String c = "[a-bA-Z0-9~]";
    int count = 0;
//    for (int i = 0; i < b.length; i++) {
//      System.out.println(b[i].charAt(1));
//      
////    }
//    for (int i = 0; i < a.length; i++) {
//      int t = a[i];
//      while (t != 0) {
//        count++;
//        t = t / 10;
//
//      }
//      
//  
//      }
    for (int i = 0; i < b.length(); i++) {
      if ((b.charAt(i) + "").matches(c)) {
        System.out.print(b.charAt(i));
      }

    }
  }

  public static void main2(String[] args) {
    int[] a = {1676, 891, 562, 763};
    int sum = 0;
    int sep = 0;
    for (int i = 0; i < a.length; i++) {
      int temp = a[i];
      int max = 0;
      while (temp != 0) {
        sep = temp % 10;
        temp /= 10;

        if (sep > max) {
          max = sep;
        }

      }
      System.out.println(+i + "index:" + max);
    }
  }
  public static void main3(String[] args) {
    int []a={8,4,2,1,10,13,19,45,6,7,9};
    int temp=0;
  
    for (int i = 1; i <a.length; i++) {
      if(a[i-1]>a[i])
      {
        temp=a[i-1];
        a[i-1]=a[i];
        a[i]=temp;
        i=0;
      }
    }
        for(int x:a)
        {
          System.out.println(x);
      
    }
  }
}

