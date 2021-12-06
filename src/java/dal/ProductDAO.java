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
import model.Color;
import model.Image;
import model.Mat;
import model.ProductBuyed;
import model.ProductDisplay;
import model.ProductDisplayInCart;
import model.Products;
import model.Size;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext {

    public List<ProductDisplay> getLatestProduct() {
        List<ProductDisplay> list = new ArrayList<>();
        String sql = "select top 4 p.ProductID,i.path,p.ProductName,p.Price\n"
                + "from Images i inner join Products p \n"
                + "on i.ProductID = p.ProductID \n"
                + "where i.numth = 1\n"
                + "order by p.AddDate desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDisplay p = new ProductDisplay();
                p.setProductID(rs.getString("productid"));
                p.setProductName(rs.getString("ProductName"));
                p.setPath(rs.getString("path"));
                p.setPrice(rs.getInt("price"));
                list.add(p);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public String getProductDetailID(String cid, String sid,String pid){
        List<ProductDisplay> list = new ArrayList<>();
        String sql = "select * from ProductDetail\n" +
"where ProductID = ? and colorID = ? and sizeID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pid);
            st.setString(2, cid);
            st.setString(3, sid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("ProductDetailID");
            }
        } catch (SQLException e) {
        }
        return "";
    }
    
    public List<ProductDisplay> getTrendingProduct() {
        List<ProductDisplay> list = new ArrayList<>();
        String sql = "select top 4 p1.ProductID,p1.ProductName, p1.Price, i.path, sum(od.quantity) as [sum]\n"
                + "from ((Products p1 inner join Images i on i.ProductID = p1.ProductID) inner join ProductDetail p on p1.productID = p.ProductID) \n"
                + "inner join (OrderDetail od inner join [Order] o on o.OrderID = od.OrderID)\n"
                + "on p.ProductDetailID = od.ProductDetailID\n"
                + "where  o.OrderDate >= getDate()-30 and i.numth = 1\n"
                + "group by p1.ProductID,p1.ProductName,p1.Price, i.path\n"
                + "order by [sum] desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDisplay p = new ProductDisplay();
                p.setProductID(rs.getString("productid"));
                p.setProductName(rs.getString("ProductName"));
                p.setPath(rs.getString("path"));
                p.setPrice(rs.getInt("price"));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<ProductDisplay> getFavouriteProduct() {
        List<ProductDisplay> list = new ArrayList<>();
        String sql = "SELECT top 4 P.ProductID, P.ProductName, P.Price, i.path\n"
                + "FROM (Products  P inner join Images I on P.ProductID=i.ProductID) \n"
                + "INNER JOIN (SELECT ProductID, count(ProductID) as cnt\n"
                + "		FROM WishList \n"
                + "		GROUP BY ProductID) W \n"
                + "ON P.ProductID = W.ProductID\n"
                + "where i.numth =1\n"
                + "order by cnt desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDisplay p = new ProductDisplay();
                p.setProductID(rs.getString("productid"));
                p.setProductName(rs.getString("ProductName"));
                p.setPath(rs.getString("path"));
                p.setPrice(rs.getInt("price"));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Products getProductInfoByPDID(String pdid) {
        ImageDAO idb = new ImageDAO();
        ProductDetailDAO pddb = new ProductDetailDAO();
        String sql = "select p.* \n" +
                    "from ProductDetail pd inner join Products p \n" +
                    "on p.ProductID = pd.ProductID\n" +
                    "where ProductDetailID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pdid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                String id = rs.getString("productid");
                p.setProductID(id);
                p.setProductName(rs.getString("ProductName"));
                p.setCatID(rs.getString("catid"));
                p.setSubCatID(rs.getString("subcatid"));
                p.setPrice(rs.getInt("price"));
                p.setMaterial(rs.getString("material"));
                p.setAddDate(rs.getString("adddate"));
                p.setDescribe(rs.getString("describe"));
                p.setImageList(idb.getAll(id));
                p.setPdList(pddb.getAll(id));
                p.setCllist(getAllColor(id));
                p.setSlist(getAllSize(id));
                return p;
            }
        } catch (SQLException e) {

        }
        return null;
    }
    public Products getProductInfo(String id) {
        ImageDAO idb = new ImageDAO();
        ProductDetailDAO pddb = new ProductDetailDAO();
        String sql = "select * from Products where ProductID like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Products p = new Products();
                p.setProductID(rs.getString("productid"));
                p.setProductName(rs.getString("ProductName"));
                p.setCatID(rs.getString("catid"));
                p.setSubCatID(rs.getString("subcatid"));
                p.setPrice(rs.getInt("price"));
                p.setMaterial(rs.getString("material"));
                p.setAddDate(rs.getString("adddate"));
                p.setDescribe(rs.getString("describe"));
                p.setImageList(idb.getAll(id));
                p.setPdList(pddb.getAll(id));
                p.setCllist(getAllColor(id));
                p.setSlist(getAllSize(id));
                return p;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public List<ProductDisplay> getProduct(String name, String catid, String subcatid, String colorid, String size, String mat, String oderby) {
        List<ProductDisplay> list = new ArrayList<>();
        String sql = "select distinct p.ProductID, p.ProductName, i.path,p.Price, p.AddDate \n"
                + "from (Products p inner join ProductDetail pd on p.ProductID = pd.ProductID) "
                + "inner join Images i on i.ProductID = p.ProductID\n"
                + "where i.numth = 1 ";
        try {
            if (name != null && !name.equals("")) {
                sql += "and p.productname like N'%" + name + "%' ";
            }
            if (catid != null && !catid.equals("")) {
                sql += "and p.catid like '" + catid + "' ";
            }
            if (subcatid != null && !subcatid.equals("")) {
                sql += "and p.subcatid like '" + subcatid + "' ";
            }
            if (colorid != null && !colorid.equals("")) {
                sql += "and pd.colorid = " + colorid + " ";
            }
            if (size != null && !size.equals("")) {
                sql += "and pd.sizeid = " + size + " ";
            }
            if (mat != null && !mat.equals("")) {
                sql += "and p.material like N'" + mat + "' ";
            }
            if (oderby != null && !oderby.equals("")) {
                switch (oderby) {
                    case "1":
                        sql += " Order by p.AddDate desc";
                        break;
                    case "2":
                        sql += " Order by p.AddDate asc";
                        break;
                    case "3":
                        sql += " Order by p.Price desc";
                        break;
                    case "4":
                        sql += " Order by p.Price asc";
                        break;
                    case "5":
                        sql += " Order by p.ProductName asc";
                        break;
                    case "6":
                        sql += " Order by p.ProductName desc";
                        break;
                    default:
                        break;
                }
            }
            System.out.println(sql);
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductDisplay p = new ProductDisplay();
                p.setProductID(rs.getString("productid"));
                p.setProductName(rs.getString("ProductName"));
                p.setPath(rs.getString("path"));
                p.setPrice(rs.getInt("price"));
                list.add(p);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public List<ProductDisplay> getListByPage(List<ProductDisplay> list, int start, int end) {
        ArrayList<ProductDisplay> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Mat> getAllMat() {
        List<Mat> arr = new ArrayList<>();
        String sql = "select distinct Material from Products";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                arr.add(new Mat(rs.getString("material")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arr;
    }

    public List<Color> getAllColor() {
        List<Color> arr = new ArrayList<>();
        String sql = "select * from Color";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                arr.add(new Color(rs.getString("colorname"), rs.getInt("colorid")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arr;
    }

    public List<Size> getAllSize() {
        List<Size> arr = new ArrayList<>();
        String sql = "select * from Size";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                arr.add(new Size(rs.getString("Sizename"), rs.getInt("sizeid")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arr;
    }

    public List<ProductBuyed> getProBuyed(String username) {
        List<ProductBuyed> list = new ArrayList<>();
        String sql = "select p.productid,p.ProductName, i.path , p.Price ,sum(od.quantity) as quantity\n" +
"                    from\n" +
"                    Images i inner join Products p on i.ProductID = p.ProductID\n" +
"                    inner join ProductDetail pd on pd.ProductID = p.ProductID\n" +
"                    inner join Color c on pd.colorID = c.colorID\n" +
"                    inner join Size s on pd.sizeID = s.SizeID\n" +
"                    inner join OrderDetail od on od.ProductDetailID = pd.ProductDetailID\n" +
"                    inner join [Order] o on od.OrderID = o.OrderID\n" +
"                    inner join [User] u on u.username = o.username\n" +
"                    where i.numth = 1 and  getdate() >= o.ShippedDate\n" +
"                    and u.username=?\n" +
"                    group by p.ProductID,p.ProductName, i.path , p.Price";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductBuyed p = new ProductBuyed();
                p.setProductID(rs.getString("productid"));
                p.setProductName(rs.getString("productname"));
                p.setPath(rs.getString("path"));
                p.setPrice(rs.getInt("price") * rs.getInt("quantity"));
                p.setQuantity(rs.getInt("quantity"));
                list.add(p);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Color> getAllColor(String pid) {
        List<Color> arr = new ArrayList<>();
        String sql = "select distinct c.ColorName, c.ColorID\n"
                + "from Products p inner join ProductDetail pd \n"
                + "on p.ProductID = pd.ProductID inner join Color c \n"
                + "on pd.colorID = c.ColorID\n"
                + "where p.ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                arr.add(new Color(rs.getString("colorname"), rs.getInt("colorid")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return arr;
    }

    public List<Size> getAllSize(String pid) {
        List<Size> arr = new ArrayList<>();
        String sql = "select distinct s.SizeName, s.SizeID\n"
                + "from Products p inner join ProductDetail pd \n"
                + "on p.ProductID = pd.ProductID inner join size s\n"
                + "on pd.sizeID = s.SizeID\n"
                + "where p.ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                arr.add(new Size(rs.getString("sizename"), rs.getInt("sizeid")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arr;
    }
    
    public ProductDisplayInCart getProductDisplayInCartByPDID(String pdid) {
        ProductDisplayInCart pdic = new ProductDisplayInCart();
        String sql = "select pd.productDetailID,i.path,p.ProductName, c.ColorName, s.SizeName,p.price,pd.UnitInStock\n" +
                    "from Products p \n" +
                    "inner join ProductDetail pd on pd.ProductID = p.ProductID\n" +
                    "inner join Images i on i.ProductID = p.ProductID\n" +
                    "inner join Color c on c.ColorID = pd.colorID\n" +
                    "inner join Size s on s.SizeID = pd.sizeID\n" +
                    "where i.numth=1 and pd.ProductDetailID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pdid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                pdic.setProductDetailID(pdid);
                pdic.setProductName(rs.getString("productname"));
                pdic.setPath(rs.getString("path"));
                pdic.setColorName(rs.getString("colorname"));
                pdic.setSizeName(rs.getString("sizename"));
                pdic.setPrice(rs.getInt("price"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pdic;
    }
    public int getUnitInStock(String pdid){
        String sql = "select * from ProductDetail where ProductDetailID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pdid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("unitinstock");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    public static void main(String[] args) {
        ProductDAO c = new ProductDAO();
//        List<ProductBuyed> list = c.getProBuyed("jun");
//        String a = c.getProductDetailID("8", "1", "1s50");
        int p = c.getUnitInStock("1s5001");
        System.out.println(p);
    }
}
