package com.example.bookticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EditAccountHome extends AppCompatActivity {
    private Button btndeltAccount;
    private Button btnEditAccount;
    private Button backagain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account_home);

        btndeltAccount = findViewById(R.id.btndltAccount);
        btndeltAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {switch_activities(1);}
        });
        btnEditAccount = findViewById(R.id.btnEditAccount);
        btnEditAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {switch_activities(2);}
        });
        backagain = findViewById(R.id.backagain);
        backagain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {switch_activities(3);}
        });

    }
    private void switch_activities(int next_activity) {
        Intent switchActivityIntent;

        switch(next_activity) {
            case 1:
                switchActivityIntent = new Intent(this, DeleteAccount.class);
                break;
            case 2:
                switchActivityIntent = new Intent(this, EditExistingAccoung.class);
                break;
            case 3:
                switchActivityIntent = new Intent(this, SelectAccount.class);
                break;
            default:    return;
        }
        startActivity(switchActivityIntent);

    }
}