/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPS;

/**
 *
 * @author bas200181
 */
public class Rectangle {
    double length;
    double breadth;
    Rectangle(double length,double breadth) 
    {
        this.length=length;
        this.breadth=breadth;
    }
    double areaOfRectangle()
    {
        return length*breadth;
    }
    double periOfRectangle()
    {
        return 2*(length+breadth);
    
}
       
}
