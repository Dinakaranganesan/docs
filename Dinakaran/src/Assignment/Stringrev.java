/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author bas200181
 */
public class Stringrev {
   
   static String rev="";

    String reverse(String inputString) {
        
        for(int i=inputString.length()-1;i>=0;i--)
            {
                rev=rev+inputString.charAt(i);
}
        return rev;
    
        }
    public static void main(String[] args) {
        Stringrev s=new Stringrev();
        System.out.println(s.reverse("cool"));
        
    }
  
}
    

