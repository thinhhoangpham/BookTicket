package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    private EditText editTxtUsername;
    private EditText editTxtPassword;
    private Button btnLogin;
    private Button btnCreateAccount;
    private Button btnStaffLogin;
    private TextView txtViewLogin;
    //private Backend backend_aws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //backend_aws = new Backend(getApplicationContext());

        editTxtUsername = findViewById(R.id.editTxtUsername);
        editTxtPassword = findViewById(R.id.editTxtPassword);

        //Code from learntodroid.com
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code form geeksforgeeks.com
                String username = editTxtUsername.getText().toString();
                String password = editTxtPassword.getText().toString();

                ParseUser.logInInBackground(username, password, (parseUser, e) -> {
                    if (parseUser != null) {
                        switch_activities(1);
                    } else {
                        txtViewLogin = findViewById(R.id.txtViewLogin);
                        txtViewLogin.setText("Incorrect Username or Password./nPlease login again.");
                    }
                });
            }
        });

        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(2);
            }
        });

        btnStaffLogin = findViewById(R.id.btnStaffLogin);
        btnStaffLogin.setOnClickListener(new View.OnClickListener() {
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
            case 1:     switchActivityIntent = new Intent(this, MovieCatalog.class);
                        break;
            case 2:     switchActivityIntent = new Intent(this, CreateAccount.class);
                        break;
            case 3:    switchActivityIntent = new Intent(this, stafflogin.class);
                        break;
            default:    return;
        }
        startActivity(switchActivityIntent);
    }
}