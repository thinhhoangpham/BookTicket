package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bookticket.models.Movie;

import org.parceler.Parcels;

public class PaymentConfirmation extends AppCompatActivity {
    private Button buttonConfirmationBtn;
    private Button buttonCancelBtn;

    TextView tv,tv1,tv2,tv3,tv4, tv5,time,spinnerData, movie;
    String st,st1,st2,st3,st4, st5,st_time,st_spinner, st_movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_confirmation);
        //display users card infor to confirm
        // 1st Name
        tv = findViewById(R.id.textView5);
        st = getIntent().getExtras().getString("Value",st);
        tv.setText(st);
        //2nd name
        tv1 = findViewById(R.id.textView6);
        st1 = getIntent().getExtras().getString("Value1",st1);
        tv1.setText(st1);
        //card info
        tv2 = findViewById(R.id.textView7);
        st2 = getIntent().getExtras().getString("Value2",st2);
        tv2.setText(st2);
        //expire month
        tv3 = findViewById(R.id.textView8);
        st3 = getIntent().getExtras().getString("Value3",st3);
        tv3.setText(st3);
        //expire year
        tv4 = findViewById(R.id.textView9);
        st4 = getIntent().getExtras().getString("Value4",st4);
        tv4.setText(st4);

        tv5 = findViewById(R.id.displayCVV);
        st5 = getIntent().getExtras().getString("Value5",st5);
        tv5.setText(st5);
        
        time = findViewById(R.id.DisplayTicketInfo);
        st_time = getIntent().getExtras().getString("Time1",st_time);
        time.setText(st_time);

        spinnerData = findViewById(R.id.NumberOfTickets);
        st_spinner = getIntent().getExtras().getString("data_spinner_1",st_spinner);
        spinnerData.setText(st_spinner);



        buttonConfirmationBtn = findViewById(R.id.buttonConfirmationBtn);
        buttonConfirmationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the database with the info and credentials entered by the user
                //switch_activities();
                //will need to create a unique ticket number
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