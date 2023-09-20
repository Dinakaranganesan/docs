/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collection;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author bas200181
 */
public class Collection {
  public static void main(String[] args) {
    ArrayList al = new ArrayList();
    al.add( 1);
    al.add( 2);
    al.add( 5);
    Object []a=al.toArray();
    int []b=new int[a.length];
   for(int i=0;i<a.length;i++)
   {
   //  System.out.print(a[i]+" ");
      b[i] =Integer.parseInt(a[i].toString());
     System.out.println(" ");
     System.out.println(b[i]);
   }
    System.out.println("");
    
    ArrayList<Integer> al1 = new ArrayList();
    al1.add(25);
    al1.add(11);
    al1.add(10);
    Iterator i = al1.iterator();
    System.out.println("sksjklsjp");
  //  System.out.println(i.next());
   // System.out.println("Checking");
//    while (i.hasNext()) {
//      System.out.println(i.next());
//    }
//    //System.out.println(i.next());
    //add old collection TO NEW ARRAYLIST
    al1.addAll(1, al);
    System.out.println(al);
    System.out.println(al1);
    //Clear all the elements
    al1.clear();
    System.out.println(al1);
    al1.add(15);
    al1.remove(0);
    System.out.println(al1.isEmpty());
  }
}
