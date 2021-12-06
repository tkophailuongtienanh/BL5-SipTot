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
public class SubCategories {
    String SubCatID;
    String CatID;
    String SubCatName;

    public SubCategories() {
    }

    public SubCategories(String SubCatID, String CatID, String SubCatName) {
        this.SubCatID = SubCatID;
        this.CatID = CatID;
        this.SubCatName = SubCatName;
    }

    public String getSubCatID() {
        return SubCatID;
    }

    public void setSubCatID(String SubCatID) {
        this.SubCatID = SubCatID;
    }

    public String getCatID() {
        return CatID;
    }

    public void setCatID(String CatID) {
        this.CatID = CatID;
    }

    public String getSubCatName() {
        return SubCatName;
    }

    public void setSubCatName(String SubCatName) {
        this.SubCatName = SubCatName;
    }
    

}
