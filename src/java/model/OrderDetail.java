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
public class OrderDetail {
    private int OrderID;
    private String ProductDetailID;
    int quantity;
    float discount;

    public OrderDetail() {
    }

    public OrderDetail(int OrderID, String ProductDetailID, int quantity, float discount) {
        this.OrderID = OrderID;
        this.ProductDetailID = ProductDetailID;
        this.quantity = quantity;
        this.discount = discount;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }


    public String getProductDetailID() {
        return ProductDetailID;
    }

    public void setProductDetailID(String ProductDetailID) {
        this.ProductDetailID = ProductDetailID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    
}
