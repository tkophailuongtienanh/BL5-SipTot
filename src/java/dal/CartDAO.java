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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CartDetail;
import model.ProductDisplayInCart;

/**
 *
 * @author Admin
 */
public class CartDAO extends DBContext {

    public List<CartDetail> getAll(String username) {
        List<CartDetail> list = new ArrayList<>();
        String sql = "select pd.ProductDetailID,i.path,p.ProductName,cl.ColorName,s.SizeName,p.Price,cd.quantity\n"
                + " from CartDetail cd \n"
                + " inner join Cart c on c.CartID = cd.CartID\n"
                + " inner join ProductDetail pd on cd.ProductDetailID = pd.ProductDetailID\n"
                + " inner join Products p on p.ProductID=pd.ProductID\n"
                + " inner join Images i on i.ProductID=p.ProductID\n"
                + " inner join Color cl on cl.ColorID = pd.colorID\n"
                + " inner join Size s on s.SizeID = pd.sizeID\n"
                + " where i.numth=1 and c.username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDisplayInCart p = new ProductDisplayInCart();
                    p.setProductDetailID(rs.getString("ProductDetailID"));
                    p.setProductName(rs.getString("ProductName"));
                    p.setPrice(rs.getInt("Price"));
                    p.setPath(rs.getString("path"));
                    p.setColorName(rs.getString("colorname"));
                    p.setSizeName(rs.getString("sizename"));
                CartDetail cd = new CartDetail();
                cd.setPd(p);
                cd.setPrice(p.getPrice());
                cd.setQuantity(rs.getInt("quantity"));
                list.add(cd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
     
    
    
    public int getQuantityByID(String username, String pdid) {
        String sql = "select cd.* from CartDetail cd inner join Cart c on cd.CartID=c.CartID\n" +
                    "where c.username = ? and cd.ProductDetailID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, pdid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public Integer getCart(String username) {
        String sql = "select * from Cart where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("cartid");
            } else {
                String sql1 = "insert into Cart values('" + username + "')";
                try {
                    PreparedStatement st1 = connection.prepareStatement(sql1);
                    st1.executeUpdate();
                    return getCart(username);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void addCart(String username, CartDetail cd) {
        String sql1 = "select cd.* from CartDetail cd inner join Cart c on cd.CartID=c.CartID\n" +
                       " where c.username = ? and cd.ProductDetailID = ?";
        try {
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setString(1, username);
            st1.setString(2, cd.getPd().getProductDetailID());
            ResultSet rs1 = st1.executeQuery();
            if (!rs1.next()) {
                //them
                String sql = "insert into CartDetail values(?,?,?,?)";
                try {
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setInt(1, getCart(username));
                    st.setString(2, cd.getPd().getProductDetailID());
                    st.setInt(3, cd.getQuantity());
                    st.setInt(4, cd.getPrice());
                    st.executeUpdate();
                    System.out.println("1");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else {
                //cong don
                String sql = "UPDATE CartDetail\n"
                        + " SET quantity = ?\n"
                        + " WHERE ProductDetailID = ? and CartID = ?";
                try {
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setInt(1, rs1.getInt("quantity") + cd.getQuantity());
                    st.setString(2, cd.getPd().getProductDetailID());
                    st.setInt(3, getCart(username));
                    st.executeUpdate();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeCart(String username, String pdid) {
        String sql1 = "select cd.* from CartDetail cd inner join Cart c on cd.CartID=c.CartID\n" +
                    " where c.username = ? and cd.ProductDetailID = ?";
        try {
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setString(1, username);
            st1.setString(2, pdid);
            ResultSet rs1 = st1.executeQuery();
            if (rs1.next()) {
                String sql = "delete from Cartdetail where CartID = ? and ProductDetailID = ?";
                try {
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setInt(1, getCart(username));
                    st.setString(2, pdid);
                    st.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        CartDAO c = new CartDAO();
        List<CartDetail> a = c.getAll("jun");
        System.out.println(a.size());
    }
}
