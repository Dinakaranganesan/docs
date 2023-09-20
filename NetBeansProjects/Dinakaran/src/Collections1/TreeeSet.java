/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Collections;

import java.util.TreeSet;

/**
 *
 * @author bas200181
 */
public class TreeeSet {
  static TreeSet ts = new TreeSet();
  public static void main(String[] args) {
    try {
//      TreeSet ts = new TreeSet();
      ts.add(89);
      ts.add(100);
      ts.add(199);
      ts.add(66);
      ts.add(79);
      ts.add(109);
      ts.add(4);
      TreeSet ts1 = new TreeSet();
      ts1.add(200);
      System.out.println(ts);
      System.out.println(ts.ceiling(60));
      // System.out.println(ts.descendingSet());
      System.out.println(ts.comparator());
      System.out.println(ts.first());
      System.out.println(ts.floor(80));
      System.out.println("#".repeat(Integer.parseInt(ts.floor(80).toString())));
      //System.out.println(ts.headSet(ts));    
      System.out.println(ts.higher(ts1));
    } catch (ClassCastException cce) {
      System.out.println(cce);
    }
    finally{
       System.out.println(ts.isEmpty());
       System.out.print("""                                   
                        """);
    }
  }
}
