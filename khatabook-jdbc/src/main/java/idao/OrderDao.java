/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.sql.Connection;
import model.LineItemss;
import model.Orderrs;

/**
 *
 * @author bas200181
 */
public interface OrderDao {
  public int  addOrder(Orderrs o,LineItemss []l);
  public void show();
  
}
