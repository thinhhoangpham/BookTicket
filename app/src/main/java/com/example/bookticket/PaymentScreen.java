package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.parceler.Parcels;

public class PaymentScreen extends AppCompatActivity {
    private Button buttonContinuePayment;
    private Button buttonCancelPayment;
    String text,text2,text3,text4,text5, text6;
   // TextView textView;
    EditText inputFirstName,inputLastName,inputCardNum,inputCardExMon,inputExYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_screen);

        inputFirstName = findViewById(R.id.editTextPaymentFirstName);
        inputLastName = findViewById(R.id.editTextPaymentLastName);
        inputCardNum = findViewById(R.id.CardNumber);
        inputCardExMon = findViewById(R.id.editExpirationMonth);
        inputExYear = findViewById(R.id.editExpirationYear);

        //Code from learntodroid.com
        buttonContinuePayment = findViewById(R.id.buttonContinuePayment);
        buttonContinuePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the database with the info and credentials entered by the user

                Intent i = new Intent(PaymentScreen.this,PaymentConfirmation.class);
                text = inputFirstName.getText().toString();
                i.putExtra("Value",text);
                text2 = inputLastName.getText().toString();
                i.putExtra("Value1",text2);
                text3 = inputCardNum.getText().toString();
                i.putExtra("Value2",text3);
                text4 = inputCardExMon.getText().toString();
                i.putExtra("Value3",text4);
                text5 = inputExYear.getText().toString();
                i.putExtra("Value4",text5);
                startActivity(i);

                switch_activities();
                //finish();
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
        switchActivityIntent = new Intent(this, PaymentConfirmation.class);
        startActivity(switchActivityIntent);
    }
}