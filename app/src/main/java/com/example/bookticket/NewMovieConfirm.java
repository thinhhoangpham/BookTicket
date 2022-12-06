package com.example.bookticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bookticket.models.Movie;

import org.parceler.Parcels;

public class NewMovieConfirm extends AppCompatActivity {
    TextView moviename, moviesummary, movieposterURL;
    String Name,Summary,URL;
    private Button buttonConfirmationBtn;
    private Button buttonCancelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_movie_confirm);

        moviename = findViewById(R.id.movieName);
        Name = getIntent().getExtras().getString("Movie Name",Name);
        moviename.setText(Name);
        moviesummary = findViewById(R.id.movieSummary);
        Summary = getIntent().getExtras().getString("Movie Summary",Summary);
        moviesummary.setText(Summary);
        movieposterURL = findViewById(R.id.PosterURL);
        URL = getIntent().getExtras().getString("Poster URL", URL);
        movieposterURL.setText(URL);

        buttonConfirmationBtn = findViewById(R.id.ConfirmationBtn);
        buttonConfirmationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the database with the info and credentials entered by the user
                //switch_activities();
                finish();
            }
        });
        buttonCancelBtn = findViewById(R.id.CancelbtnNM);
        buttonCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the database with the info and credentials entered by the user
                //switch_activities();
                finish();
            }
        });
    }
}