/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class ProductDisplayInCart {
    
    private String productDetailID,path,ProductName, ColorName, SizeName;
    private int price;

    public ProductDisplayInCart() {
    }

    public ProductDisplayInCart(String productDetailID, String path, String ProductName, String ColorName, String SizeName, int price) {
        this.productDetailID = productDetailID;
        this.path = path;
        this.ProductName = ProductName;
        this.ColorName = ColorName;
        this.SizeName = SizeName;
        this.price = price;
    }

    public String getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(String productDetailID) {
        this.productDetailID = productDetailID;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getColorName() {
        return ColorName;
    }

    public void setColorName(String ColorName) {
        this.ColorName = ColorName;
    }

    public String getSizeName() {
        return SizeName;
    }

    public void setSizeName(String SizeName) {
        this.SizeName = SizeName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
