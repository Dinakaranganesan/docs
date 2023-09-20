/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author bas200181
 */
public class Test {

  public static void main1(String[] args) {
    String s = "Arunachalam";
    for (int i = 2; i < s.length(); i++) {
      if (i % 3 == 2) {
        System.out.println(s.charAt(i));
      }
    }
    System.out.println("");
    //System.out.println(28%3);
    //System.out.println(s.charAt(28));
//    for (int i=s.length()-4;i>=0;i--) {
//      
//      if((i)%4==1)
//      {
//        System.out.println(s.charAt(i));
//      }
//      
//    }

    for (int i = 0; i < s.length(); i++) {

      if ((i) % 2 == 1) {
        System.out.print(s.charAt(i));
      }

    }

  }

  public static void main(String[] args) {
int i=10;
int j=20;
while(true){
  System.out.println("loop");
}
  }
}
