/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Products {
    String ProductID,ProductName,CatID,SubCatID;
    int Price; 
    String Material;
    String AddDate;
    String describe;
    List<Color> cllist;
    List<Size> slist;
    List<ProductDetail> pdList;
    List<Image> imageList;
    
    public Products() {
    }

    public Products(String ProductID, String ProductName, String CatID, String SubCatID, int Price, String Material, String AddDate, String describe, List<Color> cllist, List<Size> slist, List<ProductDetail> pdList, List<Image> imageList) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.CatID = CatID;
        this.SubCatID = SubCatID;
        this.Price = Price;
        this.Material = Material;
        this.AddDate = AddDate;
        this.describe = describe;
        this.cllist = cllist;
        this.slist = slist;
        this.pdList = pdList;
        this.imageList = imageList;
    }

    public List<Color> getCllist() {
        return cllist;
    }

    public void setCllist(List<Color> cllist) {
        this.cllist = cllist;
    }

    public List<Size> getSlist() {
        return slist;
    }

    public void setSlist(List<Size> slist) {
        this.slist = slist;
    }
    
    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getCatID() {
        return CatID;
    }

    public void setCatID(String CatID) {
        this.CatID = CatID;
    }

    public String getSubCatID() {
        return SubCatID;
    }

    public void setSubCatID(String SubCatID) {
        this.SubCatID = SubCatID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public String getAddDate() {
        return AddDate;
    }

    public void setAddDate(String AddDate) {
        this.AddDate = AddDate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<ProductDetail> getPdList() {
        return pdList;
    }

    public void setPdList(List<ProductDetail> pdList) {
        this.pdList = pdList;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    
}
