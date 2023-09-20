/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.khatabook.idao;

import java.sql.Connection;
import java.util.ArrayList;
import com.khatabook.model.AddCart;
import com.khatabook.model.LineItems;
import com.khatabook.model.Orders;
import com.khatabook.model.ShowOrders;
import java.sql.Date;

/**
 *
 * @author bas200181
 */
public interface OrderDao {
  public boolean addOrder(Orders o,LineItems []l);
  public void show();
   public boolean addCartItems(AddCart o, LineItems l[]);
   public ArrayList addCart(int orderId);
   public int updatePendingStatus(int orderId);
     public ShowOrders viewCustomerOrder(int customerId);
     public ShowOrders viewCustomerOrdersByDate(Date date);
  
}
