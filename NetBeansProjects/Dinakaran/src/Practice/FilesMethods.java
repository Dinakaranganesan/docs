/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author bas200181
 */
public class FilesMethods {
  public static void main(String[] args) throws IOException {
    File f = new File("/home/bas200181/RRRR.txt");
    File d=new File("/home/bas200181/Documents/mysql");
    f.createNewFile();
    System.out.println(f.length());
    System.out.println(f.equals(f));
    System.out.println(f.getAbsoluteFile());
    System.out.println("\tdhjsjkh");
    System.out.println(f.canExecute());
    System.out.println(f.canRead());
    System.out.println(f.canWrite());
     System.out.println(f.compareTo(d));
    System.out.println(f.toURI());
    System.out.println(f.toURL());
    System.out.println(f.getAbsolutePath());
    System.out.println(f.getCanonicalFile());
    System.out.println(f.getCanonicalPath());
   System.out.println(f.getName());
   

  }

}
