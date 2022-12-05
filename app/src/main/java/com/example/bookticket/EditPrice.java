
        package com.example.bookticket;

        import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;

        import android.content.Intent;
        import android.os.Bundle;
        import android.text.InputType;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;



public class EditPrice extends AppCompatActivity {
    private Button btnSubmitPrice;
    private Button backbtn;
    private EditText editTextPrice;

    public String Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_price);

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

    Intent i = new Intent(EditPrice.this, PriceComfirm.class);
    Price = editTextPrice.getText().toString();
                i.putExtra("Price", Price);
    startActivity(i);
    finish();
}

            });

                    };
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
        }}
