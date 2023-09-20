/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.sql.Connection;

/**
 *
 * @author bas200181
 */
public interface PaymentDao {
  public int pay(Connection connection);
  
}
