/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class ClonePractice implements Cloneable {

    int a = 7;
    String b = "Asif";

    public static void main(String[] args) throws CloneNotSupportedException {
        ClonePractice clp = new ClonePractice();
//        ClonePractice clv=clp;
        ClonePractice clv = (ClonePractice) clp.clone();
        // System.out.println(clv.equals(clp));

        System.out.println(clp.a);
        System.out.println(clp.b);
        clv.a = 8;
        clv.b = "bala";
        System.out.println(clv.a);
        System.out.println(clv.b);
        System.out.println(clp.a);
        System.out.println(clp.b);

        Book b = new Book();
//        Book b1 = (Book) b.clone();
    }

}
