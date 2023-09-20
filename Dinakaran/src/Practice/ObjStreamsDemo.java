/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

//import static ExceptionDemo.c;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author bas200181
 */
public class ObjStreamsDemo {

  public static void main1(String[] args) {
    Car c = new Car("BMW", 90000000, "Blue", new Engine("Honda", "Petrol", 90000));
    try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/home/bas200181/Documents/WriteObject1.txt"))) {
      System.out.println("file write");
      out.writeObject(c);
      System.out.println("write successfully");
    } catch (IOException io) {
      io.printStackTrace();
    }
  }

  public static void main(String[] args) {
    try (
             ObjectInputStream in = new ObjectInputStream(new FileInputStream("/home/bas200181/Documents/WriteObject1.txt"))) {

      if (in.readObject() instanceof Car c) {
        System.out.println(c);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
  }
}
