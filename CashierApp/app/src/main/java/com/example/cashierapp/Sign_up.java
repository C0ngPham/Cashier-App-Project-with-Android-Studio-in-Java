package com.example.cashierapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Sign_up extends AppCompatActivity {

    Button cancel;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        cancel = findViewById(R.id.cancel_sign_up);
        add = findViewById(R.id.confirm_sign_up);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(Sign_up.this,MainActivity.class);
                startActivity(cancel);
            }
        });
    }
}
