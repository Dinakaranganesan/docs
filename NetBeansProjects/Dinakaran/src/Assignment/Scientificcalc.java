package Assignment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Assignment.Calculator2;
/**
 *
 * @author bas200181
 */import static java.lang.Math.E;
public class Scientificcalc extends Calculator2 {
   void scientficCal() {
        System.out.println("Enter the 1st number");
        int a = s.nextInt();
        System.out.println("Enter the 2nd number");
        int b = s.nextInt();
        System.out.println("operation");
        String c = s.next();
        switch (c) {
            case "max":
                System.out.println(Math.max(a, b));
                break;
            case "pow":
                System.out.println(Math.pow(a,b));
                break;
            case "log":
                  System.out.println(Math.log(a));
                  break;
            case " log10":
                System.out.println(Math.log10(a));
                break;
            case "log1p ":
                System.out.println(Math.log1p(a));
                break;
            case "exp":
                System.out.println(Math.exp(a));
                break;
            case "expm1 ":
                    System.out.println(Math.expm1(a));
                    break;
            case "sin ":
                    System.out.println(Math.sin(a));
                    break;
            case "tan ":
                    System.out.println(Math.tan(a));
                    break;
            case "cos ":
                    System.out.println(Math.cos(a));
                    break;
            case "asin":
                    System.out.println(Math.asin(a));
                    break;
            case "acos":
                    System.out.println(Math.acos(a));
                    break;
            case "atan":
                    System.out.println(Math.atan(a));
                    break;                    
            case "sinh":
                    System.out.println(Math.sinh(a));
                    break;
            case "tanh":
                    System.out.println(Math.tanh(a));
                    break;
            case "cosh":
                    System.out.println(Math.cosh(a));
                    break;             
        }    
    }}