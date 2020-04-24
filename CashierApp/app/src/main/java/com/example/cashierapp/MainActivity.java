package com.example.cashierapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.cashierapp.Database.UserDao;
import com.example.cashierapp.Database.UserRoomDatabase;
import com.example.cashierapp.Models.USER;
import com.example.cashierapp.Modules.Sign_up;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login_button;
    private TextView sign_up;

    private UserRoomDatabase database;
    private UserDao userDao;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Check User...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        database = Room.databaseBuilder(this, UserRoomDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        userDao = database.getUserDao();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login_button);
        sign_up = findViewById(R.id.sign_up);


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign_up = new Intent(MainActivity.this, Sign_up.class);
                startActivity(sign_up);

            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!emptyValidation()) {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            String usr = username.getText().toString().trim();
                            String psw = password.getText().toString().trim();
                            USER user = userDao.getUser(usr, psw);

                            if(user!=null){
                                Intent i = new Intent(MainActivity.this, MainMenu.class);
                                i.putExtra("USER", user);
                                Toast.makeText(MainActivity.this, "Welcome to Cashier", Toast.LENGTH_SHORT).show();

                                startActivity(i);
                                finish();
                            }else{
                                Toast.makeText(MainActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    }, 1000);

                }else{
                    Toast.makeText(MainActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }
}
