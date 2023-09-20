package OOPS;

import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Point2D {
    float x;
    float y;
    public Point2D()
    {
        this(0.0f,0.0f);
    }
    public Point2D(float x,float y)
    {
        this.x=x;
        this.y=y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y)
    {
        this.x=x;
        this.y=y;
    }    
    public float[] getXY(){
      float[] a=new float[2];
      a[0]=x;
      a[1]=y;
      return a;
    }

    @Override
    public String toString() {
        return String.valueOf(x)+String.valueOf(y); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
   
    
}
    
