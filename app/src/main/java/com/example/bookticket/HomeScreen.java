package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    private Button btnToMovieCatalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Code from learntodroid.com
        btnToMovieCatalog = findViewById(R.id.btnToMovieCatalog);
        btnToMovieCatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities();
            }
        });
    }

    //Based on code from learntodroid.com
    private void switch_activities() {
        Intent switchActivityIntent;

        switchActivityIntent = new Intent(this, MovieCatalog.class);
        startActivity(switchActivityIntent);
    }
}