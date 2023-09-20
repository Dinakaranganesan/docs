/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maven.servlet;

import static dao.mysql.CustomerDaoImpl.getMys;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author bas200181
 */
public class demo {
    public static void main(String[] args) {

        String addCust = "insert into Dummy values(?)";
        int ret = 0;
        try (Connection con = getMys().createConnection(); PreparedStatement ps_a = con.prepareStatement(addCust);) {

            ps_a.setString(1, "9");

            ret = ps_a.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
