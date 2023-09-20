/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
import java.util.Scanner;
public class SwapString {
    String nameSwap(String a){
        int count=0;
        String str=" ";
        String str1=" ";
        for (int i = 0; i < a.length(); i++) {
            count++;
            if(a.charAt(i)==' '){
              break;
            }}
           for (int i = 0; i < a.length(); i++) {
            if(i<count){
             str=str+a.charAt(i);
            }
            else if(i>=count){
            str1=str1+a.charAt(i);
            }
        }
       return str1+str;
    }
    public static void main(String[] args) {
        SwapString s=new SwapString();
        Scanner scn=new Scanner(System.in);
        System.out.println("enter the string");
        String str=scn.nextLine();
        String t=s.nameSwap(str);
         System.out.println(t);
    }
}
