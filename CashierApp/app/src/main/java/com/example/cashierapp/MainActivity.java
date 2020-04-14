package com.example.cashierapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login_button;

    private TextView sign_up;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login_button = (Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAccount(username.getText().toString(), password.getText().toString());

            }
        });

        sign_up = (TextView) findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign_up = new Intent(MainActivity.this, Sign_up.class);
                startActivity(sign_up);

            }
        });

    }

    private void checkAccount(String username, String password){
        Context ct = getApplicationContext();
        int duaration = Toast.LENGTH_SHORT;

        if (username.equals("admin") && password.equals("admin")){
            Toast.makeText(ct, "Login Success", duaration).show();
            Intent it = new Intent(MainActivity.this, MainMenu.class);
            startActivity(it);
        }
        else{
            Toast.makeText(ct, "Incorrect Username or Password", duaration).show();

        }
    }
}
