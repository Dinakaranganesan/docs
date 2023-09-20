
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
public class Check {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        String alp = s.nextLine();
        int count = 0;
        for (int i = 0; i < alp.length(); i++) {
            if (alp.charAt(i) >= 65 && alp.charAt(i) <= 90) {
                count++;
            }
        }
    
        System.out.println(count);}

}
