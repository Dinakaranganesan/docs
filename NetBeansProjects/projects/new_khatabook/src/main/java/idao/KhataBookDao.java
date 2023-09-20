/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

/**
 *
 * @author bas200181
 */
public interface KhataBookDao {

  public CustomerDao getCustomerDaoObj();

  public ProductDao getProductDaoObj();

  public OrderDao getOrderDaoObj();

  public LineItemDao getLineItemDao();

  public PaymentDao getPaymentDaoObj();

}
