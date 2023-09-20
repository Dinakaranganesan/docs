/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coding;

import java.awt.Taskbar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 *
 * @author bas200181
 */
public class Practice {

  public static void main(String[] args) {
    Integer a=10;
    int i=a;
    System.out.println(i);
  }

  public static void main2(String[] args) {
    String name = "dinakaran07";
    if (name.length() % 2 != 0) {
      int mid = name.length() / 2;
      for (int i = 0; i < mid; i++) {
        System.out.print(name.charAt(i));
      }
      System.out.println("");
      System.out.print(name.charAt(mid));
      System.out.println("");
      for (int i = mid + 1; i < name.length(); i++) {
        System.out.print(name.charAt(i));
      }
    }

  }

  public static void main1(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//  String a="Asdfghjk1234567@#$%^&*";
//  int count=0;
//  for(int i=0;i<a.length();i++)
//  {
//    if(a.charAt(i)>=97 &&a.charAt(i)<123 || a.charAt(i)>=65 && a.charAt(i)<91)
//    {
//      System.out.print(a.charAt(i));
//      count++;
//    }
//      } 
// System.out.println(count);
//  }
    System.out.println("Enter the number");
    int mul = Integer.parseInt(br.readLine());
    for (int i = 1; i <= 10; i++) {
      int sum = 0;
      int j = i;
      while (j > 0) {
        sum += mul;
        j--;
      }
      System.out.println(sum);

    }
//int num=Integer.parseInt(br.readLine());
////for(int i=1;i<10;i++)
////{
//  
//for(int i=0;i<=10;i++) {
//  System.out.println(num);
// num=num+num;
  }

  // }
}
