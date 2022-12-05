package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< Updated upstream
import android.annotation.SuppressLint;
=======
//import android.annotation.SuppressLint;
>>>>>>> Stashed changes
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< Updated upstream
import android.widget.TextView;
=======
//import android.widget.TextView;
>>>>>>> Stashed changes


public class EditPrice extends AppCompatActivity {
    private Button btnSubmitPrice;
    private Button backbtn;
    private EditText editTextPrice;
<<<<<<< Updated upstream
    public int Price;
    TextView currentprice;



   // @SuppressLint("MissingInflatedId")
    @SuppressLint("MissingInflatedId")
=======

    public String Price;
   // TextView currentprice;



>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_price);
<<<<<<< Updated upstream
        Price =7;

        //currentprice = findViewById(R.id.currentprice);
        //currentprice.setText(Price);
=======

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream

                if(editTextPrice.getInputType()>0){
                    Price = editTextPrice.getInputType();
                    switch_activities(2);
                }

            }

    });}
=======
                Intent i = new Intent(EditPrice.this, PriceComfirm.class);
                Price = editTextPrice.getText().toString();
                i.putExtra("Price", Price);
                startActivity(i);
                finish();
                }

            });

        };
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
}
=======
}

>>>>>>> Stashed changes
