/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bas200181
 */
public class DD{
    public static int identityHashCode(Object d)
  {
      return 1342525;
 }
    public static void main(String[] args) {
      DD d=new DD();
      Demo a=new Demo();
        System.out.println(DD.identityHashCode(d));
        System.out.println(System.identityHashCode(d));
        System.out.println(System.identityHashCode(a));
      
        
    }
    
}
