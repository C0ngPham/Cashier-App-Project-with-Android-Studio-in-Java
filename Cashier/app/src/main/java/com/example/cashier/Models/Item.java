package com.example.cashier.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.text.Editable;

@Entity
public class Item {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public Integer id;

    @ColumnInfo(name = "item_name")
    public String item_name;
    public Integer item_price;
    public String item_description;
    public Integer item_img;

    public Item(String item_name, Integer item_price, String item_description, Integer item_img) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_description = item_description;
        this.item_img = item_img;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
    public Integer getItem_img() {
        return item_img;
    }

    public void setItem_img(Integer item_img) {
        this.item_img = item_img;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getItem_price() {
        return item_price;
    }

    public void setItem_price(Integer item_price) {
        this.item_price = item_price;
    }
}
