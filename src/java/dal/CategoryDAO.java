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
import model.Categories;
import model.SubCategories;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext{
    public List<SubCategories> getAllSub(String catID){
        List<SubCategories> list = new ArrayList<>();
        String sql = "select * from SubCategories where CatID like ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,catID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                SubCategories sc = new SubCategories();
                sc.setCatID(rs.getString("catid"));
                sc.setSubCatID(rs.getString("subcatid"));
                sc.setSubCatName(rs.getString("subcatname"));
                list.add(sc);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public List<Categories> getAll(){
        List<Categories> list = new ArrayList<>();
        String sql = "select distinct c.Name,c.CatID\n" +
                    "from Products p inner join Categories c\n" +
                    "on p.CatID = c.CatID";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Categories c = new Categories();
                c.setCatname(rs.getString("name"));
                c.setCatID(rs.getString("catid"));
                list.add(c);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        List<Categories> list = c.getAll();
        System.out.println(list.size());
    }
    
}
