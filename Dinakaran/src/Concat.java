
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Concat {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String s1=s.next();
        System.out.println(concatstr(s1));
        
    }
    static String concatstr(String s1)
    {
        String s2=s1;
    return s2+ "programming";
}
}
