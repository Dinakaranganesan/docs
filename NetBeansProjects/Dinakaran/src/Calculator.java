
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Calculator ca=new Calculator();
        int a=s.nextInt();
        char ch=s.next().charAt(0);
        int b=s.nextInt();
        ca.calc(a,ch,b);
        
    }
    void calc(int a,char ch,int b)
    {
        if(ch=='+')
        {
            System.out.println(a+b);
        }
        if(ch=='-')
        {
            System.out.println(a-b);
           }
        if(ch=='*')
        {
            System.out.println(a*b);
        }
        if(ch=='/')
        {
            System.out.println(a/b);
        }
    }
        
    
}
