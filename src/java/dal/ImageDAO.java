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
import model.Image;

/**
 *
 * @author Admin
 */
public class ImageDAO extends DBContext{
    public String getImageAva(String productID){
        return "";
    }
    public List<Image> getAll(String productID){
        List<Image> list = new ArrayList<>();
        String sql = "select * from Images where ProductID like ? order by numth asc";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,productID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Image i = new Image();
                i.setPath(rs.getString("path"));
                i.setProductID(rs.getString("productid"));
                i.setNumth(rs.getInt("numth"));
                list.add(i);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public static void main(String[] args) {
        ImageDAO c = new ImageDAO();
        List<Image> list = c.getAll("1S50");
        System.out.println(list.size());
    }
}
