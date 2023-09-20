/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author bas200181
 */
public class StringPractice {

  public static void main(String[] args) {
    String s = "My_Name_is_Dina";
    for (int i = 0; i < s.length(); i=i+3) {
             System.out.print(s.charAt(i) + " ");
      

    }
    System.out.println("");
    for (int i = 1; i < s.length(); i=i+3) {
      
        System.out.print(s.charAt(i) + " ");
      
    }
    System.out.println("");
    for (int i = 2; i < s.length(); i=i+3) {
      
        System.out.print(s.charAt(i) + " ");
      
    }
  }

}
