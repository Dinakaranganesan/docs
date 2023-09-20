
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Revname {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        System.out.println(change(s1));
    }
    static String change(String s)
    {
        String s2="";
        String s3="";
       int count=0;
       for(int i=0;i<s.length();i++)
       {
           count++;
        if(s.charAt(i)==' ')
          break;
      
       }
       for(int i=0;i<s.length();i++)
       {
       if(i<count)
       {
           s2=s2+s.charAt(i);
       }
       else{
           s3=s3+s.charAt(i);
       }
       }
       return s3+" "+s2;
    }   
}
   
