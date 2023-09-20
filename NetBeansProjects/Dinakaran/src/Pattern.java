/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Pattern {
  public static void main(String[] args) {
    for (int i = 0; i <7; i++) {
      for (int j = 0; j < 7; j++) {
        if(j==0||i==3&&j<=3||i==6&&j<=3||j==3&&i>=3)
          System.out.print("* ");
        else
          System.out.print("  ");
        
      }
      System.out.println();
    }
    System.out.println();
    for (int i = 0; i <7; i++) {
      for (int j = 0; j < 7; j++) {
        if(j==0||i==6||i==3||j==6&&i>=3||i==0&&j<=5||j==5&&i<=3)
          System.out.print("* ");
        else
          System.out.print("  ");
        
      }
      System.out.println();
    }
    System.out.println("");
    for (int i = 0; i <7; i++) {
      for (int j = 0; j < 7; j++) {
        if(i+j==6||i==2&&j==0||i==4&&j==6)
          
          System.out.print("*");
        else
          System.out.print(" ");
        
      }
      System.out.println();
    }
  }
  
}
