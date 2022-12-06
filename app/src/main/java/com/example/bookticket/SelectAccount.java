package com.example.bookticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SelectAccount extends AppCompatActivity {
    private Button backAccount;
    private Button EditExisting;
    private Button AddAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account);

        backAccount = findViewById(R.id.backAccount);
        backAccount.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {switch_activities(1);}
        });
        EditExisting = findViewById(R.id.EditExisting);
        EditExisting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {switch_activities(2);}
        });
        AddAccount = findViewById(R.id.AddAccount);
        AddAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {switch_activities(3);}
        });
    }
    private void switch_activities(int next_activity) {
        Intent switchActivityIntent;

        switch(next_activity) {
            case 1:
                switchActivityIntent = new Intent(this, StaffHome.class);
                break;
            case 2:
                switchActivityIntent = new Intent(this, EditAccountHome.class);
                break;
            case 3:    switchActivityIntent = new Intent(this, stafflogin.class);
                break;
            default:    return;
        }
        startActivity(switchActivityIntent);

    }
}