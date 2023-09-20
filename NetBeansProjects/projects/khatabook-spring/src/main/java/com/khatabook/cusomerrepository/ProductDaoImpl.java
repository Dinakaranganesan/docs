/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.cusomerrepository;

import com.khatabook.idao.ProductDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.khatabook.model.Inventory;

/**
 *
 * @author bas200181
 */
public class ProductDaoImpl implements ProductDao {

    @Override
    public Inventory getProductDetails(int product_id) {
        Inventory inv = null;
        try {
            String viewQuery = "select * from product where product_id=?";

            PreparedStatement ps_e = KhataBookDaoImpl.getDs().getConnection().prepareStatement(viewQuery);
//      System.out.println("Enter the Product_id");
//     int temp_id = Integer.parseInt(input.readLine());
            ps_e.setInt(1, product_id);
            ResultSet rs3 = ps_e.executeQuery();
            rs3.next();
            inv = new Inventory(rs3.getInt(1), rs3.getString(2), rs3.getInt(3), rs3.getDouble(4));
//     inv.setProductId(rs3.getInt(1));
//      inv.setProName(rs3.getString(2));
//      inv.setQuantity(rs3.getInt(3));
//      inv.setPrice(rs3.getDouble(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inv;
    }

    @Override
    public void stockUpdate(Inventory inv) {
        try {
            PreparedStatement ps_h = KhataBookDaoImpl.getDs().getConnection().prepareStatement("update product set quantity=? where product_id=?");
            ps_h.setInt(1, inv.getQuantity());
            ps_h.setInt(2, inv.getProductId());
            ps_h.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int addProduct(Inventory p) {
        int ret = 0;
        String addProd = "insert into product values(?,?,?,?)";
        try (Connection con = KhataBookDaoImpl.getDs().getConnection()) {
            PreparedStatement ps_d = con.prepareStatement(addProd);
            ps_d.setInt(1, p.getProductId());
            ps_d.setString(2, p.getProName());
            ps_d.setInt(3, p.getQuantity());
            ps_d.setDouble(4, p.getPrice());
            ret = ps_d.executeUpdate();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return ret;
    }

    @Override
    public List<Inventory> viewProduct(int productId) {
        List<Inventory> l = new ArrayList<>();
        try {
            String viewQuery = "select * from product where product_id=?";
            Connection con = KhataBookDaoImpl.getDs().getConnection();
            PreparedStatement ps_e = con.prepareStatement(viewQuery);

            ps_e.setInt(1, productId);
            ResultSet rs3 = ps_e.executeQuery();

            while (rs3.next()) {
                l.add(new Inventory(rs3.getInt(1), rs3.getString(2), rs3.getInt(3), rs3.getDouble(4)));
            }

        } catch (SQLException sqe) {
            System.err.println(sqe);
        }
        return l;
    }

    @Override
    public int updateProduct(Inventory i) {
        int update = 0;
        ProductDaoImpl pd = new ProductDaoImpl();
        try {
            String updQuery = "update product set quantity=? where product_id=?";
            Connection connection = KhataBookDaoImpl.getDs().getConnection();
            PreparedStatement ps_c = connection.prepareStatement(updQuery);
            Inventory i1 = pd.getProductDetails(i.getProductId());
            int updquantity = i1.getQuantity();
            ps_c.setInt(1, i.getQuantity() + updquantity);
            ps_c.setInt(2, i.getProductId());
            update = ps_c.executeUpdate();

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.err.println(sqe);
        }
        return update;
    }

    @Override
    public List<Inventory> viewAll() {
        List<Inventory> inventoryList = new ArrayList<>();
        try {
            Connection con = KhataBookDaoImpl.getDs().getConnection();
            String view_all = "Select * from product";
            PreparedStatement ps_d = con.prepareStatement(view_all);
            ResultSet rs2 = ps_d.executeQuery();
            while (rs2.next()) {
                inventoryList.add(new Inventory(rs2.getInt(1), rs2.getString(2), rs2.getInt(3), rs2.getDouble(4)));
            }

        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
        return inventoryList;
    }

}
