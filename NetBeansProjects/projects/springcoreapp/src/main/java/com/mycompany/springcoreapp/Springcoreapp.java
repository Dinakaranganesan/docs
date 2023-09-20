/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.springcoreapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author bas200181
 */
public class Springcoreapp {

    public static void main1(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Pen a = new Pen();
        System.out.println(a);
//        Pen b=con.getBean("aa",Pen.class);
//        System.out.println(b);
//    
//     Pen c=con.getBean("aa",Pen.class);
//     c.setPrice(15.0);
//        System.out.println(c);

        System.out.println(context.getBean("aa", Pen.class));
        System.out.println(context.getBean("aa", Pen.class));
        System.out.println(context.getBean("aa", Pen.class));
        System.out.println(context.getBean("aa", Pen.class));
        System.out.println(context.getBean("aa", Pen.class));
    }

    public static void main2(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("data.xml");
        DataSource ds = ac.getBean("myDataSource", DataSource.class);
        try (PreparedStatement ps = ds.getConnection().prepareStatement("select * from Customer");) {
            ResultSet rs = ps.executeQuery();
            System.out.println("ID" + " " + "CUSTOMER NAME");
            while (rs.next()) {
                System.out.println("" + rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Springcoreapp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Locale l = Locale.getDefault();
        System.out.println(l.getDisplayCountry());
        System.out.println(l.getDisplayName());
        System.out.println(l.getDisplayScript());
        System.out.println(l.getDisplayLanguage());
        System.out.println(l.getDisplayVariant());
        System.out.println(l.getISO3Country());
    }
}
