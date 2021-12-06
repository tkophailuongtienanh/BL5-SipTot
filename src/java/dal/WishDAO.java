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
import model.ProductDisplay;
import model.User;

/**
 *
 * @author Admin
 */
public class WishDAO extends DBContext {

    public List<ProductDisplay> getAll(String username) {
        List<ProductDisplay> list = new ArrayList<>();
        String sql = "select p.ProductID,p.ProductName,p.Price,i.path \n"
                + "from WishList w inner join Products p \n"
                + "on w.ProductID = p.ProductID\n"
                + "inner join Images i on i.ProductID = p.ProductID\n"
                + "where i.numth = 1 and w.username=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDisplay p = new ProductDisplay();
                p.setProductID(rs.getString("ProductID"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getInt("Price"));
                p.setPath(rs.getString("path"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void addWish(String username, String pid) {
        String sql1 = "select * from WishList where username = ? and ProductID = ?";
        try {
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setString(1, username);
            st1.setString(2, pid);
            ResultSet rs1 = st1.executeQuery();
            if (!rs1.next()) {
                ProductDisplay p = null;
                String sql = "insert into WishList values(?,?)";
                try {
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setString(1, username);
                    st.setString(2, pid);
                    st.executeUpdate();
                System.out.println("1");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void removeWish(String username, String pid) {
        String sql1 = "select * from WishList where username = ? and ProductID = ?";
        try {
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setString(1, username);
            st1.setString(2, pid);
            ResultSet rs1 = st1.executeQuery();
            if (rs1.next()) {
                String sql = "delete from WishList where username = ? and ProductID = ?";
                try {
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setString(1, username);
                    st.setString(2, pid);
                    st.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        WishDAO wdb = new WishDAO();
        wdb.removeWish("phuon","1s50");
        System.out.println();
    }
}
