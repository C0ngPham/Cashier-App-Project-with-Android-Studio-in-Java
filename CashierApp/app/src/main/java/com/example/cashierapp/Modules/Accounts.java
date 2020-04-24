package com.example.cashierapp.Modules;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cashierapp.Models.USER;
import com.example.cashierapp.R;

public class Accounts extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_id;
    private TextView change_password;
    private USER user;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        setTitle("Account");

        user = (USER) getIntent().getSerializableExtra("USER");

        tv_id = findViewById(R.id.tv_id);
        tv_name = findViewById(R.id.tv_name);
        change_password = findViewById(R.id.change_password);

        if (user != null) {
            tv_id.setText("User ID:" + user.getId());
            tv_name.setText("User Name:" + user.getAccount_name());
        }

    }
}
