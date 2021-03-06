package com.example.cashier.Modules;

import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cashier.Database.UserDao;
import com.example.cashier.Database.UserRoomDatabase;
import com.example.cashier.MainActivity;
import com.example.cashier.Models.User;
import com.example.cashier.R;

public class Sign_up extends AppCompatActivity {

    private EditText editName;
    private EditText editUserName;
    private EditText editPassword;
    private EditText editRePassword;

    private UserDao userDao;

    private ProgressDialog progressDialog;

    Button buttonCancel;
    Button buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sign up");
        setContentView(R.layout.activity_sign_up);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        editName = findViewById(R.id.name_input);
        editUserName = findViewById(R.id.username_input);
        editPassword = findViewById(R.id.password_input);
        editRePassword = findViewById(R.id.reenter_input);
        buttonCancel = findViewById(R.id.cancel_sign_up);
        buttonSignup = findViewById(R.id.confirm_sign_up);

        userDao = Room.databaseBuilder(this, UserRoomDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();


        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(Sign_up.this, MainActivity.class);
                startActivity(cancel);
                finish();
            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = editUserName.getText().toString();
                final String username = editUserName.getText().toString().trim();
                final String password = editPassword.getText().toString().trim();
                String passwordConf = editRePassword.getText().toString().trim();

                if (!isEmpty()) {
                    if (password.equals(passwordConf)){

                        progressDialog.show();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                User user = new User(name,username,password);
                                userDao.insert(user);
                                progressDialog.dismiss();
                                Toast.makeText(Sign_up.this, "Sign up success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Sign_up.this, MainActivity.class));
                                finish();
                            }
                        }, 1000);
                    }
                    else {
                        Toast.makeText(Sign_up.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Sign_up.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private boolean isEmpty() {
        if (TextUtils.isEmpty(editName.getText().toString()) ||
                TextUtils.isEmpty(editUserName.getText().toString()) ||
                TextUtils.isEmpty(editPassword.getText().toString()) ||
                TextUtils.isEmpty(editRePassword.getText().toString())
        ) {
            return true;
        } else {
            return false;
        }
    }
}
