
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class CheckString{
   static boolean def=true;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CheckString cs=new CheckString();
        String first=sc.nextLine();
        String second=sc.nextLine();
        cs.check(first,second);
        }
    void check(String first,String second)
    {
        int t=second.length()-1;
        for(int i=first.length()-1;i>=(first.length()-second.length());i--)
        {
            if(first.charAt(i)!=second.charAt(t))
            {
                def=false;
            }
            t--;
            
        }
        if(def==true)
        {
            System.out.println("TRUE");
    }
        else
        {
            System.out.println("FALSE");
        
        }
    }
}
