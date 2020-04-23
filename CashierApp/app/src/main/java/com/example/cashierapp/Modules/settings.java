package com.example.cashierapp.Modules;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cashierapp.R;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setTitle("Settings");
    }
}
