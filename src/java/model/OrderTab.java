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
public class OrderTab {
    int OrderID;
    String OrderDate,SendDate,ShipedDate,CustomerName,address,phonenumber;
    int TotalPrice;
    List<OrderPacket> list;

    public OrderTab() {
    }

    public OrderTab(int OrderID, String OrderDate, String SendDate, String ShipedDate, String CustomerName, String address, String phonenumber, int TotalPrice, List<OrderPacket> list) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.SendDate = SendDate;
        this.ShipedDate = ShipedDate;
        this.CustomerName = CustomerName;
        this.address = address;
        this.phonenumber = phonenumber;
        this.TotalPrice = TotalPrice;
        this.list = list;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getOrderID() {
        return OrderID;
    }

    

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getSendDate() {
        return SendDate;
    }

    public void setSendDate(String SendDate) {
        this.SendDate = SendDate;
    }

    public String getShipedDate() {
        return ShipedDate;
    }

    public void setShipedDate(String ShipedDate) {
        this.ShipedDate = ShipedDate;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public List<OrderPacket> getList() {
        return list;
    }

    public void setList(List<OrderPacket> list) {
        this.list = list;
    }
    
}
