/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Profile;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBContext {

    public User check(String user, String pass) {
        User u = null;
        String sql = "select * from [user] where username = ? and password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return u;
    }

    public Profile getProfile(String username) {
        Profile p = new Profile();
        String sql = "select * from [profile] where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p.setName(rs.getString("Name"));
                p.setDob(rs.getString("dob"));
                p.setAddress(rs.getString("address"));
                p.setUsername(rs.getString("username"));
                p.setPhoneNumber(rs.getString("PhoneNumber"));
                return p;
            } else {
                String sql1 = "insert into [profile] values ('','','','','" + username + "')";
                try {
                    PreparedStatement st1 = connection.prepareStatement(sql1);
                    st1.executeUpdate();
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return getProfile(username);
    }

    public String checkUser(String username) {
        String sql = "select * from [User] where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return "Tên đăng nhập đã tồn tại";
            }
        } catch (Exception e) {
        }
        return "";
    }

    public void createUser(String username, String password) {
        String sql = "insert into [User] values(?,?,1)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateProfile(Profile p) {
        String sql = "update profile set name = ?, dob = ?,phonenumber=?, address = ? where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setString(2, p.getDob());
            st.setString(3, p.getPhoneNumber());
            st.setString(4, p.getAddress());
            st.setString(5, p.getUsername());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public List<User> getAll(){
        List<User> list = new ArrayList<>();
        String sql = "select * from [User] order by [role] desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getInt("role"));
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        UserDAO c = new UserDAO();
        Profile u = new Profile();
        u = c.getProfile("Jun");
        System.out.println(u.getUsername());
    }
}
