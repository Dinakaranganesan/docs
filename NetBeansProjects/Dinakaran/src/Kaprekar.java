/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
import java.util.Scanner;

public class Kaprekar {

    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int count = 0;
        for (int i = a; i > 0; i = i / 10) {
            count++;
        }
        if (count < 4) {
            for (int i = count; i < 4; i++) {
                a = a * 10;
            }
        }
        if (count > 4) {
            System.out.println("Enter a valid number");
        }
        System.out.println(a);
        int[] array1 = new int[4];
        for (int i = 0; i < 4; i++) {
            array1[i] = a % 10;
            a = a / 10;

        }
        for (int i = 0; i < 4; i++) {
            System.out.println(array1[i]);
        }

        for (int i = 0; i < array1.length - 1; i++) {

            if (array1[i] < array1[i + 1]) {
                int temp = array1[i];
                array1[i] = array1[i + 1];
                array1[i + 1] = temp;
            }
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        int[] array2 = array1;

        for (int i = array2.length - 1; i <= 0; i++) {

            for (int j = 0; j < array2.length; j++) {
                System.out.print(array2[j] + " ");
            }

        }

    }
}
