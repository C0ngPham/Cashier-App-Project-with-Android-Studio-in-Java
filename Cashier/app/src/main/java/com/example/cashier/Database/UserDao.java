package com.example.cashier.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.cashier.Models.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM USER where username= :username and password= :password")
    User getUser(String username, String password);


    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
