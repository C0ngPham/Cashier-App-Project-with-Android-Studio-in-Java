package com.example.cashier.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cashier.Models.History;
import com.example.cashier.Models.Item;

import java.util.List;

@Dao
public interface HistoryDao {
    @Query("SELECT * FROM History ORDER BY bill_datetime ASC")
    public List<History> getAllHistory();

    @Insert
    void insert(History history);

    @Update
    void update(History history);

    @Delete
    void delete(History history);
}
