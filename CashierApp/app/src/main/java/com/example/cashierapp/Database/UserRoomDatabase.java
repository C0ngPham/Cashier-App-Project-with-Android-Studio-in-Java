package com.example.cashierapp.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.cashierapp.Models.USER;

@Database(entities = {USER.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();

}
