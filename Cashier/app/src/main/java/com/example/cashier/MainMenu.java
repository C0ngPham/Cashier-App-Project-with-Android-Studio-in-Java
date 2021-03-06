package com.example.cashier;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.cashier.Fragments.HistoryFragment;
import com.example.cashier.Fragments.HomeFragment;
import com.example.cashier.Fragments.PaymentFragment;
import com.example.cashier.Modules.Accounts;
import com.example.cashier.Modules.Settings;
public class MainMenu extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    FloatingActionButton add_item_button;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));

        add_item_button = findViewById(R.id.add_item_button);

        add_item_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_item = new Intent(MainMenu.this, AddItem.class);
                startActivity(add_item);
                finish();
            }
        });


    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }


    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.nav_pay:
                            openFragment(PaymentFragment.newInstance("", ""));
                            return true;
                        case R.id.nav_history:
                          openFragment(HistoryFragment.newInstance("", ""));
                        return true;
                    }
                    return false;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.account:
                Intent it1 = new Intent(MainMenu.this, Accounts.class);
                startActivity(it1);
                return true;

            case R.id.setting:
                Intent it2 = new Intent(MainMenu.this, Settings.class);
                startActivity(it2);
                return true;

            case R.id.about:
                AlertDialog.Builder bd = new AlertDialog.Builder(this);
                bd.setTitle("About");
                bd.setMessage("Cashier App: Version 1.0\nDeveloped by Cong Pham");

                AlertDialog alert = bd.create();
                alert.show();

                return true;

            case R.id.logout:

                AlertDialog.Builder bd2 = new AlertDialog.Builder(this);
                bd2.setTitle("Logging Out");
                bd2.setMessage("Do you want to log out this account?");
                bd2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainMenu.this, "Logged Out", Toast.LENGTH_LONG).show();
                        Intent it3 = new Intent(MainMenu.this, MainActivity.class);
                        startActivity(it3);
                        finish();
                    }
                });
                bd2.setNegativeButton("Cancel",null);
                AlertDialog alert2 = bd2.create();

                alert2.show();

                Button no = alert2.getButton(DialogInterface.BUTTON_NEGATIVE);
                //Set negative button text color
                no.setTextColor(Color.RED);

                Button yes = alert2.getButton(DialogInterface.BUTTON_POSITIVE);
                //Set positive button text color
                yes.setTextColor(Color.DKGRAY);


                return true;

            default:
                return super.onOptionsItemSelected(item);
        } }


}
