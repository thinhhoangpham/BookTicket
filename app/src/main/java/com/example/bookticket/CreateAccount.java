package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateAccount extends AppCompatActivity {
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

        editTxtUsernameC = findViewById(R.id.editTxtUsernameC);
        editTxtPasswordC = findViewById(R.id.editTxtUsernameC);

        String username = editTxtUsernameC.getText().toString();
        String password = editTxtPasswordC.getText().toString();

        //Code from geeksforgeeks.com
        user.setUsername(username);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallBack() {
            @Override
            public void done(ParseException e) {
                if (e != null)
                    ParseUser.logOut();
            }
        });
    }
}