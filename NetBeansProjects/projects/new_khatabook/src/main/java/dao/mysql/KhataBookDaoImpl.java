/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import idao.CustomerDao;
import idao.KhataBookDao;
import idao.LineItemDao;
import idao.OrderDao;
import idao.PaymentDao;
import idao.ProductDao;

/**
 *
 * @author bas200181
 */
public class KhataBookDaoImpl implements KhataBookDao {

  @Override
  public CustomerDao getCustomerDaoObj() {
    return new CustomerDaoImpl();
  }

  @Override
  public ProductDao getProductDaoObj() {
    return new ProductDaoImpl();
  }

  @Override
  public OrderDao getOrderDaoObj() {
    return new OrderDaoImpl();
  }

  @Override
  public LineItemDao getLineItemDao() {
    return new LineItemDaoImpl();
  }

  @Override
  public PaymentDao getPaymentDaoObj() {
    return new PaymentDaoImpl();
  }
}
