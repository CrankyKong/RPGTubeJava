package com.mycompany.rpgtubejava;


import com.mycompany.rpgtubejava.Item;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Logan
 */
public class Avatar {
    int id;
    String name;
    int inventory_id;
    int gold;
    int level;
    int experience; 

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
    List<Item> items;

    public Avatar() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }

    public List<Item> getItems() {
        return items;
    }
    
    
    
}
