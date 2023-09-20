/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

import java.util.Scanner;

/**
 *
 * @author bas200181
 */
public class Vibgyor {

    static Scanner sc = new Scanner(System.in);
    static String a;
    static String b;
    static String c;

    public static void main(String[] args) {
        System.out.println("Enter the Color1");
        a = sc.next();
        System.out.println("Enter the Color2");
        b = sc.next();
        System.out.println("The Combined Color is");
        c = a.concat(b);
        switch (c) {
            case "violetindigo":
            case "indigoviolet": {
                System.out.println("purple");
                break;
            }
            case "violetblue":
            case "blueviolet": {
                System.out.println("bright purple or pink");
                break;
            }
            case "violetgreen":
            case "greenviolet": {
                System.out.println("blue");
                break;
            }

            case "violetyellow":
            case "yellowviolet": {
                System.out.println("pastel purple");
                break;
            }
            case "violetorange":
            case "orangeviolet": {
                System.out.println("brown");
            }

            case "violetred":
            case "redviolet": {
                System.out.println("magenta");
                break;
            }
            case "indigoblue":
            case "blueindigo": {
                System.out.println("Dark purplish Blue");
                break;
            }
            case "indigogreen":
            case "greenindigo": {
                System.out.println("Dark Spring Green");
                break;

            }
            case "indigoyellow":
            case "yellowindigo": {
                System.out.println("Blending Yellow");
            }
            case "indigoorange":
            case "orangeindigo": {
                System.out.println("Purple orange");
                break;
            }
            case "indigored":
            case "redindigo": {
                System.out.println("");
                break;
            }
            case "bluegreen":
            case "greenblue": {
                System.out.println("Turquoise");
                break;
            }
            case "blueyellow":
            case "yellowblue": {
                System.out.println("Green");
                break;
            }
            case "blueorange":
            case "orangeblue": {
                System.out.println("brown");
                break;
            }
            case "bluered":
            case "redblue": {
                System.out.println("Violet");
                break;
            }
            case "greenyellow":
            case "yellowgreen": {
                System.out.println("lime");
                break;
            }
            case "greenorange":
            case "orangegreen": {
                System.out.println("brown");
                break;
            }
            case "greenred":
            case "redgreen": {
                System.out.println("yellow");
                break;
            }
            case "yelloworange":
            case "orangeyellow": {
                System.out.println("amber");
                break;
            }
            case "yellowred":
            case "redyellow": {
                System.out.println("orange");
                break;
            }
        }
    }
}
