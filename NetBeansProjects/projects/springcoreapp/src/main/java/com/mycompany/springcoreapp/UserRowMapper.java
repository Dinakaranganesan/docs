/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.springcoreapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author bas200181
 */
public class UserRowMapper  implements RowMapper<Customerr>{

    @Override
    public Customerr mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customerr(rs.getInt(1), rs.getString(2), rs.getString(3) ,rs.getString(4), rs.getString(5), rs.getDouble(6));
    }
    
}
