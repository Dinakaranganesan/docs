/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPS;

/**
 *
 * @author bas200181
 */
public class Point3D extends Point2D {
    float z;
    Point3D(float z)
    {
        super(0.0f,0.0f);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    Point3D()
    {
        this(0.0f);
    }
    Point3D(float x,float y,float z)
    {
      super(x,y);
       this.z=z;
    }
    public void setXYZ(float x,float y,float z)
    {
        super.x=x;
        super.y=y;
        this.z=z;
    }
    public float[] getXYZ(){
        float []b=new float[3];
        b[0]=x;
        b[1]=y;
        b[2]=z;
        return b;
    }
    public void print()
    {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.valueOf(x)+String.valueOf(y)+String.valueOf(z); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    public static void main(String[] args) {
        
        Point3D p=new Point3D(45,23,10);
        System.out.println(p);
         p.print();
         
    }
    
        
        
    
}
