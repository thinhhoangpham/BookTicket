package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class stafflogin extends AppCompatActivity {

    private Button btnLoginstaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafflogin);

        btnLoginstaff = findViewById(R.id.btnLoginStaff);
        btnLoginstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(1);
            }
        });
    }

    private void switch_activities(int next_activity) {
        Intent switchActivityIntentStaff;
        switch (next_activity) {
            case 1:
                switchActivityIntentStaff = new Intent(this, StaffHome.class);
                break;
            default:    return;
        }
        startActivity(switchActivityIntentStaff);

    }
}