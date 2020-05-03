package com.example.cashier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cashier.Database.ItemDao;
import com.example.cashier.Models.Item;

public class AddItem extends AppCompatActivity {

    EditText add_item_name;
    EditText add_item_price;
    EditText add_item_des;

    Button cancel_add_item;
    Button confirm_add_item;
    private ItemDao itemDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        setTitle("Add item");

        cancel_add_item = findViewById(R.id.cancel_add_item);
        confirm_add_item = findViewById(R.id.confirm_add_item);

        add_item_name = findViewById(R.id.it_name);
        add_item_price = findViewById(R.id.it_price);
        add_item_des = findViewById(R.id.it_price);

        cancel_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it_add_item = new Intent(AddItem.this, MainMenu.class);
                startActivity(it_add_item);
            }
        });

        confirm_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
