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
public class ProductDetail {
    private String ProductDetailID,ProductID;
    private int ColorID, SizeID, UnitInStock;

    public ProductDetail(String ProductDetailID, String ProductID, int ColorID, int SizeID, int UnitInStock) {
        this.ProductDetailID = ProductDetailID;
        this.ProductID = ProductID;
        this.ColorID = ColorID;
        this.SizeID = SizeID;
        this.UnitInStock = UnitInStock;
    }

    public ProductDetail() {
    }

    public String getProductDetailID() {
        return ProductDetailID;
    }

    public void setProductDetailID(String ProductDetailID) {
        this.ProductDetailID = ProductDetailID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public int getColorID() {
        return ColorID;
    }

    public void setColorID(int ColorID) {
        this.ColorID = ColorID;
    }

    public int getSizeID() {
        return SizeID;
    }

    public void setSizeID(int SizeID) {
        this.SizeID = SizeID;
    }

    public int getUnitInStock() {
        return UnitInStock;
    }

    public void setUnitInStock(int UnitInStock) {
        this.UnitInStock = UnitInStock;
    }

}
