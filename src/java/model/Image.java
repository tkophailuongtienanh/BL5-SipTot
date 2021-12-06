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
public class Image {
    private String productID;
    private String path;
    private int numth;

    public Image() {
    }

    public Image(String productID, String path, int numth) {
        this.productID = productID;
        this.path = path;
        this.numth = numth;
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNumth() {
        return numth;
    }

    public void setNumth(int numth) {
        this.numth = numth;
    }
}
