/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

import java.io.File;

/**
 *
 * @author bas200181
 */
public class Netpac {

  public static void main(String[] args) {
    File f = new File("/home/bas200181/Documents/EmptyFolder/temp.txt");
    File r = new File("/home/bas200181/Documents/EmptyFolder/Rename.txt");
    boolean flag = f.renameTo(r);
    if (flag == true) {
      System.out.println("File Renamed Succesfully");
    }

//    File[] fe=f.listFiles();
//    for (File fc : fe) {
//      System.out.println(fc);
//      
//    }
//    
    File fnew = new File("/home/bas200181/cat.jpg");
    if (fnew.setExecutable(true)) {
      System.out.println("Executable File");

    }
  }
}
