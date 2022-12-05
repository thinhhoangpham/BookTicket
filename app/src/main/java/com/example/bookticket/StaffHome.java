package com.example.bookticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StaffHome extends AppCompatActivity {
    private Button btnEditMoviePrices;
    private Button btnEditMovieCatalog;
    private Button btnEditAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);

        //Code from learntodroid.com
        btnEditMoviePrices = findViewById(R.id.btnEditMoviePrices);
        btnEditMoviePrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(1);
            }
        });
        btnEditMovieCatalog = findViewById(R.id.btnEditMovieCatalog);
        btnEditMovieCatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(2);
            }
        });
        btnEditAccounts = findViewById(R.id.btnEditAccounts);
        btnEditAccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(3);
            }
        });
    }

    //Based on code from learntodroid.com
    private void switch_activities(int next_activity) {
        Intent switchActivityIntent;

        switch(next_activity) {
            case 1:
                switchActivityIntent = new Intent(this, EditPrice.class);
                break;
            case 2:
                switchActivityIntent = new Intent(this, CreateAccount.class);
                break;
            case 3:    switchActivityIntent = new Intent(this, stafflogin.class);
                break;
            default:    return;
        }
        startActivity(switchActivityIntent);

    }
}