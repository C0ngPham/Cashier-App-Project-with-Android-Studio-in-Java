package com.example.cashier.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.cashier.Models.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class HistoryRoomDatabase extends RoomDatabase {
    public abstract ItemDao getItemDao();


}
