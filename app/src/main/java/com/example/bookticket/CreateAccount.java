package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateAccount extends AppCompatActivity {
    private EditText editTxtFirstName;
    private EditText editTxtLastName;
    private EditText editTxtEmailAddress;
    private EditText editTxtStreetAddress;
    private EditText editTxtCity;
    private EditText editTxtState;
    private EditText editTxtZIP;
    private EditText editTxtPhone;
    private EditText editTxtUsernameC;
    private EditText editTxtPasswordC;
    private Button btnRegister;
    private Button btnCancelReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //Code from learntodroid.com
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register_user();
                finish();
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

    private void register_user() {
        ParseUser user = new ParseUser();
        ParseObject user_data = new ParseObject("UserData");
        int error_flag = 1;

        editTxtFirstName = findViewById(R.id.editTxtFirstName);
        editTxtLastName = findViewById(R.id.editTxtLastName);
        editTxtEmailAddress = findViewById(R.id.editTxtEmailAddress);
        editTxtStreetAddress = findViewById(R.id.editTxtStreetAddress);
        editTxtCity = findViewById(R.id.editTxtCity);
        editTxtState = findViewById(R.id.editTxtState);
        editTxtZIP = findViewById(R.id.editTxtZIP);
        editTxtPhone = findViewById(R.id.editTxtPhone);
        editTxtUsernameC = findViewById(R.id.editTxtUsernameC);
        editTxtPasswordC = findViewById(R.id.editTxtUsernameC);

        String firstname = editTxtFirstName.getText().toString();
        String lastname = editTxtLastName.getText().toString();
        String email = editTxtEmailAddress.getText().toString();
        String street = editTxtStreetAddress.getText().toString();
        String city = editTxtCity.getText().toString();
        String state = editTxtState.getText().toString();
        String ZIP = editTxtZIP.getText().toString();
        String phone = editTxtPhone.getText().toString();
        String username = editTxtUsernameC.getText().toString();
        String password = editTxtPasswordC.getText().toString();

        //Code from geeksforgeeks.com & parseplatform.org
        user_data.put("username", username);
        user_data.put("firstname", firstname);
        user_data.put("lastname", lastname);
        user_data.put("email_address", email);
        user_data.put("street_address", street);
        user_data.put("city", city);
        user_data.put("state", state);
        user_data.put("ZIP", ZIP);
        user_data.put("phone", phone);
        user_data.put("permission_level", 0); //The 0 permission level is for regular users with no administrator access.

        user.setUsername(username);
        user.setPassword(password);

        user_data.saveInBackground();

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                Toast t;
                if (e == null) {
                    t = Toast.makeText(getApplicationContext(), "Successful account creation", Toast.LENGTH_LONG);
                    t.show();
                } else {
                    t = Toast.makeText(getApplicationContext(), "Error: account creation failed", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }
}