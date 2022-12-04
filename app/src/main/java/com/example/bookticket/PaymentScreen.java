package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentScreen extends AppCompatActivity {
    private Button buttonContinuePayment;
    private Button buttonCancelPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_screen);

        //Code from learntodroid.com
        buttonContinuePayment = findViewById(R.id.buttonContinuePayment);
        buttonContinuePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the database with the info and credentials entered by the user
                switch_activities();
                finish();
            }
        });

        buttonCancelPayment = findViewById(R.id.buttonCancelPayment);
        buttonCancelPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void switch_activities() {
        Intent switchActivityIntent;
        //only switching to catalog to make sure button works haven't implemented a payment confirmation page yet
        switchActivityIntent = new Intent(this, MovieCatalog.class);
        startActivity(switchActivityIntent);
    }
}