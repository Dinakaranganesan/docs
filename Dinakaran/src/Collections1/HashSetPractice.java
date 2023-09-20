/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collections;

//import java.util.SortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author bas200181
 */
public class HashSetPractice {

  public static void main(String[] args) {
    HashSet<Integer> hs = new HashSet();
    Integer[] ar = {12, 15, 10, 12, 10};
    TreeSet as = new TreeSet(new Comparator(){
      public int compare(Object o1,Object o2)
      return 1;
    });
//    as.add(10);
//    as.add(20);
//    as.add(30);
//    as.add(20);
//    
    
    ArrayList as2 = new ArrayList();
    Collections.addAll(as, ar);
    System.out.println(as);
    //Collections.addAll(hs,ar);
    // List<Integer> dup = Arrays.asList(ar);
//    System.out.println(dup.get(0));
//    System.out.println(dup);
    System.out.println(as);
    System.out.println(hs);
    System.out.println(hs.size());
    System.out.println(hs.contains(20));
    System.out.println(hs);
    System.out.println(hs.clone());
    Object[] a = hs.toArray();
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
    System.out.println(hs.toString());
    HashSet hs1 = new HashSet();
    hs1.add(25);
    hs1.addAll(hs);
    System.out.println(hs1);
    Iterator i = hs1.iterator();
    while (i.hasNext()) {
      System.out.print(i.next() + " ");
    }
    
  }
}
