/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.cusomerrepository;

import com.khatabook.idao.CustomerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.khatabook.model.AddCart;
import com.khatabook.model.Customer;
import com.khatabook.model.OrderedDetails;

/**
 *
 * @author bas200181
 */
public class CustomerDaoImpl implements CustomerDao {

    private static MySqlConnection mys;

    @Override
    public int addCustomer(Customer c) {

        String addCust = "insert into Customer values(?,?,?,?,?,default)";
        int ret = 0;
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_a = con.prepareStatement(addCust);) {

            ps_a.setInt(1, c.getCusId());
            ps_a.setString(2, c.getCusName());
            ps_a.setString(3, c.getPhoneNo());
            ps_a.setString(4, c.getCusAadhaar());
            ps_a.setString(5, c.getCusAddress());
            ret = ps_a.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public List<Customer> viewAll() {
        ArrayList<Customer> al = new ArrayList<>();
        String view_all = "Select * from Customer";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_c = con.prepareStatement(view_all)) {
            PreparedStatement ps_d = con.prepareStatement(view_all);
            ResultSet rs1 = ps_d.executeQuery();
            while (rs1.next()) {
                al.add(new Customer(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getDouble(6)));
            }

        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return al;
    }

    //  
    //  public static void main(String[] args) {
    ////     CustomerDaoImpl cd=new CustomerDaoImpl();
    ////     cd.addCustomer();
    //
    //System.out.println("testing");
    //    
    //  }
    @Override
    public int updateCustomerBalance(Customer cu) {
        int d = 0;
        try {
            PreparedStatement ps = KhataBookDaoImpl.getDs().getConnection().prepareStatement("update Customer set cus_bal=? where customer_id=?");
            ps.setDouble(1, cu.getCusBal());
            ps.setInt(2, cu.getCusId());
            d = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;

    }

    @Override
    public Customer getCusdetails(String phoneNo) {
        Customer cus = null;
        try {
            Connection connection = KhataBookDaoImpl.getDs().getConnection();

            PreparedStatement ps_f = connection.prepareStatement("select * from Customer where customer_phoneno=?");
            ps_f.setString(1, phoneNo);
            ResultSet rs = ps_f.executeQuery();

            rs.next();
            cus = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }

    @Override
    public ArrayList<OrderedDetails> viewDetails() {
        ArrayList<OrderedDetails> ol = new ArrayList<>();
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_d = con.prepareStatement("select * from Customer,Orders where Customer.customer_id=Orders.customer_id and ")) {
            ResultSet rs = ps_d.executeQuery();
            while (rs.next()) {
                ol.add(new OrderedDetails(rs.getInt(1), rs.getString(2), rs.getInt(7), rs.getDate(9), rs.getDouble(10)));
            }

        } catch (SQLException ex) {

        }
        return ol;
    }

    @Override
    public ArrayList<OrderedDetails> viewDetails(int cusId) {
        ArrayList<OrderedDetails> ol = new ArrayList<>();
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_d = con.prepareStatement("select * from Customer,Orders where Customer.customer_id=Orders.customer_id and Orders.customer_id=? ")) {
            ps_d.setInt(1, cusId);
            ResultSet rs = ps_d.executeQuery();
            while (rs.next()) {
                ol.add(new OrderedDetails(rs.getInt(1), rs.getString(2), rs.getInt(7), rs.getDate(9), rs.getDouble(10)));
            }

        } catch (SQLException ex) {

        }
        return ol;
    }

    @Override
    public Customer viewCustomer(String mobileNumber) {
        Customer c = null;
        String viewQuery = "select * from Customer where customer_phoneno=?";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_a = con.prepareStatement(viewQuery)) {
            PreparedStatement ps_b = con.prepareStatement(viewQuery);
            ps_b.setString(1, mobileNumber);
            ResultSet rs = ps_b.executeQuery();
            while (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return c;
    }

    @Override
    public Customer viewCustomer(int id) {
        Customer c = null;
        String viewQuery = "select * from Customer where customer_id=?";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_a = con.prepareStatement(viewQuery)) {
            PreparedStatement ps_b = con.prepareStatement(viewQuery);
            ps_b.setInt(1, id);
            ResultSet rs = ps_b.executeQuery();
            while (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return c;
    }

    @Override
    public int updateCustomerBalance(int cusId, double amount) {
        int d = 0;
        try {
            PreparedStatement ps = KhataBookDaoImpl.getDs().getConnection().prepareStatement("update Customer set cus_bal=? where customer_id=?");
            ps.setDouble(1, amount);
            ps.setInt(2, cusId);
            d = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;

    }

    @Override
    public int getCustomerId(String name) {
        int cusId = 0;
        String viewQuery = "select customer_id from khatabook_users where user_name=?";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_a = con.prepareStatement(viewQuery)) {
            ps_a.setString(1, name);
            ResultSet rs = ps_a.executeQuery();
            rs.next();
            cusId = rs.getInt(1);
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return cusId;
    }

    @Override
    public Customer viewCustomerWeb(int cusId) {
        Customer c = null;
        String viewQuery = "select * from Customer where customer_id=?";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_a = con.prepareStatement(viewQuery)) {
            PreparedStatement ps_b = con.prepareStatement(viewQuery);
            ps_b.setInt(1, cusId);
            ResultSet rs = ps_b.executeQuery();
            while (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return c;
    }

    @Override
    public int updateCustomerMobile(String phone, int cusId) {
        int row = 0;
        String updQry = "update Customer set customer_phoneno=? where customer_id=?";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_b = con.prepareStatement(updQry);) {
            ps_b.setString(1, phone);
            ps_b.setInt(2, cusId);
            row = ps_b.executeUpdate();
            //System.out.println("address Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public int updateCustomerAddress(String address, int cusId) {
        int row = 0;
        String updQry = "update Customer set cus_address=? where customer_id=?";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_b = con.prepareStatement(updQry);) {
            ps_b.setString(1, address);
            ps_b.setInt(2, cusId);
            row = ps_b.executeUpdate();
            //System.out.println("address Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public List<AddCart> viewAllPending() {
        ArrayList<AddCart> al = new ArrayList<>();
        String view_all = "Select * from addcart_orders where order_status=?";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_c = con.prepareStatement(view_all)) {
            PreparedStatement ps_d = con.prepareStatement(view_all);
            ps_d.setString(1, "pending");
            ResultSet rs1 = ps_d.executeQuery();
            while (rs1.next()) {
                al.add(new AddCart(rs1.getInt(1), rs1.getInt(2), rs1.getDate(3), rs1.getDouble(4), rs1.getString(5)));
            }

        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return al;
    }

    @Override
    public Customer getCusdetails(int cusId) {
        Customer cus = null;
        try {
            Connection connection = KhataBookDaoImpl.getDs().getConnection();

            PreparedStatement ps_f = connection.prepareStatement("select * from Customer where customer_id=?");
            ps_f.setInt(1, cusId);
            ResultSet rs = ps_f.executeQuery();

            rs.next();
            cus = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }

  
    @Override
    public int updateCustomer(String name, String address, String phoneNo, int cusId) {
        int row = 0;
        String updQry = "update Customer set cus_address=?,customer_name=? ,customer_phoneno=? where customer_id=?";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_b = con.prepareStatement(updQry);) {
            ps_b.setString(1, address);
            ps_b.setString(2, name);
            ps_b.setString(3, phoneNo);
            ps_b.setInt(4, cusId);
            row = ps_b.executeUpdate();
            //System.out.println("address Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public List<Customer> viewMaxBal() {
  ArrayList<Customer> al = new ArrayList<>();
        String view_all = "select * from Customer where cus_bal=(select max(cus_bal) from Customer);";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection(); PreparedStatement ps_c = con.prepareStatement(view_all)) {
            PreparedStatement ps_d = con.prepareStatement(view_all);
            ResultSet rs1 = ps_d.executeQuery();
            while (rs1.next()) {
                al.add(new Customer(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getDouble(6)));
            }

        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return al;   
    }
}
