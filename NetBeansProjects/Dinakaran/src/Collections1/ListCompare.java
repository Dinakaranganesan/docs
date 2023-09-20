package Collections1;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class ListCompare {

  public static void main(String[] args) {

    LinkedList ts = new LinkedList();
    ts.add(55);
    ts.add(55);
    ts.add(67);
    ts.add(89);
    ts.add(12);
    LinkedList ss=new LinkedList();
    ss.add(67);
    ss.add(89);
  //  ts.remove(ss);
    System.out.println(ts);
    System.out.println(ss);
    
    ArrayDeque ad=new ArrayDeque();
    ad.add(15);
    ad.add(90);
    ad.add(78);
    ad.add(90);
    ad.add(45);
    ad.add(55);
    System.out.println(ad);
    //ad.removeLastOccurrence(90);
    ad.removeFirstOccurrence(90);
    System.out.println(ad);
    System.out.println( ad.poll());
    System.out.println(ad);
   // System.out.println(ad);
  //ad.poll();

  }

}
