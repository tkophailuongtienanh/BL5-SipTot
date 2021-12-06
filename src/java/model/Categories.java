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
public class Categories {

    private String CatID, Catname;
    List<SubCategories> subList;

    public Categories(String CatID, String Catname, List<SubCategories> subList) {
        this.CatID = CatID;
        this.Catname = Catname;
        this.subList = subList;
    }

    public List<SubCategories> getSubList() {
        return subList;
    }

    public void setSubList(List<SubCategories> subList) {
        this.subList = subList;
    }

    

    public Categories() {
    }

    public String getCatID() {
        return CatID;
    }

    public void setCatID(String CatID) {
        this.CatID = CatID;
    }

    public String getCatname() {
        return Catname;
    }

    public void setCatname(String Catname) {
        this.Catname = Catname;
    }

}
