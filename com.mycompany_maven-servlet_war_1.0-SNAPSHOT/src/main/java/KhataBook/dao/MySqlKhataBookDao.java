/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package KhataBook.dao;

import idao.KhataBookDao;
import dao.mysql.CustomerDaoImpl;
import dao.mysql.LineItemDaoImpl;
import dao.mysql.OrderDaoImpl;
import dao.mysql.PaymentDaoImpl;
import dao.mysql.ProductDaoImpl;
import idao.OrderDao;

/**
 *
 * @author bas200181
 */
public interface MySqlKhataBookDao extends KhataBookDao {

  public static CustomerDaoImpl getCustomer() {
    return new CustomerDaoImpl();

  }

  public static ProductDaoImpl getProduct() {
    return new ProductDaoImpl();
  }

  public static OrderDao getOrderDaoImpl() {
    return new OrderDaoImpl();
  }

  public static LineItemDaoImpl getliItemDao() {
    return new LineItemDaoImpl();
  }

  public static PaymentDaoImpl getPaymentDao() {
    return new PaymentDaoImpl();
  }
}
