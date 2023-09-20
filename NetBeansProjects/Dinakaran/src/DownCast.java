/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class DownCast {
    int a=7;
}
class B extends DownCast
{
    int b=19;
    public static void main(String[] args) {
        DownCast d=new B();
        System.out.println(d.a);
        B b=(B)d;
        System.out.println(b.b);
    }
}

