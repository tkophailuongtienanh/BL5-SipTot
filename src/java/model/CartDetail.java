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
public class CartDetail {
    private ProductDisplayInCart pd;
    private int quantity,price;

    public CartDetail() {
    }

    public CartDetail(ProductDisplayInCart pd, int quantity, int price) {
        this.pd = pd;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductDisplayInCart getPd() {
        return pd;
    }

    public void setPd(ProductDisplayInCart pd) {
        this.pd = pd;
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
