/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
import java.util.Scanner;
public class  FlipEnd{
    String flipEndChar(String str) {
        String d = "" + str.charAt(str.length() - 1);
        
        if (str.length() != 2) {
            if (str.charAt(0) != str.charAt(str.length() - 1)) {
                for (int i = 1; i < str.length() - 1; i++) {
                    d = d + str.charAt(i);
                }
                d = d + str.charAt(0);
            } else {
                d = "twos pair";
            }
        } else {
            d = "incompitible";
        }
        return d;
    }
    public static void main(String[] args) {
        FlipEnd f = new FlipEnd();
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the string");
        String str = scn.nextLine();
        String st = f.flipEndChar(str);
        System.out.println(st);
    }   
}
