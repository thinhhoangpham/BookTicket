package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bookticket.models.Movie;

import org.parceler.Parcels;
public class PriceComfirm extends AppCompatActivity {
    private Button buttonConfirmationBtn;
    TextView tv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_comfirm);
        tv=findViewById(R.id.priceview);
        st = getIntent().getExtras().getString("Price",st);
        tv.setText(st);

        buttonConfirmationBtn = findViewById(R.id.buttonConfirmationBtn);
        buttonConfirmationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the database with the info and credentials entered by the user
                //switch_activities();
                finish();
            }
        });

    }
}
