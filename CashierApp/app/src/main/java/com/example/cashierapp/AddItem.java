package com.example.cashierapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AddItem extends AppCompatActivity {

    EditText add_item_name;
    EditText add_item_price;

    Button cancel_add_item;
    Button confirm_add_item;

    ArrayList <String> item_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        cancel_add_item = findViewById(R.id.cancel_add_item);
        confirm_add_item = findViewById(R.id.confirm_add_item);

        add_item_name = findViewById(R.id.add_item_name);
        add_item_price = findViewById(R.id.add_item_price);

        cancel_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_add_item = new Intent(AddItem.this, MainMenu.class);
                startActivity(it_add_item);
            }
        });
    }
}
