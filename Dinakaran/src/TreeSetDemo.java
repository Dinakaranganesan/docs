
import java.util.TreeSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
public class TreeSetDemo {
  public static void main(String[] args) {
    TreeSet ts = new TreeSet();
    Pen one = new Pen("cello", "black", 10);
    Pen two = new Pen("Reynolds", "Red", 15);
    Pen three = new Pen("Trimax", "Blue", 45);
    ts.add(two);
    ts.add(one);
    ts.add(three);
    System.out.println(ts + " ");
  }
}
