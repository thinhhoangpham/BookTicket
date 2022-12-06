package com.example.bookticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class DeleteAccount extends AppCompatActivity {
    private Button backfromdlt;
    private Button DltAccountbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        backfromdlt = findViewById(R.id.backfromdlt);
        backfromdlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(1);
            }
        });

        DltAccountbtn = findViewById(R.id.DltAccountbtn);
        DltAccountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(2);
            }
        });
    }
    private void switch_activities(int next_activity) {
        Intent switchActivityIntent;

        switch(next_activity) {
            case 1:     switchActivityIntent = new Intent(this, EditAccountHome.class);
                break;
            case 2:     switchActivityIntent = new Intent(this, StaffHome.class);
                break;
            default:    return;
        }
        startActivity(switchActivityIntent);
    }
}