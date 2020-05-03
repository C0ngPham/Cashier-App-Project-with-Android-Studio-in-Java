package com.example.cashier.Modules;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.cashier.Database.UserRoomDatabase;
import com.example.cashier.Models.User;
import com.example.cashier.R;

public class Accounts extends AppCompatActivity {

    public TextView tv_name;
    public TextView tv_id;
    public TextView change_password;
    public User user;

    UserRoomDatabase userRoomDatabase;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        setTitle("Account");

        user = (User) getIntent().getSerializableExtra("User");

        tv_id = findViewById(R.id.tv_id);
        tv_name = findViewById(R.id.tv_name);
        change_password = findViewById(R.id.change_password);

        if (user != null) {
            tv_id.setText("User ID:" + user.getId());
            tv_name.setText("User Name:" + user.getAccount_name());
        }
        else {
            tv_id.setText("User ID: null");
            tv_name.setText("User Name: null" );

        }

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Accounts.this, "Clicked", Toast.LENGTH_LONG).show();
            }
        });

    }
}
