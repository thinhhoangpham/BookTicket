package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EditPrice extends AppCompatActivity {
    private Button btnSubmitPrice;
    private Button backbtn;
    private EditText editTextPrice;
    public int Price;
    TextView currentprice;


    //TextView textPrice;

   // @SuppressLint("MissingInflatedId")
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_price);
        Price =7;

        currentprice = findViewById(R.id.currentprice);
        currentprice.setText(Price);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        editTextPrice.setInputType(InputType.TYPE_CLASS_NUMBER);
        backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_activities(1);
            }
        });
        btnSubmitPrice = findViewById(R.id.btnSubmitPrice);
        btnSubmitPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextPrice.getInputType()>0){
                    Price = editTextPrice.getInputType();
                    switch_activities(2);
                }

            }

    });}
    private void switch_activities(int next_activity) {
        Intent switchActivityIntent;

        switch (next_activity) {
            case 1:
            case 2:
                switchActivityIntent = new Intent(this, StaffHome.class);
                break;

            default:    return;
        }
        startActivity(switchActivityIntent);
    }
}