/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProductDetail;

/**
 *
 * @author Admin
 */
public class ProductDetailDAO extends DBContext {

    public List<ProductDetail> getAll(String productID) {
        List<ProductDetail> list = new ArrayList<>();
        String sql = "select * from Productdetail where ProductID = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, productID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDetail pd = new ProductDetail();
                pd.setProductID(rs.getString("ProductID"));
                pd.setProductDetailID(rs.getString("ProductdetailID"));
                pd.setColorID(rs.getInt("colorID"));
                pd.setSizeID(rs.getInt("Sizeid"));
                pd.setUnitInStock(rs.getInt("unitinstock"));
                list.add(pd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<ProductDetail> getAll() {
        List<ProductDetail> list = new ArrayList<>();
        String sql = "select * from Productdetail ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDetail pd = new ProductDetail();
                pd.setProductID(rs.getString("ProductID"));
                pd.setProductDetailID(rs.getString("ProductdetailID"));
                pd.setColorID(rs.getInt("colorID"));
                pd.setSizeID(rs.getInt("Sizeid"));
                pd.setUnitInStock(rs.getInt("unitinstock"));
                list.add(pd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ProductDetail getProductDetailByPDID(String id) {
        ProductDetail pd = new ProductDetail();
        String sql = "select * from Productdetail where ProductdetailID = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                pd.setProductID(rs.getString("ProductID"));
                pd.setProductDetailID(rs.getString("ProductdetailID"));
                pd.setColorID(rs.getInt("colorID"));
                pd.setSizeID(rs.getInt("Sizeid"));
                pd.setUnitInStock(rs.getInt("unitinstock"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pd;
    }

    public static void main(String[] args) {
        ProductDetailDAO c = new ProductDetailDAO();
        List<ProductDetail> list = c.getAll("1S50");
        System.out.println(list.size());
    }
}
