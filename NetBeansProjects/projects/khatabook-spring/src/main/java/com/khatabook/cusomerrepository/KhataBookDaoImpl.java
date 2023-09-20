/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.cusomerrepository;

import com.khatabook.idao.CustomerDao;
import com.khatabook.idao.KhataBookDao;
import com.khatabook.idao.LineItemDao;
import com.khatabook.idao.OrderDao;
import com.khatabook.idao.PaymentDao;
import com.khatabook.idao.ProductDao;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bas200181
 */
@Repository
public class KhataBookDaoImpl implements KhataBookDao {
    
    @Autowired
    private  static DataSource ds;
    
    public KhataBookDaoImpl(DataSource ds){
        this.ds=ds;
    }

    public static DataSource getDs() {
        return ds;
    }

//    public KhataBookDaoImpl() {
//    }

  @Override
  public CustomerDao getCustomerDaoObj() {
    return new CustomerDaoImpl();
  }

//    public static DataSource getDs() {
//        return ds;
//    }

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
