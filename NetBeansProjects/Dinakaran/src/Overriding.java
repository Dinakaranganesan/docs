


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class Overriding {
    String a=getClass().getName();
    int b=999;
    char c='@';
    boolean d=false;
    public String toString()
    {
        return a+c+b;
    }
   public int hashCode()
    {        return b;
  }

    @Override
    public boolean equals(Object obj) {
        return d; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public static void main(String[] args) {
        Overriding o=new Overriding();
        System.out.println(o);
        System.out.println(o.hashCode());
        System.out.println(o.equals(o));
        Overriding n=o;
        System.out.println(o.equals(n));
        
        
    }
    
    
}
