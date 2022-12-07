package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "SignUpActivity";
    private EditText editTxtFirstName;
    private EditText editTxtLastName;
    private EditText editTxtEmailAddress;
    private EditText editTxtUsernameC;
    private EditText editTxtPasswordC;
    private EditText editTxtPasswordConfirm;
    private Button btnRegister;
    private Button btnCancelReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTxtFirstName = findViewById(R.id.editTxtFirstName);
        editTxtLastName = findViewById(R.id.editTxtLastName);
        editTxtEmailAddress = findViewById(R.id.editTxtEmailAddress);
        editTxtUsernameC = findViewById(R.id.editTxtUsernameC);
        editTxtPasswordC = findViewById(R.id.editTxtPasswordC);
        editTxtPasswordConfirm = findViewById(R.id.editTxtPasswordConfirm);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTxtUsernameC.getText().toString();
                String password = editTxtPasswordC.getText().toString();
                String password2 = editTxtPasswordConfirm.getText().toString();
                if (password.equals(password2)) {
                    signUpUser(username, password);
                } else {
                    Toast.makeText(SignUpActivity.this, "Password must match!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancelReg = findViewById(R.id.btnCancelReg);
        btnCancelReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void signUpUser(String username, String password) {
        Log.i(TAG, "Attempting to sign up user" + username);

        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);

        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignUpActivity.this, "Sign Up success!", Toast.LENGTH_SHORT).show();
                    switch_activities(1);

                } else {
                    Log.e(TAG, "Issue with sign up", e);
                    Toast.makeText(SignUpActivity.this, "Issue with sign up!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

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