package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    private EditText editTxtUsername;
    private EditText editTxtPassword;
    private Button btnLogin;
    private Button btnCreateAccount;
    private Button btnStaffLogin;
    private TextView txtViewLogin;
    public static final String TAG = "LoginActivity";

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
                loginUser(username, password);
//
//                ParseUser.logInInBackground(username, password, new LogInCallback() {
//                    public void done(ParseUser user, ParseException e) {
//                        if (user != null) {
//                            switch_activities(1);
//                        } else {
//                            txtViewLogin = findViewById(R.id.txtViewLogin);
//                            txtViewLogin.setText("Incorrect Username or Password./nPlease login again.");
//                        }
//                    }
//                });

                /*
                ParseUser.logInInBackground(username, password, (parseUser, e) -> {
                    if (parseUser != null) {
                        switch_activities(1);
                    } else {
                        txtViewLogin = findViewById(R.id.txtViewLogin);
                        txtViewLogin.setText("Incorrect Username or Password./nPlease login again.");
                    }
                });
                 */

            }
        });

        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(2);
            }
        });

        //btnStaffLogin = findViewById(R.id.btnStaffLogin);
//        btnStaffLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch_activities(3);
//            }
//        });
    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user " + username);

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with login", e);
                    Toast.makeText(MainActivity.this, "Issue with login!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (user.getBoolean("isAdmin") == false) {
                    //Navigate to the main activity if the user has signed in properly
                    switch_activities(1);
                    Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                }
                else {
                    switch_activities(3);
                }
            }
        });
    }

    //Based on code from learntodroid.com
    private void switch_activities(int next_activity) {
        Intent switchActivityIntent;

        switch(next_activity) {
            case 1:     switchActivityIntent = new Intent(this, MovieCatalog.class);
                        break;
            case 2:     switchActivityIntent = new Intent(this, SignUpActivity.class);
                        break;
            case 3:    switchActivityIntent = new Intent(this, StaffHome.class);
                        break;
            default:    return;
        }
        startActivity(switchActivityIntent);
    }
}