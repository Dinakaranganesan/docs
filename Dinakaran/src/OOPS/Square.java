/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPS;

/**
 *
 * @author bas200181
 */
public class Square extends Rectangle{
    public static void main(String[] args) {
        Rectangle r=new Rectangle(8,8);
        System.out.println(r.areaOfRectangle());
        System.out.println(r.periOfRectangle());
        Square s=new Square(4);
        System.out.println(s.areaOfRectangle());
        System.out.println(s.periOfRectangle());
    }

    public Square(double side) {
        super(side, side);
    }
    
}
