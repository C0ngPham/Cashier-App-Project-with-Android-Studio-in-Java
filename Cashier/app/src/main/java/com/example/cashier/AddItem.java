package com.example.cashier;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {

    EditText add_item_name;
    EditText add_item_price;

    Button cancel_add_item;
    Button confirm_add_item;




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

        confirm_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
