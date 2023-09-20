
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
public class FileIODemo {
    public static void main(String[] args) {
        FileInputStream in = null;
        try {
            
            in = new FileInputStream("/home/bas200181/movies_erd.png");
            int i;

            while ((i = in.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (FileNotFoundException f) {
            System.err.println("File is Not Found");
            f.printStackTrace();
        } catch (IOException io) {
            System.err.println("Error while Reading");
            io.printStackTrace();
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException io1) {
                    System.err.println("Error while Returning");
                    io1.printStackTrace();
                }
            }
        }

    }
        
    }
    
//    public static void main1(String[] args) throws IOException {
//        
//        File file=null;
//        
//        file=new File("/home/bas200181/java/ab.jpg");
//        
//        if(file.createNewFile())
//        {
//            System.out.println("file created...");
//        }else {
//            System.out.println("already exists");
//        }
//        
//        
//        
//    }
    
    
    
    

//    public static void main2(String[] args) {
//        FileInputStream in = null;
//        try {
//            
//            in = new FileInputStream("/home/bas200181/movies_erd.png");
//            int i;
//
//            while ((i = in.read()) != -1) {
//                System.out.println( i);
//            }
//        } catch (FileNotFoundException f) {
//            System.err.println("File is Not Found");
//            f.printStackTrace();
//        } catch (IOException io) {
//            System.err.println("Error while Reading");
//            io.printStackTrace();
//            if (Objects.nonNull(in)) {
//                try {
//                    in.close();
//                } catch (IOException io1) {
//                    System.err.println("Error while Returning");
//                    io1.printStackTrace();
//                }
//            }
//        }
//
//    }
//}
