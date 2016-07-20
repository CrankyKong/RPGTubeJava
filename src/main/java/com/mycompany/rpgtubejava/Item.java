package com.mycompany.rpgtubejava;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Logan
 */
public class Item {
    String name;
    String desc;
    String picture;

    public Item() {
        setName(null);
        setDesc(null);
        setPicture(null);
    }
    
    

    public Item(String name, String desc, String picture) {
        this.name = name;
        this.desc = desc;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getPicture() {
        return picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public void display(){
        System.out.println(name + " " + desc + " " + picture);
    }
}