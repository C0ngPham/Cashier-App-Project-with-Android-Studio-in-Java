package com.example.cashierapp.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class USER implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String account_name;
    public String username;
    public String password;

    public USER(String account_name, String username, String password) {
        this.account_name = account_name;
        this.username = username;
        this.password = password;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account_name='" + account_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
