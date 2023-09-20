/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class DeepCopy implements Cloneable {
    String a="Ram";
    int i=10;
    public static void main(String[] args) throws CloneNotSupportedException
    {
     DeepCopy d=new DeepCopy();
     DeepCopy f=d;
     DeepCopy e=(DeepCopy)d.clone();
        System.out.println(e.a);
        System.out.println(d.equals(f));
    }
    
}
