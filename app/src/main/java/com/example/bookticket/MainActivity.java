package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    Button btnCreateAccount;
    TextView txtViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code from learntodroid.com
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: verify credentials before switching activities
                //if (credentials are correct) {
                    switch_activities(1);
                /*} else {
                    txtViewLogin = findViewById(R.id.txtViewLogin);
                    txtViewLogin.setText("Incorrect Username or Password./nPlease login again.");
                }*/
            }
        });

        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(2);
            }
        });
    }

    //Based on code from learntodroid.com
    private void switch_activities(int next_activity) {
        Intent switchActivityIntent;

        switch(next_activity) {
            case 1:     switchActivityIntent = new Intent(this, HomeScreen.class);
                        break;
            case 2:     switchActivityIntent = new Intent(this, CreateAccount.class);
                        break;
            default:    return;
        }
        startActivity(switchActivityIntent);
    }
}