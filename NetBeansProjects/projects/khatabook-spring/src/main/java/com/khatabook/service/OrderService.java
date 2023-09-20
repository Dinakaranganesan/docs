/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.service;

import com.khatabook.idao.KhataBookDao;
import com.khatabook.model.Customer;
import com.khatabook.model.Inventory;
import com.khatabook.model.LineItems;
import com.khatabook.model.Orders;
import com.khatabook.model.ShowOrders;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bas200181
 */
@Service
public class OrderService {

    @Autowired
    KhataBookDao kb;

    public ShowOrders orderDetail(int custId) {
        return kb.getOrderDaoObj().viewCustomerOrder(custId);
    }

    public int addOrder(String phone, int orderid, String[] proid, String[] quantity1) {
        boolean d = false;
        int b = 0;
        Orders or = new Orders();
        LineItems[] lim = new LineItems[proid.length];
        //String phone_no = phone;
        Customer cus = kb.getCustomerDaoObj().getCusdetails(phone);
        if (Objects.nonNull(cus)) {
            int order_id = orderid;
            
            Date l = Date.valueOf(LocalDate.now());
            or.setCusId(cus.getCusId());
            or.setOrderID(order_id);
            double sum = 0;
            boolean add = true;

            for (int j = 0; j < proid.length; j++) {

                int productId = Integer.parseInt(proid[j]);
                Inventory inv1 = kb.getProductDaoObj().getProductDetails(productId);
                int quantity = Integer.parseInt(quantity1[j]);
                double buyPrice = quantity * inv1.getPrice();
                sum += buyPrice;
                lim[j] = new LineItems(order_id, productId, inv1.getProName(), quantity, buyPrice);
                int a1 = inv1.getQuantity() - quantity;
                Inventory inv2 = new Inventory();
                inv2.setProductId(productId);
                inv2.setQuantity(a1);
                kb.getProductDaoObj().stockUpdate(inv2);
                // pw.print(lim[j].toString());
            }

            or.setTotalprice(sum);

            double c_balance = sum + cus.getCusBal();
            System.out.println(c_balance);
            Customer cus1 = new Customer();
            cus1.setCusId(cus.getCusId());
            cus1.setCusBal(c_balance);
//                        pw.print(cus1);
//                        pw.print(or);
            b = kb.getCustomerDaoObj().updateCustomerBalance(cus1);
            d = kb.getOrderDaoObj().addOrder(or, lim);

        } else {
            System.out.println("Invalid Mobile Number");
        }
        if (d && b > 0) {
            return 1;
        } else {
            return 0;

        }
    
    }
    

}
