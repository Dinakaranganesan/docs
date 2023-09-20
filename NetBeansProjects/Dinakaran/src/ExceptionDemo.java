/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println("main() Start");
        a();
        System.out.println("main () End");

    }

    public static void a() {
        System.out.println("a() START");
        b();
        System.out.println("a() End");
    }

    public static void b() {
        System.out.println("b() START");
        c();
        int i=Integer.parseInt("23k");
        System.out.println(i+10);
        System.out.println("b() End");
    }

    public static void c() {
        System.out.println("c() START");
//        b();
        System.out.println("c() End");
    }
}
