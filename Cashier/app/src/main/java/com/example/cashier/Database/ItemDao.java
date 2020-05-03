package com.example.cashier.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cashier.Models.Item;
import com.example.cashier.Models.User;

import java.util.List;

@Dao
public interface ItemDao{
    @Query("SELECT * FROM Item ORDER BY item_name ASC")
    public List<Item> getAllItem();

    @Insert
    void insert(Item item);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);
}
