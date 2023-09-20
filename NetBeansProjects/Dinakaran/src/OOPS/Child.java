/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPS;

/**
 *
 * @author bas200181
 */
public class Child extends Parent {
    public void child()
    {
        System.out.println("This is Child");
    }
    public static void main(String[] args) {
        Child c=new Child();
        Parent p=new Parent();
        p.parent();
        c.parent();
        c.child();
    }
}
