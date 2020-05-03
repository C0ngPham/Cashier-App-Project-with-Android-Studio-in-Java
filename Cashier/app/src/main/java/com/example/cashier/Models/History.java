package com.example.cashier.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class History {
    @PrimaryKey (autoGenerate = true)
    @NonNull
    public int id;
    String bill_datetime;
    Integer bill_price;
    String bill_item;

    public History(String bill_datetime, Integer bill_price, String bill_item) {
        this.bill_datetime = bill_datetime;
        this.bill_price = bill_price;
        this.bill_item = bill_item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBill_datetime() {
        return bill_datetime;
    }

    public void setBill_datetime(String bill_datetime) {
        this.bill_datetime = bill_datetime;
    }

    public Integer getBill_price() {
        return bill_price;
    }

    public void setBill_price(Integer bill_price) {
        this.bill_price = bill_price;
    }

    public String getBill_item() {
        return bill_item;
    }

    public void setBill_item(String bill_item) {
        this.bill_item = bill_item;
    }
}
