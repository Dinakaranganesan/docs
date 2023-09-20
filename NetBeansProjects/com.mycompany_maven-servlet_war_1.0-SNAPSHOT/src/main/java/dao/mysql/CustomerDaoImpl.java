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
    public void stats(Connection con) {
        boolean sts = true;
        try {
            do {
                System.out.println("");
                System.out.println("1.paid customers");
                System.out.println("2.Not paid customers");
                System.out.println("3.customer payment details");
                System.out.println("4.order placed on particular date");
                System.out.println("5. Order placed between dates");
                System.out.println("6.Exit");
                System.out.println("Enter the option");
                int st = Integer.parseInt(input.readLine());
                switch (st) {
                    case 1: {
                        PreparedStatement pg = con.prepareStatement("select * from Customer where cus_bal  in (0)");
                        ResultSet d = pg.executeQuery();
                        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
                        System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|", "CID", "customer name", "phonenumber", "Aadhar", "Address", "cus_bal");
                        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
                        while (d.next()) {
                            System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|", d.getInt(1), d.getString(2), d.getString(3), d.getString(4), d.getString(5), d.getDouble(6));
                            System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
                        }
                        break;
                    }
                    case 2: {
                        PreparedStatement pg = con.prepareStatement("select * from Customer where cus_bal not in (0)");
                        ResultSet d = pg.executeQuery();
                        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
                        System.out.format("\n|%-4s|%-15s|%-12s|%-13s|%-25s|%9s|", "CID", "customer name", "phonenumber", "Aadhar", "Address", "cus_bal");
                        System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
//            System.out.printf("%10s%15s%13s%10s%15s%15s", "customer_id", "name", "phonenumber", "aadhar", "adress", "cus_balance");
//            System.out.println();
                        while (d.next()) {
                            System.out.format("\n|%-4d|%-15s|%-12s|%-13s|%-25s|%9s|", d.getInt(1), d.getString(2), d.getString(3), d.getString(4), d.getString(5), d.getDouble(6));
                            System.out.print("\n+" + "-".repeat(4) + "+" + "-".repeat(15) + "+" + "-".repeat(12) + "+" + "-".repeat(13) + "+" + "-".repeat(25) + "+" + "-".repeat(9) + "+");
//              System.out.printf("%10s%15s%13s%13s%15s%14s", d.getInt(1), d.getString(2), d.getString(3), d.getString(4), d.getString(5), d.getDouble(6));
//              System.out.println();
                        }
                        break;
                    }
                    case 3: {
                        // PreparedStatement pg1 = con.prepareStatement("select * from payment ");
                        PreparedStatement pg3 = con.prepareStatement("select payment.payment_id,payment.customer_id,Customer.customer_name,Customer.cus_address ,payment.amount,payment.paid_date from Customer,payment where Customer.customer_id=payment.customer_id");
                        ResultSet rs = pg3.executeQuery();

//            PreparedStatement pg = con.prepareStatement("select customer_name,cus_address from Customer where customer_id=?");
//            ResultSet d1 = pg1.executeQuery();
//            while (d1.next()) {
//              int cus_id = d1.getInt(2);
//              pg.setInt(1, cus_id);
//              ResultSet d = pg.executeQuery();
                        System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(15) + "+" + "-".repeat(13) + "+" + "-".repeat(13) + "+" + "-".repeat(10) + "+" + "-".repeat(14) + "+");
                        System.out.format("\n|%10s|%15s|%13s|%13s|%10s|%14s|", "pay_id", "cus_id", "name", "Addresss", "Amount", "paid_date");
                        System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(15) + "+" + "-".repeat(13) + "+" + "-".repeat(13) + "+" + "-".repeat(10) + "+" + "-".repeat(14) + "+");
//              System.out.printf("%10s%15s%13s%10s%15s%15s", "payment_id", "customer_id", "name", "Address", "Amount", "Dateofpayment");
//              System.out.println();
                        while (rs.next()) {
                            System.out.format("\n|%10s|%15s|%13s|%13s|%10s|%14s|", rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                            System.out.print("\n+" + "-".repeat(10) + "+" + "-".repeat(15) + "+" + "-".repeat(13) + "+" + "-".repeat(13) + "+" + "-".repeat(10) + "+" + "-".repeat(14) + "+");
//                System.out.printf("%10s%15s%13s%13s%10s%14s", d1.getInt(1), cus_id, d.getString(1), d.getString(2), d1.getDouble(3), d1.getDate(4));
//                System.out.println();
                            // }
                        }
                        break;
                    }
                    case 4: {
                        PreparedStatement ps = con.prepareStatement("select Orders.order_id,Orders.customer_id,Customer.customer_name,Orders.OrderedDate,Orders.total_amount where Customer.customer_id=Orders.customer_id");
                        ResultSet rs2 = ps.executeQuery();
                        System.out.println("Enter the DATE  (format yyyy-mm-dd");
                        Date date = Date.valueOf(input.readLine());

                        PreparedStatement pg1 = con.prepareStatement("select * from Orders  where OrderedDate=?");

                        PreparedStatement pg = con.prepareStatement("select customer_name,cus_address from Customer where customer_id=?");
                        pg1.setDate(1, date);
                        ResultSet d1 = pg1.executeQuery();
                        System.out.printf("%10s%15s%13s%17s%20s%15s", "Order_id", "customer_id", "name", "Address", "DateofOrder", "Total_Amount");
                        while (d1.next()) {
                            int cus_id = d1.getInt(2);
                            pg.setInt(1, cus_id);
                            ResultSet d = pg.executeQuery();

                            System.out.println();
                            while (d.next()) {
                                System.out.printf("%10s%15s%13s%17s%20s%14s", d1.getInt(1), cus_id, d.getString(1), d.getString(2), d1.getDate(3), d1.getDouble(4));
                                System.out.println();
                            }

                        }
                        break;
                    }
                    case 5: {
                        System.out.println("Enter stating the DATE  (format yyyy-mm-dd");

                        Date date = Date.valueOf(input.readLine());

                        System.out.println("Enter stating the DATE  (format yyyy-mm-dd");
                        Date date1 = Date.valueOf(input.readLine());
                        PreparedStatement pg1 = con.prepareStatement("select * from Orders  where OrderedDate between ? and?");

                        PreparedStatement pg = con.prepareStatement("select customer_name,cus_address from Customer where customer_id=?");
                        pg1.setDate(1, date);
                        pg1.setDate(2, date1);
                        ResultSet d1 = pg1.executeQuery();
                        System.out.printf("%10s%15s%13s%17s%20s%15s", "Order_id", "customer_id", "name", "Address", "DateofOrder", "Total_Amount");
                        while (d1.next()) {
                            int cus_id = d1.getInt(2);
                            pg.setInt(1, cus_id);
                            ResultSet d = pg.executeQuery();

                            System.out.println();
                            while (d.next()) {
                                System.out.printf("%10s%15s%13s%17s%20s%14s", d1.getInt(1), cus_id, d.getString(1), d.getString(2), d1.getDate(3), d1.getDouble(4));
                                System.out.println();
                            }
                        }
                        break;
                    }
                    case 6: {
                        sts = false;
                        break;
                    }
                    default: {
                        System.err.println("Enter Correct Option");
                        break;
                    }
                }

            } while (sts);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

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

    public static void main(String[] args) {
        Customerr cus = new Customerr();
        cus.setCusName("sultan");
        cus.setPhoneNo("9190909090");
        cus.setCusAadhaar("1234567890123456");
        cus.setCusAddress("kapalur");
        CustomerDaoImpl cv = new CustomerDaoImpl();
        int r = cv.addCustomer(cus);
        System.out.println(r);
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
    public int updateCustomer(String phone, int cusId) {
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

}
