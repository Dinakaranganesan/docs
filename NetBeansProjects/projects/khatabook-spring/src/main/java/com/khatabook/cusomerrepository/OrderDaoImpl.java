/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.cusomerrepository;

import com.khatabook.idao.OrderDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.khatabook.model.AddCart;
import com.khatabook.model.LineItems;
import com.khatabook.model.Orders;
import com.khatabook.model.ShowOrders;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author bas200181
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean addOrder(Orders o, LineItems l[]) {
        int order = 0, line = 0;
        try (PreparedStatement ps = KhataBookDaoImpl.getDs().getConnection().prepareStatement("insert into Orders values(?,?,default,?)"); PreparedStatement ps1 = MySqlConnection.createConnection().prepareStatement("insert into line_item values(?,?,?,?,?)");) {
            ps.setInt(1, o.getOrderID());
            ps.setInt(2, o.getCusId());
            ps.setDouble(3, o.getTotalprice());
            order = ps.executeUpdate();
            for (int i = 0; i < l.length; i++) {
                ps1.setInt(1, l[i].getOrderId());
                ps1.setInt(2, l[i].getProductId());
                ps1.setString(3, l[i].getProName());
                ps1.setInt(4, l[i].getQuantity());
                ps1.setDouble(5, l[i].getPrice());
                line = ps1.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (order > 0 && line > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static double getPrice(Connection con, int product_id) {
        double pri = 0;
        try (PreparedStatement ps2 = con.prepareStatement("select price from product where product_id=?");) {
            ps2.setDouble(1, product_id);
            ResultSet rs1 = ps2.executeQuery();
            System.out.println("query execute");
            while (rs1.next()) {
                pri = rs1.getDouble(1);
            }
            System.out.println(pri);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pri;
    }

    public static int getStack(Connection con, int pro_id) {
        int stack = 0;
        try (PreparedStatement ps2 = con.prepareStatement("select quantity from product where product_id=?");) {
            ps2.setInt(1, pro_id);
            ResultSet rs1 = ps2.executeQuery();
            System.out.println("query execute");
            while (rs1.next()) {
                stack = rs1.getInt(1);
            }
            System.out.println(stack);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return stack;
    }

    public void show() {
        //  boolean sel_a = true;
        try {
            PreparedStatement ps_j = MySqlConnection.createConnection().prepareStatement("select Customer.customer_id,Customer.customer_name,Customer.customer_phoneno,Customer.customer_aadhar,Customer.cus_address,Orders.total_amount ,Orders.order_id,Orders.OrderedDate from Customer,Orders where Customer.customer_id=Orders.customer_id");
            System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(25) + "+");
            System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%10s|%-10s|%25s|", "Id", "customer name", "phonenumber", "Aadhar Number", "Address", "or_amount", "order_id", "OrderedDate");
            System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(25) + "+");
            ResultSet rs = ps_j.executeQuery();
            while (rs.next()) {
                System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%10s|%-10s|%25s|", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8));
                System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(10) + "+" + "-".repeat(10) + "+" + "-".repeat(25) + "+");

                // System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|%-4d|%-15s" |, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public boolean addCartItems(AddCart o, LineItems l[]) {
        int order = 0, line = 0;
        try (PreparedStatement ps = MySqlConnection.createConnection().prepareStatement("insert into addcart_orders values(?,?,default,?,?)"); PreparedStatement ps1 = MySqlConnection.createConnection().prepareStatement("insert into addcart_lineitems values(?,?,?,?,?)");) {
            ps.setInt(1, o.getOrderId());
            ps.setInt(2, o.getCustomerId());
            ps.setDouble(3, o.getPrice());
            ps.setString(4, "pending");
            order = ps.executeUpdate();
            for (int i = 0; i < l.length; i++) {
                ps1.setInt(1, l[i].getOrderId());
                ps1.setInt(2, l[i].getProductId());
                ps1.setString(3, l[i].getProName());
                ps1.setInt(4, l[i].getQuantity());
                ps1.setDouble(5, l[i].getPrice());
                line = ps1.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (order > 0 && line > 0) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList addCart(int orderId) {
        ArrayList alCart = new ArrayList();
        ArrayList<LineItems> alCartLineItem = new ArrayList<>();
        try (PreparedStatement ps = MySqlConnection.createConnection().prepareStatement("select * from addcart_orders where order_id=? and order_status=?"); PreparedStatement ps1 = MySqlConnection.createConnection().prepareStatement("select * from addcart_lineitems where order_id=?");) {
            ps.setInt(1, orderId);
            ps.setString(2, "pending");
            ResultSet rs = ps.executeQuery();
            ps1.setInt(1, orderId);
            ResultSet rs1 = ps1.executeQuery();
            rs.next();
            alCart.add(new AddCart(rs.getInt(2), rs.getInt(1), rs.getDate(3), rs.getDouble(4), rs.getString(5)));
            while (rs1.next()) {
                alCartLineItem.add(new LineItems(rs1.getInt(1), rs1.getInt(2), rs1.getString(3), rs1.getInt(4), rs1.getDouble(5)));

            }
            alCart.add(alCartLineItem);
        } catch (SQLException ex) {

        }
        return alCart;

    }

    @Override
    public int updatePendingStatus(int orderId) {
        int updateStatus = 0;
        try (PreparedStatement ps = MySqlConnection.createConnection().prepareStatement("update  addcart_orders set order_status=? where order_id=?");) {
            ps.setString(1, "confirmed");
            ps.setInt(2, orderId);
            updateStatus = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return updateStatus;
    }

    @Override
    public ShowOrders viewCustomerOrder(int customerId) {
        ShowOrders so = new ShowOrders();
        ResultSet r;
        List<Orders> ordersList = new ArrayList();
        List<LineItems> lineitemsList = new ArrayList();
        String viewOrder = "select * from Orders where customer_id=?";
        String viewLineItems = "select * from  line_item  where order_id=?";
        try (Connection connection = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ordersStatement = connection.prepareCall(viewOrder); PreparedStatement lineitemsStatements = connection.prepareCall(viewLineItems);) {
            ordersStatement.setInt(1, customerId);
            r = ordersStatement.executeQuery();
            while (r.next()) {
                Orders order = new Orders(r.getInt(1), r.getInt(2), Date.valueOf(r.getString(3)), r.getDouble(4));
                ordersList.add(order);
            }
            for (Orders orders : ordersList) {
                lineitemsStatements.setInt(1, orders.getOrderID());
                r = lineitemsStatements.executeQuery();
                while (r.next()) {

                    lineitemsList.add(new LineItems(r.getInt(1), r.getInt(2), r.getString(3), r.getInt(4), r.getDouble(5)));

                }
            }
            so.setLine(lineitemsList);
            so.setOrder(ordersList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return so;
    }
      @Override
    public ShowOrders viewCustomerOrdersByDate(Date date) {
        ShowOrders so = new ShowOrders();
        ResultSet r;
        List<Orders> ordersList = new ArrayList();
        List<LineItems> lineitemsList = new ArrayList();
        String viewOrder = "select * from Orders where OrderedDate=?";
        String viewLineItems = "select * from  line_item  where order_id=?";
        try (Connection connection = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ordersStatement = connection.prepareCall(viewOrder); PreparedStatement lineitemsStatements = connection.prepareCall(viewLineItems);) {
            ordersStatement.setDate(1, date);
            r = ordersStatement.executeQuery();
            while (r.next()) {
                Orders order = new Orders(r.getInt(1), r.getInt(2), Date.valueOf(r.getString(3)), r.getDouble(4));
                ordersList.add(order);
            }
            for (Orders orders : ordersList) {
                lineitemsStatements.setInt(1, orders.getOrderID());
                r = lineitemsStatements.executeQuery();
                while (r.next()) {

                    lineitemsList.add(new LineItems(r.getInt(1), r.getInt(2), r.getString(3), r.getInt(4), r.getDouble(5)));

                }
            }
            so.setLine(lineitemsList);
            so.setOrder(ordersList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return so;
    }
}
