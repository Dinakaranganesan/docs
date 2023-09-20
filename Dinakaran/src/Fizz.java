
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Fizz {
    public static void main(String[] args) {
        Fizz f=new Fizz();
        Scanner sc=new Scanner(System.in);
        int no=sc.nextInt();
        System.out.println(f.fizzBuzz(no));
    }
    String fizzBuzz(int no)
    {
        if(no%15==0)
        {
            return "FizzBuzz";
        }
        if(no%3==0)
        {
            return "Fizz";
        }
        if(no%5==0)
        {
            return "Buzz";
        }
        else{
            return String.valueOf(no);
    
                    }
}
}