/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Clone implements Cloneable{
    int c=10;
    String d="Bala";
    
    public static void main(String[] args) throws CloneNotSupportedException {
        Clone c = new Clone();
        Clone c1 = (Clone) c.clone();
    }
}
