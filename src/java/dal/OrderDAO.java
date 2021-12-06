/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.CartDetail;
import model.OrderPacket;
import model.OrderTab;
import model.User;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {

    public void addOrder(User u, List<CartDetail> cart,String name,String phone,String address) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try {
            int totalPrice = 0;
            for (CartDetail i : cart) {
                totalPrice += i.getPrice();
            }
            String sql = "insert into [Order] values (?,?,null,null,N'"+name+"',N'"+address+"','"+phone+"',?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUsername());
            st.setString(2, date);
            st.setInt(3, totalPrice);
            st.executeUpdate();
            //gif gif ddaasy
            String sql1 = "select top 1 orderid from [order] order by OrderID desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs1 = st1.executeQuery();
            if (rs1.next()) {
                int oid = rs1.getInt(1);
                for (CartDetail i : cart) {
                    String sql2 = "insert into [OrderDetail] values (?,?,?,?,null)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setString(2, i.getPd().getProductDetailID());
                    st2.setInt(3, i.getQuantity());
                    st2.setInt(4, i.getPrice());
                    st2.executeUpdate();
                }
            }
            for (CartDetail i : cart) {
                CartDAO cdb = new CartDAO();
                cdb.removeCart(u.getUsername(), i.getPd().getProductDetailID());
            }
        } catch (SQLException e) {
        }
    }
    
    public List<OrderPacket> getOrderDetailByOrderID(int odid){
        List<OrderPacket> list = new ArrayList<>();
        String sql = "select od.OrderID,i.path,od.ProductDetailID,p.ProductName,c.ColorName,s.SizeName,od.quantity,od.price\n" +
"from [OrderDetail] od inner join ProductDetail pd\n" +
"on od.ProductDetailID = pd.ProductDetailID\n" +
"inner join Color c on pd.colorID = c.ColorID\n" +
"inner join Size s on s.SizeID = pd.sizeID\n" +
"inner join Products p on pd.ProductID = p.ProductID\n" +
"inner join Images i on i.ProductID = p.ProductID\n" +
"where OrderID = ? and i.numth = 1;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, odid);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                OrderPacket o = new OrderPacket();
                o.setProductDetailID(rs.getString("productdetailid"));
                o.setPath(rs.getString("path"));
                o.setProductName(rs.getString("productname"));
                o.setColorName(rs.getString("colorname"));
                o.setSizeName(rs.getString("sizename"));
                o.setQuantity(rs.getInt("quantity"));
                o.setPrice(rs.getInt("price"));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    
    }
    
    public List<OrderTab> getOrderNotSend(){
        List<OrderTab> list = new ArrayList<>();
        String sql = "select * from [Order] where SendDate is null order by OrderDate desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                OrderTab o = new OrderTab();
                o.setOrderDate(rs.getString("orderdate"));
                o.setCustomerName(rs.getString("customername"));
                o.setAddress(rs.getString("address"));
                o.setPhonenumber(rs.getString("phonenumber"));
                o.setTotalPrice(rs.getInt("totalPrice"));
                o.setOrderID(rs.getInt("orderid"));
                o.setList(getOrderDetailByOrderID(rs.getInt("orderid")));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<OrderTab> getOrderNotShiped(){
        List<OrderTab> list = new ArrayList<>();
        String sql = "select * from [Order] where ShippedDate is null and SendDate is not null order by SendDate desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                OrderTab o = new OrderTab();
                o.setOrderDate(rs.getString("orderdate"));
                o.setCustomerName(rs.getString("customername"));
                o.setAddress(rs.getString("address"));
                o.setPhonenumber(rs.getString("phonenumber"));
                o.setTotalPrice(rs.getInt("totalPrice"));
                o.setOrderID(rs.getInt("orderid"));
                o.setSendDate(rs.getString("senddate"));
                o.setList(getOrderDetailByOrderID(rs.getInt("orderid")));
                o.setSendDate(null);
                o.setShipedDate(null);
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<OrderTab> getOrderFinished(){
        List<OrderTab> list = new ArrayList<>();
        String sql = "select * from [Order] where ShippedDate is not null and SendDate is not null order by ShippedDate desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                OrderTab o = new OrderTab();
                o.setOrderDate(rs.getString("orderdate"));
                o.setCustomerName(rs.getString("customername"));
                o.setAddress(rs.getString("address"));
                o.setPhonenumber(rs.getString("phonenumber"));
                o.setTotalPrice(rs.getInt("totalPrice"));
                o.setOrderID(rs.getInt("orderid"));
                o.setSendDate(rs.getString("senddate"));
                o.setShipedDate(rs.getString("shippeddate"));
                o.setList(getOrderDetailByOrderID(rs.getInt("orderid")));
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void send(String oid){
        String sql = "update [Order]\n" +
"set SendDate = GETDATE()\n" +
"where OrderID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, oid);
            st.executeUpdate();
            System.out.println("1");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void shipped(String oid){
        String sql = "update [Order]\n" +
"set ShippedDate = GETDATE()\n" +
"where OrderID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, oid);
            st.executeUpdate();
            System.out.println("1");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        OrderDAO o = new OrderDAO();
//        List<OrderTab> l = o.getOrderNotSend();
        o.shipped("10");
//        System.out.println(l.size());
    }
}
