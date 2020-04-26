package com.example.cashier.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.cashier.Models.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();

}
