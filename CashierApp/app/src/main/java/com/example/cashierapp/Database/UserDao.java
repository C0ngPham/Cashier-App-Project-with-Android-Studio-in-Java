package com.example.cashierapp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cashierapp.Models.USER;

@Dao
public interface UserDao {
    @Query("SELECT * FROM USER where username= :username and password= :password")
    USER getUser(String username, String password);

    @Insert
    void insert(USER user);

    @Update
    void update(USER user);

    @Delete
    void delete(USER user);
}
