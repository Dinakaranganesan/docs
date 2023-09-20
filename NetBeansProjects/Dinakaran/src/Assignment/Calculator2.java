package Assignment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
 import java.util.Scanner;
import java.util.*;

public class Calculator2
{ static Scanner s = new Scanner(System.in);
    
   static double simpleCalculator() {
        double a = s.nextInt();
        char op = s.next().charAt(0);
        out:
        while (op != '=') {
            double b = s.nextInt();
            switch (op) {
                case '+':
                    a += b;
                    break;
                case '-':
                    a -= b;
                    break;
                case '*':
                    a *= b;
                    break;
                case '/':
                    a /= b;
                    break;
                default:
                    System.out.println("Syntax Error");
                    a = 0;
                    break out;
            }
            op = s.next().charAt(0);
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(simpleCalculator());
    }
}

