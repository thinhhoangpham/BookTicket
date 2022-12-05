package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookticket.models.Movie;

import org.parceler.Parcels;

public class PaymentConfirmation extends AppCompatActivity {
    private Button buttonConfirmationBtn;
    private Button buttonCancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_confirmation);

        buttonConfirmationBtn = findViewById(R.id.buttonConfirmationBtn);
        buttonConfirmationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the database with the info and credentials entered by the user
                //switch_activities();
                finish();
            }
        });
        buttonCancelBtn = findViewById(R.id.buttonCancelBtn);
        buttonCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the database with the info and credentials entered by the user
                //switch_activities();
                finish();
            }
        });

        //was checking to see if time can be passed to another activity
        //String time = Parcels.unwrap(getIntent().getParcelableExtra("time"));
        //buttonCancelBtn.setText(time);

    }
}