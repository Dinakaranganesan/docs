/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import static dao.mysql.Input.input;
import idao.CustomerDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AddCart;
import model.Customerr;
import model.OrderedDetails;

/**
 *
 * @author bas200181
 */
public class CustomerDaoImpl implements CustomerDao {

    public static MySqlConnection mys = new MySqlConnection();

    @Override
    public int addCustomer(Customerr c) {

        String addCust = "insert into Customer values(?,?,?,?,?,default)";
        int ret = 0;
        try (Connection con = getMys().createConnection(); PreparedStatement ps_a = con.prepareStatement(addCust);) {

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
    public int updateCustomer(Customerr customerr) {
        int row = 0;
        String updQry = "update Customer set cus_address=? where customer_phoneno=?";
        try (Connection con = getMys().createConnection(); PreparedStatement ps_b = con.prepareStatement(updQry);) {
            ps_b.setString(1, customerr.getCusAddress());
            ps_b.setString(2, customerr.getPhoneNo());
            row = ps_b.executeUpdate();
            //System.out.println("address Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public List<Customerr> viewCustomer(String mobileNumber) {
        List<Customerr> parCus = new ArrayList<>();
        String viewQuery = "select * from Customer where customer_phoneno=?";
        try (Connection con = MySqlConnection.createConnection(); PreparedStatement ps_a = con.prepareStatement(viewQuery)) {
            PreparedStatement ps_b = con.prepareStatement(viewQuery);
            ps_b.setString(1, mobileNumber);
            ResultSet rs = ps_b.executeQuery();
            while (rs.next()) {
                parCus.add(new Customerr(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return parCus;
    }

    @Override
    public List<Customerr> viewAll() {
        ArrayList<Customerr> al = new ArrayList<>();
        String view_all = "Select * from Customer";
        try (Connection con = getMys().createConnection(); PreparedStatement ps_c = con.prepareStatement(view_all)) {
            PreparedStatement ps_d = con.prepareStatement(view_all);
            ResultSet rs1 = ps_d.executeQuery();
            while (rs1.next()) {
                al.add(new Customerr(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getDouble(6)));
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
    public int updateCustomerBalance(Customerr cu) {
        int d = 0;
        try {
            PreparedStatement ps = MySqlConnection.createConnection().prepareStatement("update Customer set cus_bal=? where customer_id=?");
            ps.setDouble(1, cu.getCusBal());
            ps.setInt(2, cu.getCusId());
            d = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;

    }

    @Override
    public Customerr getCusdetails(String phone_no) {
        Customerr cus = null;
        try {
            Connection connection = MySqlConnection.createConnection();

            PreparedStatement ps_f = connection.prepareStatement("select * from Customer where customer_phoneno=?");
            ps_f.setString(1, phone_no);
            ResultSet rs = ps_f.executeQuery();

            rs.next();
            cus = new Customerr(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }

    /**
     * @return the mys
     */
    public static MySqlConnection getMys() {
        return mys;
    }

    /**
     * @param aMys the mys to set
     */
    public static void setMys(MySqlConnection aMys) {
        mys = aMys;
    }



    @Override
    public ArrayList<OrderedDetails> viewDetails() {
        ArrayList<OrderedDetails> ol = new ArrayList<>();
        try (Connection con = MySqlConnection.createConnection(); PreparedStatement ps_d = con.prepareStatement("select * from Customer,Orders where Customer.customer_id=Orders.customer_id")) {
            ResultSet rs = ps_d.executeQuery();
            while (rs.next()) {
                ol.add(new OrderedDetails(rs.getInt(1), rs.getString(2), rs.getInt(7), rs.getDate(9), rs.getDouble(10)));
            }

        } catch (SQLException ex) {

        }
        return ol;
    }

    @Override
    public Customerr viewCustomerr(String mobileNumber) {
        Customerr c = null;
        String viewQuery = "select * from Customer where customer_phoneno=?";
        try (Connection con = MySqlConnection.createConnection(); PreparedStatement ps_a = con.prepareStatement(viewQuery)) {
            PreparedStatement ps_b = con.prepareStatement(viewQuery);
            ps_b.setString(1, mobileNumber);
            ResultSet rs = ps_b.executeQuery();
            while (rs.next()) {
                c = new Customerr(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
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
            PreparedStatement ps = MySqlConnection.createConnection().prepareStatement("update Customer set cus_bal=cus_bal-? where customer_id=?");
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
        try (Connection con = MySqlConnection.createConnection(); PreparedStatement ps_a = con.prepareStatement(viewQuery)) {
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
    public Customerr viewCustomerWeb(int cusId) {
        Customerr c = null;
        String viewQuery = "select * from Customer where customer_id=?";
        try (Connection con = MySqlConnection.createConnection(); PreparedStatement ps_a = con.prepareStatement(viewQuery)) {
            PreparedStatement ps_b = con.prepareStatement(viewQuery);
            ps_b.setInt(1, cusId);
            ResultSet rs = ps_b.executeQuery();
            while (rs.next()) {
                c = new Customerr(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
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
        try (Connection con = getMys().createConnection(); PreparedStatement ps_b = con.prepareStatement(updQry);) {
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
        try (Connection con = getMys().createConnection(); PreparedStatement ps_b = con.prepareStatement(updQry);) {
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
        try (Connection con = getMys().createConnection(); PreparedStatement ps_c = con.prepareStatement(view_all)) {
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
    public Customerr getCusdetails(int cusId) {
        Customerr cus = null;
        try {
            Connection connection = MySqlConnection.createConnection();

            PreparedStatement ps_f = connection.prepareStatement("select * from Customer where customer_id=?");
            ps_f.setInt(1, cusId);
            ResultSet rs = ps_f.executeQuery();

            rs.next();
            cus = new Customerr(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }
    public static void main(String[] args) {
        CustomerDaoImpl gg=new CustomerDaoImpl();
        System.out.println(gg.getCusdetails(1));
    }

}
