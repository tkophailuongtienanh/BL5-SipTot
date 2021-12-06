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
public class OrderPacket {
    String ProductDetailID,path ,ProductName,colorName,sizeName;
    int quantity,price;

    public OrderPacket() {
    }

    public OrderPacket(String ProductDetailID, String path, String ProductName, String colorName, String sizeName, int quantity, int price) {
        this.ProductDetailID = ProductDetailID;
        this.path = path;
        this.ProductName = ProductName;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getProductDetailID() {
        return ProductDetailID;
    }

    public void setProductDetailID(String ProductDetailID) {
        this.ProductDetailID = ProductDetailID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
