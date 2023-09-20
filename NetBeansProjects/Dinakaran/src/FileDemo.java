
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
public class FileDemo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream in = new FileInputStream("/home/bas200181/dina.txt");
        FileOutputStream out=new FileOutputStream("/home/bas200181/dina_bak.txt");
        int i;
        while ((i = in.read()) != -1) {
//            System.out.print((char) i);
                out.write(i);

        }

    }
}
