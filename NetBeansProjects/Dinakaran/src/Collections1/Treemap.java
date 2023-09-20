package Collections1;

import java.util.TreeMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
public class Treemap {
  public static void main(String[] args) {
    TreeMap tm = new TreeMap();
    tm.put(1, "Kannan");
    tm.put(2, "Pratheeban");
    tm.put(3, "Anand");
    System.out.println(tm);
    tm.replace(3, "Jobin");
    System.out.println(tm);
    tm.replace(3, "Jobin", "Bawa");
    System.out.println(tm);
    System.out.println(tm.floorEntry(2));
  //  tm.
  }
}
