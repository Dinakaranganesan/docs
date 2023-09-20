
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
public class PP {

  public static void main(String[] args) {
   
   
  int j=0;
    ArrayList l = new ArrayList();
    l.add(15);
    l.add(34);
    l.add(16);
    int a = 0;
    
   // ArrayList al1=get(l);
   ArrayList al2=new ArrayList();
   al2.addAll(get(l));
    System.out.println(al2);
  }

  public static ArrayList get(ArrayList l) {
    int j=0;
   ArrayList al=new ArrayList();
    for (int i = 0; i < l.size(); i++) {
      if (Integer.parseInt(l.get(i).toString()) % 2 == 0) // if((Integer.parseInt((String)l.get(i)))%2==0) {
      {
        al.add( l.get(i));
       //j++;
         
      }

    }
    return al;
  }
}