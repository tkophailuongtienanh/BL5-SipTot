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
public class WishList {
    private String username;
    private List<Products> p;

    public WishList() {
    }

    public WishList(String username, List<Products> p) {
        this.username = username;
        this.p = p;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Products> getP() {
        return p;
    }

    public void setP(List<Products> p) {
        this.p = p;
    }
    private Products getProductsByID(String id) {
        for (Products i : p) {
            if (i.getProductID().equals(id)) {
                return i;
            }
        }
        return null;
    }
    public void addItem(Products t) {
        if (getProductsByID(t.getProductID())!=null) {
            Products i = getProductsByID(t.getProductID());
        } else {
            p.add(t);
        }
    }
    public void removeItem(String id) {
        if (getProductsByID(id) != null) {
            p.remove(getProductsByID(id));
        }
    }
}
