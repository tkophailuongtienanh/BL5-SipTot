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
public class Order {
    private int OrderID;
    private String username,OrderDate,sendDate,ShippedDate;
    private int TotalPrice;
    List<OrderDetail> odlist;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public Order(int OrderID, String username, String OrderDate, String sendDate, String ShippedDate, int TotalPrice, List<OrderDetail> odlist) {
        this.OrderID = OrderID;
        this.username = username;
        this.OrderDate = OrderDate;
        this.sendDate = sendDate;
        this.ShippedDate = ShippedDate;
        this.TotalPrice = TotalPrice;
        this.odlist = odlist;
    }

    public void setOdlist(List<OrderDetail> odlist) {
        this.odlist = odlist;
    }

    public List<OrderDetail> getOdlist() {
        return odlist;
    }
    

    public Order() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(String ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

}
